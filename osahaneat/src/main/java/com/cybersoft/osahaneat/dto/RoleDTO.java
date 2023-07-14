package com.cybersoft.osahaneat.dto;

import java.util.Date;

// class trả dữ liệu cho người dùng
public class RoleDTO {
    private  int id;
    private String roleName;
    private Date createDate ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
