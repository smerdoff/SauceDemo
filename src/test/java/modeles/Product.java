package modeles;

public class Product {
    String productName;
    String price;
    String details;

    public Product(String productName, String price, String details) {
        this.productName = productName;
        this.price = price;
        this.details = details;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
