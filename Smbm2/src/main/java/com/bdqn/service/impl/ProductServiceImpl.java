package com.bdqn.service.impl;


import com.bdqn.entity.Smbms_bill;
import com.bdqn.mapper.ProductMapper;
import com.bdqn.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;

    public List<Smbms_bill> queryAll(String queryProductName, Integer queryProviderId, Integer queryIsPayment) {
        return productMapper.queryAll(queryProductName,queryProviderId,queryIsPayment);
    }

    public Integer addBill(Smbms_bill smbms_bill) {
        return productMapper.addBill(smbms_bill);
    }

    public Integer updateBill(Smbms_bill smbms_bill) {
        return productMapper.updateBill(smbms_bill);
    }

    public Integer delBill(Smbms_bill smbms_bill) {
        return productMapper.delBill(smbms_bill);
    }

    public Smbms_bill query(Smbms_bill smbms_bill) {
        return productMapper.query(smbms_bill);
    }
}
