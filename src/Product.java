import java.util.*;

public class Product {

    public static List<Product> products = new ArrayList<>();
    public static int amount =0;

    private String nom;
    private double prix;
    private String marque;
    private ProductType type;
    private int stock;

    public Product(String nom, double prix, String marque, ProductType type, int stock) {
        this.nom = nom;
        this.prix = prix;
        this.marque = marque;
        this.type = type;
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.prix, prix) == 0
                && stock == product.stock
                && Objects.equals(nom.toLowerCase(Locale.ROOT), product.nom.toLowerCase(Locale.ROOT))
                && Objects.equals(marque.toLowerCase(Locale.ROOT), product.marque.toLowerCase(Locale.ROOT))
                && type == product.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prix, marque, type, stock);
    }

    public int getStock() {
        return stock;
    }

    public ProductType getType() {
        return type;
    }

    public double getPrice() {
        return prix;
    }

    public String getName() {
        return nom;
    }

    public String getMark() {
        return marque;
    }

    @Override
    public String toString() {
        return "Product{" +
                "nom='" + nom + '\'' +
                ", prix=" + prix +
                ", marque='" + marque + '\'' +
                ", type=" + type +
                ", stock=" + stock +
                '}';
    }


    public static void addProduct(Product p){
        if(p.getStock() + Product.amount >= 1000) System.out.println("To much stock");
        else {
            Product.products.add(p);
            Product.amount += p.getStock();
            //System.out.println(p.toString());
        }
    }

    public static void deleteProduct(Product p) {
        if(Product.products.stream().noneMatch(p::equals)) System.out.println("No such product");
        else {
            Product.products.remove(p);
        }

    }

    public static boolean checkNbProduct() {
        return Product.products.size()<1000;
    }

    public static void displayStock() {
        Product.products.stream().forEach(product -> System.out.println(product.toString()));
    }

    public static void displayProduckByPrice() {
        products.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .forEach(System.out::println);
    }
    public static void displayProduckByType() {
        products.stream()
                .sorted(Comparator.comparing(Product::getType))
                .forEach(System.out::println);
    }
    public static void displayProduckByQty() {
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

    public static void searchByMark(String m) {
        if(products.stream().anyMatch(product -> product.getMark()
                .toLowerCase(Locale.ROOT)
                .equals(m))) {
            products.stream()
                    .filter(product -> product.getMark()
                            .toLowerCase(Locale.ROOT)
                            .equals(m.toLowerCase(Locale.ROOT)))
                    .forEach(System.out::println);
        }
        else {
            System.out.println("Nothing found as "+m);
        }
    }
    public static void searchByName(String n) {
        if(products.stream().anyMatch(product -> product.getName()
                .toLowerCase(Locale.ROOT)
                .equals(n.toLowerCase(Locale.ROOT)))) {
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
}
