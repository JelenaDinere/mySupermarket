package Product;

import Supermarket.Supermarket;

public class Product {

    private int id;
    private String name;
    private int buyingPrice;
    private int price;
    private int quantity;



    //To create a new product object with the provided values when initializing

    public Product(int id, String name, int buyingPrice, int price, int quantity){
this.id = id;
this.name =name;
this.buyingPrice = buyingPrice;
this.price = price;
this.quantity = quantity;


    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(int buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getQuantity() {
        return quantity;
    }

    public void sellProduct(int price_to_pay,int quantity){

        this.quantity -=quantity;
        Supermarket.updateTotalMoneyEarned(price_to_pay*quantity);
    }

    public void buyProduct(int buyingPrice,int product_quantity){

        Supermarket.updateTotalMoneySpent(buyingPrice*product_quantity);
    }

    public String toString(){
        return"------Product id:" + id + "-------\n"+
                "Name:\t" + name +
                "\nBuying price in EUR:\t" + buyingPrice +
                "\nPrice in EUR:\t" +price +
                "\nQuantity:\t" + quantity;

    }

}
