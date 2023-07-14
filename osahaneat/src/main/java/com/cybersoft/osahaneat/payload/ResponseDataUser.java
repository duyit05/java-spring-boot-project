package com.cybersoft.osahaneat.payload;

/*
   {
      status : 200
      dest :""
      data : {}
   }
*/

public class ResponseDataUser {
    private int status = 200;
    private boolean issucess;
    private String desc;
    private Object data;

    public boolean isIssucess() {
        return issucess;
    }

    public void setIssucess(boolean issucess) {
        this.issucess = issucess;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
