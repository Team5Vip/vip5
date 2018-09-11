package com.bdqn.controller;


import com.alibaba.fastjson.JSON;
import com.bdqn.entity.Smbms_role;
import com.bdqn.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class RoleController {
    @Resource
    private RoleService roleService;
    @RequestMapping("/queryRole")
    @ResponseBody
    public String queryRole(){
        List<Smbms_role> smbms_roles = roleService.queryRoleList();
        return JSON.toJSONString(smbms_roles);
    }
}
