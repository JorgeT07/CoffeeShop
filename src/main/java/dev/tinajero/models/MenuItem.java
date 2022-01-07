package dev.tinajero.models;

import java.util.List;
import java.util.Queue;

public class MenuItem {
    private String nameOfItem;
    private String type;
    private double price;

    public MenuItem(){}

    public MenuItem(String nameOfItem, String type, double price) {
        this.nameOfItem = nameOfItem;
        this.type = type;
        this.price = price;
    }

    public String getNameOfItem() {
        return nameOfItem;
    }

    public void setNameOfItem(String nameOfItem) {
        this.nameOfItem = nameOfItem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "nameOfItem='" + nameOfItem + '\'' +
                " type='" + type + '\'' +
                " price=" + price +
                '}';
    }
}
