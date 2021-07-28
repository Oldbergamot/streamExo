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
        Product.displayProduckByType();
        System.out.println("--------------------");
        Product.displayProduckByPrice();
        System.out.println("---------------------");
        Product.displayCheapest();
        System.out.println("----------------------");
        Product.searchByMark("cbon");
        Product.searchByMark("plop");
        System.out.println("-----------------------");
        Product.searchByName("Camion");
        Product.searchByName("plop");
    }


}
