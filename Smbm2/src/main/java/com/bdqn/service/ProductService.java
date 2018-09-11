package com.bdqn.service;


import com.bdqn.entity.Smbms_bill;

import java.util.List;

public interface ProductService {

    /**
     * 查询所有
     * @return
     */
    List<Smbms_bill> queryAll(String queryProductName, Integer queryIsPayment, Integer queryProviderId);
    Integer addBill(Smbms_bill smbms_bill);
    Integer updateBill(Smbms_bill smbms_bill);
    Integer delBill(Smbms_bill smbms_bill);
    Smbms_bill  query(Smbms_bill smbms_bill);

}
