import java.util.*;

public class Product {

    public static List<Product> products = new ArrayList<>();
    public static int totalInStock =0;

    private final String name;
    private double price;
    private final String brand;
    private final ProductType type;
    private int stock;

    public Product(String name, double price, String brand, ProductType type, int stock) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.type = type;
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0
                && stock == product.stock
                && Objects.equals(name.toLowerCase(Locale.ROOT), product.name.toLowerCase(Locale.ROOT))
                && Objects.equals(brand.toLowerCase(Locale.ROOT), product.brand.toLowerCase(Locale.ROOT))
                && type == product.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, brand, type, stock);
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public ProductType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Product{" +
                "nom='" + name + '\'' +
                ", prix=" + price +
                ", marque='" + brand + '\'' +
                ", type=" + type +
                ", stock=" + stock +
                '}';
    }

    /**
     * add a product to the list of product if the total stock is less then 1000
     * @param p the product that needs to be added
     */

    public static void addProduct(Product p){
        if(p.getStock() + Product.totalInStock >= 1000) System.out.println("To much stock");
        else if(products.size()>1000) System.out.println("To many items in stock");
        else {
            Product.products.add(p);
            Product.totalInStock += p.getStock();
        }
    }

    /**
     * allow to remove the said product from the list of product,
     * the stock is removed as well
     * @param p the product that needs to be deleted
     */
    public static void deleteProduct(Product p) {
        if(Product.products.stream().noneMatch(p::equals)) System.out.println("No such product");
        else {
            totalInStock -= p.getStock();
            Product.products.remove(p);
        }
    }
     public static void deleteProduct(String productName) {
         if(!productExist(productName))
             System.out.println("No such product as "+productName);
         else {
             Product p = products.stream().filter(product -> product.getName()
                     .toLowerCase(Locale.ROOT)
                     .equals(productName.toLowerCase(Locale.ROOT)))
                     .findFirst().get();
             totalInStock -= p.getStock();
             products.remove(p);
         }
     }


    /**
     * add the given stock to the given product,
     * if the product exist and the total stock is
     * less then 1000
     */
    public static void addStock(String productName, int stock) {
        if(!productExist(productName))
            System.out.println("No such product as "+productName);
        else {
            Product p = products.stream().filter(product -> product.getName()
                    .toLowerCase(Locale.ROOT)
                    .equals(productName.toLowerCase(Locale.ROOT)))
                    .findFirst().get();
            if(totalInStock + stock >1000) System.out.println("To much stock");
            else {
                for(Product product : products) {
                    if (p.equals(product)) {
                        product.setStock(product.getStock()+stock);
                    }
                }
            }
        }
    }

    public static void displayStock() {
        Product.products.forEach(product -> System.out.println(product.toString()));
    }

    public static void displayProductByPrice() {
        products.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .forEach(System.out::println);
    }
    public static void displayProductByType() {
        products.stream()
                .sorted(Comparator.comparing(Product::getType))
                .forEach(System.out::println);
    }
    public static void displayProductByQty() {
        products.stream()
                .sorted(Comparator.comparing(Product::getStock))
                .forEach(System.out::println);
    }

    public static void displayCheapest() {
        System.out.println(products.stream()
                .min(Comparator.comparing((Product::getPrice))));
    }

    public static void displayMostExpensive() {
        System.out.println(products.stream()
                .max(Comparator.comparing((Product::getPrice))));
    }

    public static void displayFewInStock() {
        products.stream()
                .filter(product -> product.getStock()<=10)
                .forEach(System.out::println);
    }

    public static void searchByBrand(String m) {
        if(products.stream().anyMatch(product -> product.getBrand()
                .toLowerCase(Locale.ROOT)
                .equals(m.toLowerCase(Locale.ROOT)))) {
            products.stream()
                    .filter(product -> product.getBrand()
                            .toLowerCase(Locale.ROOT)
                            .equals(m.toLowerCase(Locale.ROOT)))
                    .forEach(System.out::println);
        }
        else {
            System.out.println("Nothing found as "+m);
        }
    }
    public static void searchByName(String n) {
        if(productExist(n)) {
            products.stream()
                    .filter(product -> product.getName()
                            .toLowerCase(Locale.ROOT)
                            .equals(n.toLowerCase(Locale.ROOT)))
                    .forEach(System.out::println);
        }
        else {
            System.out.println("Nothing found as "+n);
        }
    }

    public static boolean productExist(String n) {
        return products.stream().anyMatch(product -> product.getName()
                .toLowerCase(Locale.ROOT)
                .equals(n.toLowerCase(Locale.ROOT)));
    }
}
