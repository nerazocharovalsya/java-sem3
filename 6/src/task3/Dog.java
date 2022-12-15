package task3;

public class Dog implements Nameable{
    private String name;

    public String getName() {
        return name;

    }
    public void setName(String name){
        this.name = name;
    }

    public static void main(String[] args){
        Dog dog = new Dog();
        dog.setName("Шарик");
        System.out.println(dog.getName());
    }
}
