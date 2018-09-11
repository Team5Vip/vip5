package com.bdqn.service.impl;


import com.bdqn.entity.Smbms_role;
import com.bdqn.mapper.Smbms_roleMapper;
import com.bdqn.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private Smbms_roleMapper smbms_roleMapper;
    public List<Smbms_role> queryRoleList() {

        return  smbms_roleMapper.queryRoleList();
    }
}
