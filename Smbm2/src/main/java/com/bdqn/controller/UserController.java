package com.bdqn.controller;


import com.alibaba.fastjson.JSON;
import com.bdqn.entity.Pager;
import com.bdqn.entity.Smbms_role;
import com.bdqn.entity.Smbms_user;
import com.bdqn.service.RoleService;
import com.bdqn.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController extends BaseController {
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @RequestMapping("/login")
    public String Login(Smbms_user smbms_user, HttpSession session){
        Smbms_user user = userService.login(smbms_user);
         if(user!=null){
             session.setAttribute("user",user );
             return "frame";
         }else{
             throw  new RuntimeException("用户名或者密码不正确");
         }
    }
    @RequestMapping("/queryAllUser")
    public ModelAndView queryAll(Smbms_user smbms_user, Integer pageNo){
        ModelAndView mv =new ModelAndView();
        if(pageNo==null){
            pageNo=1;
        }
        if(smbms_user==null){
            smbms_user=new Smbms_user();
         }
        Pager<Smbms_user> smbms_userPager = userService.queryUsers(smbms_user, pageNo, 2);
         mv.addObject("pager", smbms_userPager);
        List<Smbms_role> smbms_roles = roleService.queryRoleList();
        mv.setViewName("userlist");
        return mv;
    }
    //查询 对象根据id
    @RequestMapping("/findUserByid")
    public ModelAndView findUserByid(Smbms_user smbms_user){
        Smbms_user user = userService.queryByid(smbms_user);
        ModelAndView modelAndView=new ModelAndView();
        if(user!=null){
            modelAndView.setViewName("userview");
            modelAndView.addObject("user",user);
        }else{
            modelAndView.setViewName("error");
        }
        return  modelAndView;
    }

    /**
     * 更新时先查询对象根据id
     * @param smbms_user
     * @return
     */
    @RequestMapping("/updateAndFindUserByid")
    public ModelAndView updateAndFindUserByid(Smbms_user smbms_user){
        Smbms_user user = userService.queryByid(smbms_user);
        ModelAndView modelAndView=new ModelAndView();

        if(user!=null){
            modelAndView.setViewName("usermodify");
            modelAndView.addObject("user",user);
        }else{
            modelAndView.setViewName("error");
        }
        return  modelAndView;
    }
    @RequestMapping("/updateUserbyId")
    public String updateUserbyId(Smbms_user smbms_user,HttpSession session){
        Smbms_user user = (Smbms_user)session.getAttribute("user");
        smbms_user.setModifyBy(user.getId().toString());
        smbms_user.setModifyDate(new Date());
        Integer integer = userService.updateUser(smbms_user);
        if(integer>0){
            return "redirect:queryAllUser";
        }
        return "error";
    }
    @ResponseBody
    @RequestMapping("/delUser")
    public String delUser(Smbms_user smbms_user){
        Integer integer = userService.delUser(smbms_user);
        Map<String,Object> m =new HashMap<String, Object>();
        if(integer>0){
            m.put("delResult","true");
        }else{
            m.put("delResult","false");
        }
        String s = JSON.toJSONString(m);
        return s;
    }
    @RequestMapping("/addUser")
    public String addUser(Smbms_user smbms_user,HttpSession session){
        Smbms_user user = (Smbms_user)session.getAttribute("user");
        smbms_user.setCreatedBy(user.getId().toString());
        smbms_user.setCreationDate(new Date());
        Integer integer = userService.addUser(smbms_user);
        if(integer>0){
            return "redirect:queryAllUser";
        }
        return "error";
    }
    @RequestMapping("/upPwd")
    public String upPwd(Smbms_user smbms_user,HttpSession session){
        Smbms_user user = (Smbms_user)session.getAttribute("user");
        smbms_user.setId(user.getId());
        Integer integer = userService.upPwd(smbms_user);
        if(integer>0){
            return "redirect:toLogin" ;
        }else{
            throw new RuntimeException("修改密码失败");
        }
    }
    @RequestMapping("/toUpPwd")
    public String toUpPwd(){
        return "pwdmodify";
    }
    @RequestMapping("/userExit")
    public String userExit(HttpSession session){
        session.removeAttribute("user");
      return "login";
    }
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
}
