package com.bdqn.controller;


import com.alibaba.fastjson.JSON;
import com.bdqn.entity.Smbms_bill;
import com.bdqn.entity.Smbms_user;
import com.bdqn.service.ProductService;
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
public class BillController {
    @Resource
    private ProductService productService;

    /**
     * 查询所有 订单
     * @param smbms_bill
     * @return modelAndView
     */
    @RequestMapping("/findAllBill")
    public ModelAndView findAllBill(Smbms_bill smbms_bill){
        List<Smbms_bill> smbms_bills = productService.queryAll(smbms_bill.getProductName(), smbms_bill.getIsPayment(), smbms_bill.getProviderId());
         ModelAndView modelAndView=new ModelAndView();
         modelAndView.addObject("billList",smbms_bills);
         modelAndView.setViewName("billlist");
         if(smbms_bill!=null){
             modelAndView.addObject("bill",smbms_bill);
         }
        return  modelAndView;
    }
    //查询 对象根据id
    @RequestMapping("/findBillByid")
    public ModelAndView findBillByid(Smbms_bill smbms_bill){
        Smbms_bill query = productService.query(smbms_bill);
        ModelAndView modelAndView=new ModelAndView();

        if(smbms_bill!=null){
            modelAndView.setViewName("billview");
            modelAndView.addObject("bill",query);
        }else{
            modelAndView.setViewName("error");
        }
        return  modelAndView;
    }

    /**
     * 更新时先查询对象根据id
     * @param smbms_bill
     * @return
     */
    @RequestMapping("/updateAndFindBillByid")
    public ModelAndView updateAndFindBillByid(Smbms_bill smbms_bill){
        Smbms_bill query = productService.query(smbms_bill);
        ModelAndView modelAndView=new ModelAndView();

        if(smbms_bill!=null){
            modelAndView.setViewName("billmodify");
            modelAndView.addObject("bill",query);
        }else{
            modelAndView.setViewName("error");
        }
        return  modelAndView;
    }
      @RequestMapping("/updateBillbyId")
       public String updateBillbyId(Smbms_bill smbms_bill,HttpSession session){
          Smbms_user user = (Smbms_user)session.getAttribute("user");
           smbms_bill.setModifyBy(user.getId());
           smbms_bill.setModifyDate(new Date());
           Integer integer = productService.updateBill(smbms_bill);
            if(integer>0){
              return "redirect:findAllBill";
            }
           return "error";
       }
       @ResponseBody
       @RequestMapping("/delBill")
       public String delBill(Smbms_bill smbms_bill){

           Integer integer = productService.delBill(smbms_bill);
           Map<String,Object> m =new HashMap<String, Object>();
           if(integer>0){
               m.put("delResult","true");
           }else{
               m.put("delResult","false");
           }
           String s = JSON.toJSONString(m);
           return s;
       }
       @RequestMapping("/addBill")
       public String addBill(Smbms_bill smbms_bill, HttpSession session){
           Smbms_user user = (Smbms_user)session.getAttribute("user");
           smbms_bill.setCreatedBy(user.getId());
           smbms_bill.setCreationDate(new Date());
           Integer integer = productService.addBill(smbms_bill);
          if(integer>0){
              return "redirect:findAllBill";
          }
           return "error";
       }
}
