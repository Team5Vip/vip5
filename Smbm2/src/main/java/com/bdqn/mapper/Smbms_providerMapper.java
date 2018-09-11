package com.bdqn.mapper;


import com.bdqn.entity.Smbms_provider;

import java.util.List;
import java.util.Map;

public interface Smbms_providerMapper {
      List<Smbms_provider> list();
      List<Smbms_provider> query(Map map);
      Smbms_provider queryByid(Smbms_provider smbms_provider);//根据id查询
      Integer update(Smbms_provider smbms_provider);//修改
      Integer delPro(Smbms_provider smbms_provider);//删除
      Integer addPro(Smbms_provider smbms_provider);//添加

}
