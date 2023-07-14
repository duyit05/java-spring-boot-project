package com.cybersoft.osahaneat.request;

import java.util.Date;

public class OrderRequest {
    private int userId;
    private int resId;

    private Date dateOrder;
    private int foodId [];

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public int[] getFoodId() {
        return foodId;
    }

    public void setFoodId(int[] foodId) {
        this.foodId = foodId;
    }
}
