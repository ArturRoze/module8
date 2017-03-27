import java.util.*;

public class IManageSystemImpl<T extends Food> implements IManageSystem<T> {

    private Map<T, Double> database;

    public IManageSystemImpl() {
        this.database = new HashMap<>();
    }

    @Override
    public T save(T obj, double price) {
        database.put(obj, price);
        return obj;
    }

    @Override
    public T save(T obj) {
        database.put(obj, null);
        return obj;
    }

    @Override
    public void delete(T obj) {
        database.remove(obj);
        for (T t : database.keySet()) {
            System.out.println(t);
        }
    }

    @Override
    public void deleteById(int id) {

        //First way:
        Iterator<T> iterator1 = database.keySet().iterator();
        while (iterator1.hasNext()) {
            T next = iterator1.next();
            if (next.getId() == id) {
                iterator1.remove();
                System.out.println("This product was deleted:");
            } else if (!iterator1.hasNext()) {
                System.out.println("This id was not found:");
            }
        }

        // Second way:
//        for (Map.Entry<T, Double> entry : database.entrySet()){
//            if (entry.getKey().getId() == id){
//                database.remove(entry.getKey());
//                return;
//            }
//        }
    }

    @Override
    public T get(int id) {
        Set<Map.Entry<T, Double>> entries = database.entrySet();
        for (Map.Entry<T, Double> entry : entries) {
            if (entry.getKey().getId() == id) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    public Double getPrice(T obj) {
        Set<Map.Entry<T, Double>> entries = database.entrySet();
        for (Map.Entry<T, Double> entry : entries) {
            if (entry.getKey().equals(obj)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public Set<T> getProducts() {
        Set<T> products = database.keySet();
        for (T product : products) {
            System.out.println(product);
        }
        return products;
    }

    @Override
    public List<Double> getPrices() {
        List<Double> newList = new ArrayList<>(database.values());
        for (Double aDouble : newList) {
            System.out.println(aDouble);
        }
        return newList;
    }

    // extra tasks:
    @Override
    public void printProductsSortedByName() {
        List<T> newList = new ArrayList<>(database.keySet());
        Collections.sort(newList, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (T t : newList) {
            System.out.println(t);
        }
    }

    @Override
    public void printProductsSortedByPrice() {
        List<Map.Entry<T, Double>> databaseByPrices = new ArrayList<>(database.entrySet());
        for (Map.Entry<T, Double> databaseByPrice : databaseByPrices) {
            if (databaseByPrice.getValue() == null) {
                databaseByPrice.setValue(0d);
            }
        }
        databaseByPrices.sort(new Comparator<Map.Entry<T, Double>>() {
            @Override
            public int compare(Map.Entry<T, Double> o1, Map.Entry<T, Double> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (Map.Entry<T, Double> databaseByPrice : databaseByPrices) {
            System.out.println(databaseByPrice.getKey() + " " + databaseByPrice.getValue());
        }
    }
}
