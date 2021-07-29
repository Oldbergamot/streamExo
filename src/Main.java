public class Main {


    public static void main(String[] args) {
        Product.generateStock();
        Product.displayProductByType();
        System.out.println("--------------------");
        Product.displayProductByPrice();
        System.out.println("---------------------");
        Product.displayCheapest();
        System.out.println("----------------------");
        Product.searchByBrand("cbon");
        Product.searchByBrand("plop");
        System.out.println("-----------------------");
        Product.searchByName("Camion");
        Product.searchByName("plop");
        System.out.println("-----------------------");
        Product.searchByName("Camion");
        Product.addStock("camion",15);
        Product.searchByName("Camion");
        Product.addStock("plop", 150);
        System.out.println("------------------------");
        Product.deleteProduct("camion");
        Product.searchByName("camion");
    }


}
