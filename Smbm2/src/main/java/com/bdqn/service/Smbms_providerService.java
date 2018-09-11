package com.bdqn.service;

import com.bdqn.entity.Smbms_provider;

import java.util.List;
import java.util.Map;

public interface Smbms_providerService {

    List<Smbms_provider> list();
    List<Smbms_provider> query(Map map);
    Smbms_provider queryByid(Smbms_provider smbms_provider);
    Integer update(Smbms_provider smbms_provider);
    Integer delPro(Smbms_provider smbms_provider);
    Integer addPro(Smbms_provider smbms_provider);
}
