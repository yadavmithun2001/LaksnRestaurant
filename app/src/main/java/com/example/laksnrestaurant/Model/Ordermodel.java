package com.example.laksnrestaurant.Model;

public class Ordermodel {
    String name,tableno,foodname,price;
    public Ordermodel(String name, String tableno, String foodname, String price) {
        this.name = name;
        this.tableno = tableno;
        this.foodname = foodname;
        this.price = price;
    }
    public Ordermodel(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTableno() {
        return tableno;
    }

    public void setTableno(String tableno) {
        this.tableno = tableno;
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
