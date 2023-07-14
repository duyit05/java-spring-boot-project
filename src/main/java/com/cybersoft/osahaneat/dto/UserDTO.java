package com.cybersoft.osahaneat.dto;


import java.util.Date;

// trả dữ liệu ra cho người dùng thì viết ở đây

public class UserDTO {
    private  int id;
    private String username;
    private String password;
    private String fullname;
    private Date createDate;

    public UserDTO() {
    }

    public UserDTO(int id, String username, String password, String fullname, Date createDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
