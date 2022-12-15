package task4;

public class Car implements Priceable{
    private int price;

    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    public static void main(String[] args){
        Car car = new Car();
        car.setPrice(2800000);
        System.out.println(car.getPrice());
    }
}
