package com.bdqn.service.impl;


import com.bdqn.entity.Smbms_provider;
import com.bdqn.mapper.Smbms_providerMapper;
import com.bdqn.service.Smbms_providerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class Smbms_providerServiceImpl implements Smbms_providerService {
    @Resource
    private Smbms_providerMapper smbms_providerMapper;
    public List<Smbms_provider> list() {
        return smbms_providerMapper.list();
    }

    public List<Smbms_provider> query(Map map) {
        return smbms_providerMapper.query(map);
    }

    public Smbms_provider queryByid(Smbms_provider smbms_provider) {

        return  smbms_providerMapper.queryByid(smbms_provider);
    }

    public Integer update(Smbms_provider smbms_provider) {
        return smbms_providerMapper.update(smbms_provider);
    }

    public Integer delPro(Smbms_provider smbms_provider) {

        return smbms_providerMapper.delPro(smbms_provider);
    }

    public Integer addPro(Smbms_provider smbms_provider) {
        return smbms_providerMapper.addPro(smbms_provider);
    }
}
