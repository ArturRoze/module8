import java.util.List;
import java.util.Set;

public interface IManageSystem<T> {

    T save(T obj, double price);
    T save(T obj);
    void delete(T obj) ;
    void deleteById(int id);
    T get(int id);
    Double getPrice(T obj);
    Set<T> getProducts();
    List<Double> getPrices();

    // extra task:
    void printProductsSortedByName();
    void printProductsSortedByPrice();


}
