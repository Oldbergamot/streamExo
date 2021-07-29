public class Main {


    public static void main(String[] args) {
        System.out.println("test sur deleteProduct");
        Product.addProduct(new Product("Chaussure", 15, "marque", ProductType.PETIT , 100));
        Product.addProduct(new Product("Pomme", 1.5, "cbon", ProductType.COMESTIBLE , 150));
        Product.addProduct(new Product("ordinateur", 15, "lenovo", ProductType.PETIT , 190));
        Product.addProduct(new Product("camion", 15000, "bg", ProductType.GROS , 100));
        //Product.addProduct(new Product("camion2", 15000, "bg", ProductType.GROS , 1000)); //impossible trop de stock
        //Product.deleteProduct(new Product("chaussure", 15, "marque", ProductType.PETIT , 100)); //delete first product

        //Product.displayStock();
        //Product.displayProduckByQty();
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
