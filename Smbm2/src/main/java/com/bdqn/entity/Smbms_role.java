package com.bdqn.entity;

import java.util.Date;

public class Smbms_role {

    private Integer id ;
    private String roleCode;
    private String  roleName;
    private Integer createBy;
    private Date creattionDate;
    private Integer  modifyBy;
    private Date modifyDate;

    public Smbms_role() {
    }

    public Smbms_role(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreattionDate() {
        return creattionDate;
    }

    public void setCreattionDate(Date creattionDate) {
        this.creattionDate = creattionDate;
    }

    public Integer getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
