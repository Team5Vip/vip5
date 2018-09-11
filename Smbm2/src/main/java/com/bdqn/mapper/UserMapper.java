package com.bdqn.mapper;


import com.bdqn.entity.Smbms_user;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    Smbms_user login(Smbms_user smbms_user);
    List<Smbms_user> queryList(@Param("user") Smbms_user user, @Param("from") Integer from, @Param("pageSize") Integer pageSize);
    Integer countRows(@Param("user") Smbms_user user);
    Smbms_user queryByid(Smbms_user smbms_user);
    Integer delUser(Smbms_user smbms_user);
    Integer updateUser(@Param("user") Smbms_user smbms_user);
    Integer addUser(Smbms_user smbms_user);
    Smbms_user checkPwd(Smbms_user smbms_user);
    Integer upPwd(Smbms_user smbms_user);
}
