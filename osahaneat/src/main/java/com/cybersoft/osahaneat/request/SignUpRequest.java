package com.cybersoft.osahaneat.request;


import java.util.Date;

// class này dùng để nhận thông tin từ người dùng
// chuwcs năng insert
public class SignUpRequest {

    private String fullName;
    private String username;
    private String password;
//    private Date createDate;
    private int roleId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
