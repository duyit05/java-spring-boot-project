package com.cybersoft.osahaneat.dto;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public class CategoryDTO {
    private int id;
    private String name ;
    private List<FoodDTO> footList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FoodDTO> getFootList() {
        return footList;
    }

    public void setFootList(List<FoodDTO> footList) {
        this.footList = footList;
    }
}
