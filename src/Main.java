import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Food goods1 = new Food("Milk", Country.CANADA, 12);
        Food goods2 = new Food("Potatoes", Country.USA, 2);
        Food goods3 = new Food("Cookies", Country.UKRAINE, 22);
        Food goods4 = new Food("Soup", Country.FRANCE, 13);
        Food goods5 = new Food("Vegetables", Country.CHINA, 8);

        IManageSystem<Food> system = new IManageSystemImpl<>();
        system.save(goods1);
        system.save(goods2, 16);
        system.save(goods3, 12);
        system.save(goods4);
        system.save(goods5);

        System.out.println("Save products with price:");
        System.out.println(system.save(goods5, 17));
        System.out.println();

        System.out.println("Save products without price:");
        System.out.println(system.save(goods4));
        System.out.println();

        System.out.println("Delete specific product");
        system.delete(goods3);
        System.out.println();

        System.out.println("Delete product by id:");
        system.deleteById(11);
        System.out.println();

        System.out.println("Get products by specific id:");
        System.out.println(system.get(11));
        System.out.println();

        System.out.println("Get price specific product:");
        Double price1 = system.getPrice(goods3);
        System.out.println(price1);
        System.out.println();

        System.out.println("Get all products:");
        system.getProducts();
        System.out.println();

        System.out.println("Get all prices of products:");
        system.getPrices();
        System.out.println();

        //extra tasks:
        System.out.println("Sorted products by increase name:");
        system.printProductsSortedByName();
        System.out.println();

        System.out.println("Sorted products by increase price:");
        system.printProductsSortedByPrice();
    }
}
