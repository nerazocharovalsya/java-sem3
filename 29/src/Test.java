import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        System.out.println("Ресторанный заказ: ");
        Order restaurantOrder = new RestaurantOrder();
        restaurantOrder.add(new Dish(500, "Паста", "Карбонара"));
        restaurantOrder.add(new Dish(300, "Пицца", "Маргарита"));
        restaurantOrder.add(new Drink(150, "Сок", "Апельсиновый"));
        OrderManager orderManager = new OrderManager();
        try{
            orderManager.add(restaurantOrder, 1);
        } catch (OrderAlreadyException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(Arrays.toString(restaurantOrder.getMenu()));
        System.out.println("Общая стоимость: " + restaurantOrder.getCost());

        System.out.println();
        System.out.println("Интернет заказ: ");
        OrderManager orderManager1 = new OrderManager();
        Order internetOrder = new InternetOrder();
        internetOrder.add(new Dish(350, "Удон", "С курицей"));
        internetOrder.add(new Drink(190, "Морс", "Черничный"));
        String address = "Москва, 1-й Хорошевский проезд, 14к1";

        try {
            orderManager1.add(internetOrder, address);
        } catch (OrderAlreadyException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(Arrays.toString(internetOrder.getMenu()));
        System.out.println("Общая стоимость: " + internetOrder.getCost());

    }
}