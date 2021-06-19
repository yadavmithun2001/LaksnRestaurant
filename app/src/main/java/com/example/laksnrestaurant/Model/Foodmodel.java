package com.example.laksnrestaurant.Model;

public class Foodmodel {
    int img;
    String foodname,price;
    Boolean isSelected = false;

    public Foodmodel(int img, String foodname, String price) {
        this.img = img;
        this.foodname = foodname;
        this.price = price;
    }
    public Foodmodel(){

    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
