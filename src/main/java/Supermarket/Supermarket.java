package Supermarket;

import Product.Product;
import User.User;

import java.util.ArrayList;

public class Supermarket {

    private ArrayList<Product> products;
    private ArrayList<User>users;
    private ArrayList <Product> soldProducts;
    private static int totalMoneyEarned;
    private static int totalMoneySpent;


    public Supermarket(){
        products = new ArrayList<Product>();
        users = new ArrayList<User>();
        soldProducts = new ArrayList<Product>();
        totalMoneySpent = 0;
        totalMoneyEarned = 0;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Product> getSoldProducts() {
        return soldProducts;
    }


    public void addProduct(Product product){
        this.products.add(product);
    }
    public void addUser(User user){
        this.users.add(user);
    }
    public void addSoldProduct(Product soldProduct){
        this.soldProducts.add(soldProduct);
    }
    public static void updateTotalMoneyEarned(int moneyEarned)
    {
        totalMoneyEarned +=  moneyEarned;

    }

    public static void updateTotalMoneySpent(int moneySpent){
        totalMoneySpent += moneySpent;

    }

    public  int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    public  int getTotalMoneySpent() {
        return totalMoneySpent;
    }

    public int getBalance()
    {
        int supermarket_Balance;
        supermarket_Balance = totalMoneyEarned - totalMoneySpent;
        return supermarket_Balance;
    }

}

