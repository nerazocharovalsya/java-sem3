import java.util.HashMap;

public class OrderManager {
    HashMap<Integer, Object> RestaurantOrders = new HashMap<Integer, Object>();
    HashMap<String, Object> InternetOrders = new HashMap<String, Object>();

    public void add(Order order, int table) throws OrderAlreadyException {
        if (RestaurantOrders.containsKey(table))
            throw new OrderAlreadyException(Integer.toString(table));
        else RestaurantOrders.put(table, order);
    }

    public void addPosition(Item item, int table){
        if (RestaurantOrders.containsKey(table)){
            Order order = (Order) RestaurantOrders.get(table);
            order.add(item);
            RestaurantOrders.replace(table,order);
        }
        else{
            throw new illegalAddress(Integer.toString(table));
        }
    }

    public Object getOrder(int table){
        return RestaurantOrders.get(table);
    }


    public void removeOrder(int table){
        RestaurantOrders.remove(table);
    }

    public HashMap orders(){
        return RestaurantOrders;
    }


    public void add(Order order, String address) throws OrderAlreadyException{
        if (InternetOrders.containsKey(address))
            throw new OrderAlreadyException(address);
        else InternetOrders.put(address, order);
    }

    public void addPosition(Item item, String  address) throws illegalAddress{
        if (InternetOrders.containsKey(address)){
            Order order = (Order) InternetOrders.get(address);
            order.add(item);
            InternetOrders.replace(address,order);
        }
        else{
            throw new illegalAddress(address);
        }
    }


    public Object getOrder(String address){
        return InternetOrders.get(address);
    }

    public void removeOrderInternet(String address){
        InternetOrders.remove(address);
    }

    public HashMap getInternetOrder(){
        return InternetOrders;
    }
}
