package dev.tinajero;

import dev.tinajero.models.CoffeeShop;
import dev.tinajero.models.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        CoffeeShop coffeeShop = new CoffeeShop();
        List<MenuItem> menuItems = new ArrayList<MenuItem>();
        coffeeShop.setShopName("starkBuckys");

        MenuItem item1 = new MenuItem("latte", "Drink", 3.00);
        MenuItem item2 = new MenuItem("coffee", "Drink", 2.00);
        MenuItem item3 = new MenuItem("frap", "Drink", 5.00);
        MenuItem item4 = new MenuItem("burger", "Food", 2.50);
        MenuItem item5 = new MenuItem("hotdog", "Food", 3.50);
        MenuItem item6 = new MenuItem("pizza", "Food", 1.00);
        MenuItem item7 = new MenuItem("sandwhich", "Food", 1.50);

        menuItems.add(item1);
        menuItems.add(item2);
        menuItems.add(item3);
        menuItems.add(item4);
        menuItems.add(item5);
        menuItems.add(item6);
        menuItems.add(item7);

        coffeeShop.setMenu(menuItems);
        boolean run = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to " + coffeeShop.getShopName());

        while(run){

            System.out.println("Select one of the following options");
            System.out.println("___________________________");
            System.out.println("1. Add an Order \n2. Fulfill an Order \n3. List all Orders \n4. Amount Due \n5. Cheapest Item \n6. Drink Menu Only \n7. Food Menu Only \n8. Exit\n");

            String option = sc.nextLine();

            switch(option){
                case "1":
                    System.out.println("What would you like to order?");
                    coffeeShop.addOrder(sc.nextLine());
                    break;
                case "2":
                    System.out.println("Fulfilling order...");
                    System.out.println(coffeeShop.fulfillOrder());
                    break;
                case "3":
                    System.out.println("Here is a list of the orders so far");
                    coffeeShop.listOrders();
                    break;
                case "4":
                    System.out.println("This is your amount due: ");
                    System.out.println(String.format("%.2f", coffeeShop.dueAmount()));
                    break;
                case "5":
                    System.out.println("This is our cheapest item: ");
                    System.out.println(coffeeShop.cheapestItem());
                    break;
                case "6":
                    System.out.println("This is our drinks only menu: ");
                    System.out.println(coffeeShop.drinksOnly());
                    break;
                case "7":
                    System.out.println("This is our food only menu: ");
                    System.out.println(coffeeShop.foodOnly());
                    break;
                case "8":
                    run = false;
                    break;
                default:
                    System.out.println("Invalid Selection, Try again\n");
                    break;
            }


        }

        sc.close();
        System.out.println("Thank you, come again!");


    }

}
