package com.bdqn.service;

import com.bdqn.entity.Pager;
import com.bdqn.entity.Smbms_user;

public interface UserService {
    Smbms_user login(Smbms_user smbms_user);
     Pager<Smbms_user> queryUsers(Smbms_user smbms_user, Integer pageNo, Integer pageSize);
    Smbms_user queryByid(Smbms_user smbms_user);
    Integer delUser(Smbms_user smbms_user);
    Integer updateUser(Smbms_user smbms_user);
    Integer addUser(Smbms_user smbms_user);
    Smbms_user checkPwd(Smbms_user smbms_user);
    Integer upPwd(Smbms_user smbms_user);
}
