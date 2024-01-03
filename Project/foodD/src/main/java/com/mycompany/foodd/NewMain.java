/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.foodd;

/**
 *
 * @author fab5k
 */

import java.util.*;

public class NewMain extends FoodD{

    static class Items {
        String name;
        float rating;
        float price;
        int foodIdNo;
        Items next;
        Items prev;
    }

    static class OrderHistory {
        int customerId;
        int[][] items;
        float amount;
        String date;
        OrderHistory next;
        OrderHistory prev;
    }

    static class Location {
        String name;
        int width;

        Location(String name, int width) {
            this.name = name;
            this.width = width;
        }
    }

    static class Edge {
        Location source, destination;
        int weight;

        Edge(Location source, Location destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
    static Items head;
    static Items last;
    static int custId = 1;
    static int todayCustomer = 0;
    static OrderHistory head1;
    static OrderHistory last1;
    static float totalIncome = 0;

    public static void main(String[] args) {
        option();
    }

    static void option() {
        head = last = null;
        insert("Cheese Burger ", 70.00f, 1);
        insert("Cheese Prizza", 280.00f, 2);
        insert("Hot Cake", 750.00f, 3);
        insert("Hot Coffee", 100.00f, 4);
        insert("Ice-Cream", 50.00f, 5);
        insert("Sub-Sandwich", 60.00f, 6);
        insert("Chicken Grill", 100.00f, 7);
        insert("Butter -Nun", 30.00f, 8);
        insert("Cold Drink", 20.00f, 9);

        int choice;
        do {
            System.out.println("\n Food Delivery System\n");
            System.out.println("________________________________________________________________");
            System.out.println("1    Food Order Panel\n");
            System.out.println("2    Owner Panel\n");
            System.out.println("3    EXIT");
            System.out.println("________________________________________________________________");
            System.out.print("Enter your choice : ");
            try (Scanner scanner = new Scanner(System.in)) {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        int ex;
                        do {
                            System.out.println("\n1.     FOOD LIST ");
                            System.out.println("2.     ORDER");
                            System.out.println("3.     ADMIN PANEL");
                            System.out.println("4.     EXIT \n");
                            int n = scanner.nextInt();
                            switch (n) {
                                case 1:
                                    display();
                                    break;
                                case 2:
                                    order();
                                    break;
                                case 3:
                                    Log();
                                    break;
                                case 4:
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println("Wrong choice");
                                    break;
                            }
                            System.out.println("1. FOOD PART\n2. MAIN MENU\n");
                            ex = scanner.nextInt();
                            if (ex == 2) {
                                option();
                                break;
                            }
                        } while (true);
                        break;
                    case 2:
                        Log();
                        break;
                    default:
                        option();
                }
            }
        } while (true);
    }

    static void Log() {
        System.out.println("\n");
        int k = login();
        if (k == 1) {
            do {
                System.out.println("\n---------------------------------------------------------------------------------");
                System.out.println("1.          ADD NEW DISH");
                System.out.println("2.          TODAY'S TOTAL INCOME");
                System.out.println("3.          TODAY'S TOTAL NO OF CUSTOMER");
                System.out.println("4.          ORDER HISTORY");
                System.out.println("5.          LIST OF ITEMS");
                System.out.println("6.          MAIN MENU");
                System.out.println("\n---------------------------------------------------------------------------------");
                int ch;
                Scanner scanner = new Scanner(System.in);
                ch = scanner.nextInt();
                switch (ch) {
                    case 1:
                        System.out.print(" ");
                        float p;
                        int fin;
                        String n;

                        System.out.print("Enter the name of items : ");
                        n = scanner.next();
                        System.out.print("Enter the price of items : ");
                        p = scanner.nextFloat();
                        System.out.print("Enter the food_Id_No of items : ");
                        fin = scanner.nextInt();
                        insert(n, p, fin);
                        System.out.println("\n--------------------------------------------------------------------------------");
                        System.out.println("                         NEW DISH IS ADDED SUCCESSFULLY........");
                        System.out.println("\n--------------------------------------------------------------------------------");
                        break;
                    case 2:
                        System.out.println("\n--------------------------------------------------------------------------------");
                        System.out.println("                         TODAY;S TOTAL INCOME IS :- " + totalIncome);
                        System.out.println("\n--------------------------------------------------------------------------------");
                        break;
                    case 3:
                        System.out.println("\n--------------------------------------------------------------------------------");
                        System.out.println("                         TODAY TOTAL NO OF CUSTOMER VISITED ID :- " + todayCustomer);
                        System.out.println("\n--------------------------------------------------------------------------------");
                        break;
                    case 4:
                        System.out.println("\n--------------------------------------------------------------------------------");
                        System.out.println("                         ORDER SUMMARY........");
                        System.out.println("\n--------------------------------------------------------------------------------");
                        displayOrderHistory();
                        System.out.println("\n");
                        break;
                    case 5:
                        display();
                        break;
                    case 6:
                        option();
                        break;
                    default:
                        System.out.println("\nwrong choice\n");
                        break;
                }
            } while (true);
        }
    }

