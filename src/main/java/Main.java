import Product.Product;
import Supermarket.Supermarket;
import User.User;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    Supermarket supermarket = new Supermarket();
    Scanner scanner = new Scanner(System.in);
    Scanner intScanner = new Scanner(System.in);
    Scanner doubleScanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.showMenu();

    }

    void showMenu() {
        String userType = "";
        System.out.println("---SUPERMARKET---\n"
                + "Log in to continue");
        do {
            System.out.println("\nPlease choose one of the users below:\n" +
                    "1.Buyer \n" +
                    "2.Sales representative \n " +
                    "3.Owner \n " +
                    " Enter Quit to end the  program ... ");
            System.out.println("Choose a number:");
            userType = scanner.nextLine();
            switch (userType) {
                case "QUIT":
                    System.out.println("Exiting application....");
                    break;
                case "1":
                    buyer();
                    break;
                case "2":
                    salesRepresentative();
                    break;
                case "3":
                    owner();
                default:
                    break;
            }
        }
        while (!userType.toUpperCase().equals("QUIT"));
        return;
    }

    //create a method to show menu,after that add and view products for salesRepresentative;
    void salesRepresentative() {
        String salesRepresentativeInput = "";

        do {
            System.out.println("Choose operation : \n " +
                    "1. Add product \n " +
                    "2. View all products");
            System.out.println("Choose a number:");

            salesRepresentativeInput = scanner.nextLine();
            switch (salesRepresentativeInput) {
                case "Quit":
                    System.out.println("Exiting application....");
                    break;
                case "1":
                    addProduct();
                    break;
                case "2":
                    getProducts();
                    break;
                default:
                    break;
            }
        }
        while (!salesRepresentativeInput.toUpperCase().equals("QUIT"));

        showMenu();

        return;
    }

    //this method add the product to array list of products;
    void addProduct() {
        System.out.println("Add Product");
        System.out.println("Please provide product ID:\n");
        int productId = intScanner.nextInt();
        System.out.println("Please provide product name:\n");
        String productName = scanner.nextLine();

        System.out.println("Please provide product buying price:\n");
        int productBuyingPrice = intScanner.nextInt();
        System.out.println("Please provide product quantity:\n");
        int productQuantity = intScanner.nextInt();
        System.out.println("Please provide product price:\n");
        int productPrice = intScanner.nextInt();

        Product product = new Product(productId, productName, productBuyingPrice, productPrice, productQuantity);

        supermarket.addProduct(product);
        System.out.println("New product added successfully");

    }

    //this method shows all the products in the array list
    void getProducts() {
        System.out.println("All products available in the supermarket!");

        for (Product product : supermarket.getProducts()) {
            System.out.println(product);
        }

    }


    void buyer() {
        String buyerInput = "";
        String email;
        String password;
        System.out.println("Enter your email");
        email = scanner.nextLine();
        ArrayList<User> users = supermarket.getUsers();
        for (User user : supermarket.getUsers()) {
            if (user.getEmail().equals(email)) {
                System.out.println("Enter your password");
                password = scanner.nextLine();
                if (user.getPassword().equals(password)) {
                    System.out.println("Welcome to the Supermarket! Please choose operation:\n  " +
                            "1. View all products\n " +
                            "2. Buy product ");
                    System.out.println("Choose a number:");
                    buyerInput = scanner.nextLine();
                    do {
                        switch (buyerInput) {
                            case "Quit":
                                System.out.println("Exiting application....");
                                break;
                            case "1":
                                for (Product product : supermarket.getProducts()) {
                                    System.out.println("------Product id:" + product.getId() + "-------\n" +
                                            "Name:\t" + product.getName() + "\n Price in EUR:\t" + product.getPrice() +
                                            "\nQuantity:\t" + product.getQuantity());
                                }
                                buyer();
                                break;
                            case "2":
                                System.out.println("Enter product name, that You want to buy");
                                String product_name = scanner.nextLine();
                                for (Product product : supermarket.getProducts()) {
                                if(product.getName().equals(product_name)) {
                                    if (product.getQuantity() != 0){
                                        System.out.println("Enter quantity");
                                        int product_quantity = intScanner.nextInt();
if(product_quantity<= product.getQuantity()){
int price_to_pay=product_quantity*product.getPrice();
    System.out.println(price_to_pay + "eur");
if(user.getUserBalance()>=price_to_pay){
    user.payForProduct(price_to_pay);
    product.sellProduct(price_to_pay,product_quantity);
    Product soldProduct = new Product(product.getId(),product.getName(),product.getBuyingPrice(),product.getPrice(), (int) product.getQuantity());
    supermarket.addSoldProduct(soldProduct);
    System.out.println("Product is bought");
    showMenu();
    break;
}else{
    System.out.println("Not enough balance to buy product");
}
}else{
    System.out.println("Product sold out");
}
                                    } else{
                                        System.out.println("No such quantity of product");
                                    }

                                }else {
                                    System.out.println("No such product found! Please try again!");
                                }}
                            default:
                                break;
                        }
                    }while (!buyerInput.toUpperCase().equals("QUIT"));
                    showMenu();
                    return;
                } else{
                    System.out.println("Password incorrect, please try again! ");
                }
            }
        }
    }



    void owner() {
        String ownerInput = "";
        do {
            System.out.println("Choose operation below : \n " +
                    "1. Add buyers \n " +
                    "2. View all buyers from supermarket \n " +
                    "3. Total money earned by supermarket \n " +
                    "4. Total money spent by supermarket \n " +
                    "5. Balance of the supermarket\n " +
                    "6. Sales history ");
            System.out.println("Choose a number:");
            ownerInput = scanner.nextLine();
            switch (ownerInput) {
                case "Quit":
                    System.out.println("Exiting application....");
                    break;
                case "1":
                    addBuyers();
                    break;
                case "2":
                    getBuyers();
                    break;
                case "3":
                    moneyEarned();
                    break;
                case "4":
                    moneySpent();
                    break;
                case "5":
                    getBalance();
                    break;
                case "6":
                    getSalesHistory();
                    break;
                default:
                    break;
            }
        } while (!ownerInput.toUpperCase().equals("QUIT"));
        showMenu();
        return;
    }

    void addBuyers() {
        System.out.println("Add Buyer");
        System.out.println("Enter user id : ");
        int userId = intScanner.nextInt();
        System.out.println("Enter user name : ");
        String userName = scanner.nextLine();
        System.out.println("Enter user email : ");
        String userEmail = scanner.nextLine();
        System.out.println("Enter user password : ");
        String userPassword = scanner.nextLine();
        System.out.println("Enter user balance  : ");
        int userBalance = intScanner.nextInt();
        User user = new User(userId, userName, userPassword, userEmail, userBalance);
        supermarket.addUser(user);

        System.out.println("New user added successfully");
    }


    void getBuyers() {
        System.out.println("All buyers available in the supermarket!");
        for (User user : supermarket.getUsers()) {
            System.out.println(user);
        }
    }

    void moneyEarned() {
        System.out.println("Total money earned:  " + supermarket.getTotalMoneyEarned());
    }

    void moneySpent() {
        System.out.println("Total money spent:  " + supermarket.getTotalMoneySpent());
    }

    void getBalance() {
        System.out.println("Balance: " + supermarket.getBalance());
    }

    void getSalesHistory() {
        if (supermarket.getSoldProducts() == null) {
            System.out.println("No history to show");
        } else {
            for (Product product : supermarket.getProducts()) {
                System.out.println(product);
            }
        }
    }
}
