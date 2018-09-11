package com.bdqn.controller;
import com.alibaba.fastjson.JSON;
import com.bdqn.entity.Smbms_provider;
import com.bdqn.entity.Smbms_user;
import com.bdqn.service.Smbms_providerService;
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
public class ProviderController {
    @Resource
    private Smbms_providerService smbms_providerService;
    @RequestMapping("/queryPro")
    @ResponseBody
     public String queryPro(){
         List<Smbms_provider> list = smbms_providerService.list();
         String s = JSON.toJSONString(list);
         return s;
    }
    @RequestMapping("/queryAll")
    public ModelAndView queryAll(Smbms_provider smbms_provider){
        ModelAndView modelAndView =new ModelAndView();
        Map m =new HashMap<String,Object>();
        m.put("proCode",smbms_provider.getProCode());
        m.put("proName",smbms_provider.getProName());
        List<Smbms_provider> query = smbms_providerService.query(m);
        modelAndView.addObject("providerList",query);
        modelAndView.setViewName("providerlist");
        return modelAndView;
    }
    @RequestMapping("/queryProList")
    @ResponseBody
    public String queryProList(){
        List<Smbms_provider> list = smbms_providerService.list();
        return JSON.toJSONString(list);
    }
    //查询 对象根据id
    @RequestMapping("/findProByid")
    public ModelAndView findProByid(Smbms_provider smbms_provider){
        Smbms_provider smbms_provider1 = smbms_providerService.queryByid(smbms_provider);
        ModelAndView modelAndView=new ModelAndView();

        if(smbms_provider1!=null){
            modelAndView.setViewName("providerview");
            modelAndView.addObject("smbms_provider",smbms_provider1);
        }else{
            modelAndView.setViewName("error");
        }
        return  modelAndView;
    }
    /**
     * 更新时先查询对象根据id
     * @param smbms_provider
     * @return
     */
    @RequestMapping("/updateAndFindProByid")
    public ModelAndView updateAndFindProByid(Smbms_provider  smbms_provider){
        ModelAndView modelAndView=new ModelAndView();
        Smbms_provider smbms_provider1 = smbms_providerService.queryByid(smbms_provider);
        if(smbms_provider1!=null){
            modelAndView.setViewName("providermodify");
            modelAndView.addObject("smbms_provider",smbms_provider1);
        }else{
            modelAndView.setViewName("error");
        }
        return  modelAndView;
    }
    @RequestMapping("/updateProbyId")
    public String updateProbyId(Smbms_provider smbms_provider,HttpSession session){
        Smbms_user user = (Smbms_user)session.getAttribute("user");
        smbms_provider.setModifyBy(user.getId().toString());
        smbms_provider.setModifyDate(new Date());
        Integer integer = smbms_providerService.update(smbms_provider);
        if(integer>0){
            return "redirect:queryAll";
        }
        return "error";
    }
    @ResponseBody
    @RequestMapping("/delPro")
    public String delPro(Smbms_provider smbms_provider){
        Integer integer = smbms_providerService.delPro(smbms_provider);
        Map<String,Object> m =new HashMap<String, Object>();
        if(integer>0){
            m.put("delResult","true");
        }else{
            m.put("delResult","false");
        }
        String s = JSON.toJSONString(m);
        return s;
    }
    @RequestMapping("/addPro")
    public String addPro(Smbms_provider smbms_provider, HttpSession session){
        Smbms_user user = (Smbms_user)session.getAttribute("user");
        smbms_provider.setCreatesBy(user.getId());
        smbms_provider.setCreationDate(new Date());
        Integer integer = smbms_providerService.addPro(smbms_provider);
        if(integer>0){
            return "redirect:queryAll";
        }
        return "error";
    }
}
