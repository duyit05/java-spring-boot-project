package com.cybersoft.osahaneat.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


import java.util.Date;
import java.util.List;

@Entity(name = "category")
public class Category {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_cate")
    private String nameCate;

    @Column(name = "create_date")
    private Date createDate;

    @OneToMany (mappedBy = "category")
    private List<Food> foodList;

    @OneToMany(mappedBy = "category")
    private List<MenuRestaurant>restaurantList;


    public List<MenuRestaurant> getRestaurantList() {
        return restaurantList;
    }

    public void setRestaurantList(List<MenuRestaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }

    public int getId() {
        return id;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public void setId(int id) {
        this.id = id;
    }

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
