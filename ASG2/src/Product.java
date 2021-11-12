public class Product {
    public String bCode;
    public String title;
    public int quantity;
    public double price;

    public Product() {

    }

    public Product(String bCode, String title, Integer quantity, double price) {
        this.bCode = bCode;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-8s %-10d %.2f",bCode,title,quantity,price);
    }
}
