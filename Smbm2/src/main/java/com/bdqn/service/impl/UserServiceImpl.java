package com.bdqn.service.impl;


import com.bdqn.entity.Pager;
import com.bdqn.entity.Smbms_user;
import com.bdqn.mapper.UserMapper;
import com.bdqn.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    public Smbms_user login(Smbms_user smbms_user) {
        return userMapper.login(smbms_user);
    }

    public Pager<Smbms_user> queryUsers(Smbms_user smbms_user, Integer pageNo, Integer pageSize) {
        Pager<Smbms_user> pager = new Pager<Smbms_user>();
        pager.setPageNo(pageNo);
        pager.setPageSize(pageSize);
        pager.setTotalRow(userMapper.countRows(smbms_user));
        pager.setTotalPage((pager.getTotalRow()+pageSize-1)/pageSize);
        pager.setDates(userMapper.queryList(smbms_user,(pageNo-1)*pageSize,pageSize));
        return pager;
    }

    public Smbms_user queryByid(Smbms_user smbms_user) {
        return userMapper.queryByid(smbms_user);
    }

    public Integer delUser(Smbms_user smbms_user) {
        return userMapper.delUser(smbms_user);
    }
    public Integer updateUser(Smbms_user smbms_user) {
        return userMapper.updateUser(smbms_user);
    }

    public Integer addUser(Smbms_user smbms_user) {
        return userMapper.addUser(smbms_user);
    }

    public Smbms_user checkPwd(Smbms_user smbms_user) {
        return userMapper.checkPwd(smbms_user);
    }

    public Integer upPwd(Smbms_user smbms_user) {
        return userMapper.upPwd(smbms_user);
    }

}


