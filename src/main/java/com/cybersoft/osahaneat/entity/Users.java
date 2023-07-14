package com.cybersoft.osahaneat.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity( name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name=  "username")
    private String username;

    @Column(name=  "password")
    private String password;

    @Column(name=  "fullname")
    private String fullname;



    @ManyToOne
    @JoinColumn(name="role_id")
    private Roles roles;

    @OneToMany(mappedBy = "users")
    private List<RatingFood>ratingFoodList;

    @OneToMany(mappedBy = "users")
    private List<RatingRestaurant>ratingRestaurantList;

    @OneToMany (mappedBy = "users")
    private List<Order>orderList;

    public List<RatingRestaurant> getRatingRestaurantList() {
        return ratingRestaurantList;
    }

    public void setRatingRestaurantList(List<RatingRestaurant> ratingRestaurantList) {
        this.ratingRestaurantList = ratingRestaurantList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<RatingFood> getRatingFoodList() {
        return ratingFoodList;
    }

    public void setRatingFoodList(List<RatingFood> ratingFoodList) {
        this.ratingFoodList = ratingFoodList;
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



    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
