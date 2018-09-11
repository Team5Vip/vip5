package com.bdqn.mapper;


import com.bdqn.entity.Smbms_bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductMapper {
    /**
     * 条件查询单个
     * @param maps
     * @return
     */
   Smbms_bill findAll(Map<String, Object> maps);

    /**
     * 查询所有
     * @return
     */
   List<Smbms_bill> queryAll(@Param("queryProductName") String queryProductName, @Param("queryIsPayment") Integer queryIsPayment, @Param("queryProviderId") Integer queryProviderId);
   Integer addBill(Smbms_bill smbms_bill);
   Integer updateBill(Smbms_bill smbms_bill);
   Integer delBill(Smbms_bill smbms_bill);
   Smbms_bill  query(Smbms_bill smbms_bill);
}
