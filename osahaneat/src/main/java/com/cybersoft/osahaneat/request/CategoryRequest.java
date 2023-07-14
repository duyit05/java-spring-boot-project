package com.cybersoft.osahaneat.request;

import javax.xml.crypto.Data;
import java.util.Date;

public class CategoryRequest {
    private String nameCate;
    private Date createDate;

    public String getNameCate() {
        return nameCate;
    }

    public void setNameCate(String nameCate) {
        this.nameCate = nameCate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
