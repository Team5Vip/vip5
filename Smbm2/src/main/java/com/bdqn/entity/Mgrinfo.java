package com.bdqn.entity;

import java.io.Serializable;
import java.util.Date;

public class Mgrinfo implements Serializable {

   private Integer id;
    private String   typestr ;
    private double   price;
    private Date buyDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypestr() {
        return typestr;
    }

    public void setTypestr(String typestr) {
        this.typestr = typestr;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    @Override
    public String toString() {
        return "Mgrinfo{" +
                "id=" + id +
                ", typestr='" + typestr + '\'' +
                ", price=" + price +
                ", buyDate=" + buyDate +
                '}';
    }
}
