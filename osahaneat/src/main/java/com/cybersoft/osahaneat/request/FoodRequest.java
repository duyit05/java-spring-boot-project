package com.cybersoft.osahaneat.request;

public class FoodRequest {
    private String title;
    private String image;
    private String timeShip;
    private String isFreeShip;
    private int price;
    private int cateId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTimeShip() {
        return timeShip;
    }

    public void setTimeShip(String timeShip) {
        this.timeShip = timeShip;
    }

    public String getIsFreeShip() {
        return isFreeShip;
    }

    public void setIsFreeShip(String isFreeShip) {
        this.isFreeShip = isFreeShip;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }
}
