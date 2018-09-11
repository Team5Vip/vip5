package com.bdqn.entity;

import java.util.Calendar;
import java.util.Date;

/**
 * 用户类
 */
public class Smbms_user {

    private Integer id;
    private String  userCode;
    private String  userName ;
    private String userPassword;
    private Integer  gender;
    private Date   birthday;
    private String phone ;
    private String address;
    private Integer  userRole;
    private String createdBy;
    private Date  creationDate;
    private String  modifyBy ;
    private Date modifyDate;
    private Integer age;
    private Smbms_role role;

    public Smbms_role getRole() {
        return role;
    }

    public void setRole(Smbms_role role) {
        this.role = role;
    }

    public Integer getAge() {
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(birthday);
        int birthday = calendar.get(Calendar.YEAR);
        Calendar c2=Calendar.getInstance();
        c2.setTime(new Date());
        int nowYear = c2.get(Calendar.YEAR);
        age=nowYear-birthday;
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getGender() {
        return gender;
    }
    public void setGender(Integer gender) {
        this.gender = gender;
    }
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
