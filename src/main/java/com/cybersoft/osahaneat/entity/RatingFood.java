package com.cybersoft.osahaneat.entity;


import jakarta.persistence.*;


@Entity (name = "rating_food")
public class RatingFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private  Users users;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private  Food food;

    @Column(name = "content" )
    private int content;

    @Column(name = "rate_point" )
    private int ratePoint;


    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public int getRatePoint() {
        return ratePoint;
    }

    public void setRatePoint(int ratePoint) {
        this.ratePoint = ratePoint;
    }
}