    static void insert(String n, float p, int fin) {
        Items temp1 = getNewItem(n, p, fin);
        if (head == null) {
            head = temp1;
            last = temp1;
        } else {
            temp1.prev = last;
            last.next = temp1;
            last = temp1;
        }
    }

    static Items getNewItem(String a, float p, int fin) {
        Items temp = new Items();
        temp.foodIdNo = fin;
        temp.name = a;
        temp.rating = 4.0f;
        temp.price = p;
        temp.next = null;
        temp.prev = null;
        return temp;
    }

    public static void display() {
        System.out.println("\n***** MENU *****");
        System.out.println("INDEX" +"\t"+ "ITEMS NAME " + "\t" + "PRICE"+ "\t"+ "RATING" +"\n");
        Items temp = head;
        if (head == null) {
            System.out.println("Empty");
        }
        while (temp != null) {
            System.out.println(temp.foodIdNo + "\t" + temp.name + "\t" + temp.price + "\t" + temp.rating);
            temp = temp.next;
        }
        System.out.println("\n-------------------------------------------------------------------------------------------------");
    }

    static int login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username : ");
        String username = scanner.next();
        System.out.println();
        System.out.print("Enter your password : ");
        String userPwd = scanner.next();

        if (username.equals("Admin") && userPwd.equals("rafi1105")) {
            System.out.println("\n \n Logged in Successfully\n");
            return 1;
        } else {
            System.out.println("\n \n Incorrect username or password\n");
            return 0;
        }
    }

    static void order() {
        display();

        int[][] a = new int[10][2];
        int n, j = 0, i = 0;

        do {
            System.out.print("Please enter the FOOD ID NUMBER OF items AND ITS QUANTITY:- ");
            for (i = 0; i < 2; i++) {
               Scanner scanner = new Scanner(System.in);
                    a[j][i] = scanner.nextInt();
                
            }
            j++;
            System.out.print("Do you want more items?\n1. Yes\n2. No\n");
            Scanner scanner = new Scanner(System.in);
                n = scanner.nextInt();
            
        } while (n == 1);
   
        float totalAmount = 0.0f;
        String name;
        String date;
        System.out.print("Enter your Name : ");
        Scanner scanner = new Scanner(System.in);
            name = scanner.next();
            System.out.print("Enter Today's Date : ");
            date = scanner.next();
        
        food.DeliverySystem();
        int k = 0;
        System.out.println("\n ----------------------------------------------------------------------------------------------- \n");
        System.out.println("\n                                   Food Delivery System                                    \n");
        System.out.println("\n                                       BILL -> " + name + "                                          \n");
        System.out.println("\n ----------------------------------------------------------------------------------------------- \n");
        System.out.println("Name :- " + name);
        System.out.println("Date:- " + date);
        for (k = 0; k < j; k++) {
            Items temp = head;
            while (temp.foodIdNo != a[k][0]) {
                temp = temp.next;
            }
            System.out.println("\n----------------------------------------------------------------------------------------------");
            System.out.println(temp.foodIdNo + "\t" + temp.name + "\t" + a[k][1] + "\t\t " + (a[k][1] * (temp.price)));
            totalAmount = totalAmount + (a[k][1] * (temp.price));
        }

        System.out.println("\n----------------------------------------------------------------------------------------------");
        System.out.println("\nTotal Payable amount is :-\t\t" + totalAmount);
        System.out.println("------------------------------------------------------------------------------------------------");

        OrderHistory temp2 = getNewOrderHistory();
        temp2.amount = totalAmount;
        temp2.customerId = custId++;

        int p, s;
        for (p = 0; p < j; p++) {
            for (s = 0; s < 2; s++) {
                temp2.items[p][s] = a[p][s];
            }
        }

        if (head1 == null) {
            head1 = last1 = temp2;
        } else {
            last1.next = temp2;
            temp2.prev = last1;
            last1 = temp2;
        }
        temp2.date = date;
        todayCustomer++;
        totalIncome += totalAmount;
    }

    static OrderHistory getNewOrderHistory() {
        OrderHistory temp = new OrderHistory();
        temp.next = temp.prev = null;
        return temp;
    }

    static void displayOrderHistory() {
        System.out.println("                                    -------------                                              ");
        System.out.println("                                    ORDER HISTORY                                              ");
        System.out.println("                                    -------------                                              ");
        System.out.println("SR_NO     DATE     TOTAL AMOUNT");
        OrderHistory temp = head1;
        if (head1 == null) {
            System.out.println("No history available");
        } else {
            while (temp.next != null) {
                System.out.println(temp.customerId + "\t" + temp.date + "\t" + temp.amount + "\t");
                temp = temp.next;
            }
        }
    }

        }    
    



 

