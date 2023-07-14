package com.cybersoft.osahaneat.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.*;

import java.util.List;


@Entity (name = "food")
public class Food {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "title")
    private String title;

    @Column (name = "image")
    private String image;

    @Column (name = "time_ship")
    private String timeShip;

    @Column (name = "is_free_ship")
    private boolean isFreeShip;

    @Column (name = "price")
    private double price;


    @Column(name = "des")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne
    @JoinColumn(name = "cate_id")
    private Category category;

    @OneToMany(mappedBy = "food")
    private List<RatingFood>ratingFoodList;

    @OneToMany(mappedBy = "food")
    private  List<OrderItem>orderItemList;

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

    public boolean isFreeShip() {
        return isFreeShip;
    }

    public void setFreeShip(boolean freeShip) {
        isFreeShip = freeShip;
    }

    public List<RatingFood> getRatingFoodList() {
        return ratingFoodList;
    }

    public void setRatingFoodList(List<RatingFood> ratingFoodList) {
        this.ratingFoodList = ratingFoodList;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
