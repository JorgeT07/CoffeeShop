package dev.tinajero.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Queue;

public class CoffeeShop {
    private String shopName;
    private List<MenuItem> menu;
    private Queue<String> orders;

    public CoffeeShop(){}

    public CoffeeShop(String shopName, List<MenuItem> menu) {
        this.shopName = shopName;
        this.menu = menu;
    }

    public CoffeeShop(String shopName, List<MenuItem> menu, Queue<String> orders) {
        this.shopName = shopName;
        this.menu = menu;
        this.orders = orders;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }

    public Queue<String> getOrders() {
        return orders;
    }

    public void setOrders(Queue<String> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "dev.tinajero.models.CoffeeShop{" +
                "shopName='" + shopName + '\'' +
                ", menu=" + menu +
                ", orders=" + orders +
                '}';
    }

    public String addOrder(String name){
        String lowered = name.toLowerCase(Locale.ROOT);

        for(int i =0; i<menu.size(); i++){
            if(menu.get(i).getNameOfItem().equals(name)){
                System.out.println("inside for " + lowered);
                try {
                    this.getOrders().add(lowered);
                    System.out.println("after add");
                }catch (NullPointerException ne){
                    System.out.println("exception caught");
                }
                return "Your order has been placed for " + name;
            }
        }
        return "\nThis item is currently unavailable!\n";
    }

    public String fulfillOrder(){
        while(orders.isEmpty() ==false){
            System.out.println("inside while");
            for(int i =0; i< orders.size(); i++){
                return "The " + orders.contains(i)+ " is ready!";
            }
        }
        return "All orders have been fulfilled!";
    }

    public String listOrders(){

        StringBuilder currentOrders = new StringBuilder("Orders: ");

        while(orders.isEmpty() == false) {
            for (String order : orders) {
                currentOrders.append(order + "/n");
            }
        }

        return currentOrders.toString();
    }

    public double dueAmount(){
        double amount = 0.00;

        if(this.orders.size() == 0){
            return 0;
        }
        else{
            for (int i = 0; i < orders.size(); i++) {
                for (int j = 0; j < menu.size(); j++) {
                    if (menu.get(j).getNameOfItem().equals(orders)) {
                        amount += menu.get(j).getPrice();
                    }
                }
            }
            return amount;
        }

    }

    public String cheapestItem(){
        double min = Integer.MAX_VALUE;
        String item = "";
        for(int i=0; i<menu.size(); i++){
            if(menu.get(i).getPrice() < min){
                min = menu.get(i).getPrice();
                item = menu.get(i).getNameOfItem() + " $" + String.format("%.2f", menu.get(i).getPrice());
            }
        }

        return item;
    }

    public List<String> drinksOnly(){
        List<String> drinkList = new ArrayList<String>();
        for(MenuItem mI : this.getMenu()) {
            if(mI.getType().equals("Drink")){
                drinkList.add(mI.getNameOfItem());
                drinkList.add(" $" + String.format("%.2f", mI.getPrice()) + " |");

            }
        }
        return drinkList;
    }

    public List<String> foodOnly(){
        List<String> foodList = new ArrayList<String>();
        for(MenuItem mI: this.getMenu()){
            if(mI.getType().equals("Food")){
                foodList.add(mI.getNameOfItem());
                foodList.add(" $" + String.format("%.2f", mI.getPrice()) + " |");
            }
        }
        return foodList;
    }
}
