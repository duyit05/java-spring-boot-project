package com.cybersoft.osahaneat.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "title")
    private String title;

    @Column (name = "sub_title")
    private String subTile;

    @Column (name = "description")
    private String description;

    @Column (name = "image")
    private String image;

    @Column(name="is_freeship")
    private boolean isFreeShip;

    public boolean isFreeShip() {
        return isFreeShip;
    }

    public void setFreeShip(boolean freeShip) {
        isFreeShip = freeShip;
    }

    @Column (name = "address")
    private String address;

    @Column (name = "open_date")
    private Date openDate;

    @OneToMany (mappedBy = "restaurant")
    private List<RatingRestaurant> ratingRestaurantList;

    @OneToMany (mappedBy = "restaurant")
    private List<Order> orderList;
    public List<RatingRestaurant> getRatingRestaurantList() {
        return ratingRestaurantList;
    }

    @OneToMany (mappedBy = "restaurant")
    private List<MenuRestaurant>restaurantList;

    @OneToMany (mappedBy = "restaurant")
    private List<Promo> promoList;

    public List<Promo> getPromoList() {
        return promoList;
    }

    public void setPromoList(List<Promo> promoList) {
        this.promoList = promoList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<MenuRestaurant> getRestaurantList() {
        return restaurantList;
    }

    public void setRestaurantList(List<MenuRestaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }

    public void setRatingRestaurantList(List<RatingRestaurant> ratingRestaurantList) {
        this.ratingRestaurantList = ratingRestaurantList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTile() {
        return subTile;
    }

    public void setSubTile(String subTile) {
        this.subTile = subTile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }
}
