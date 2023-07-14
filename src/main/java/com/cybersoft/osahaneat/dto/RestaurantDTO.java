package com.cybersoft.osahaneat.dto;

import java.util.Date;
import java.util.List;
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class RestaurantDTO {
    private int id;
    private String title;
    private String image;
    private double rating ;
    private String subTile;
    private boolean isFreeShip;
    private Date openDate;
    private String description;
    private String address;
    List<CategoryDTO> listCategoryDTO;

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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getSubTile() {
        return subTile;
    }

    public void setSubTile(String subTile) {
        this.subTile = subTile;
    }

    public boolean isFreeShip() {
        return isFreeShip;
    }

    public void setFreeShip(boolean freeShip) {
        isFreeShip = freeShip;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<CategoryDTO> getListCategoryDTO() {
        return listCategoryDTO;
    }

    public void setListCategoryDTO(List<CategoryDTO> listCategoryDTO) {
        this.listCategoryDTO = listCategoryDTO;
    }
}
