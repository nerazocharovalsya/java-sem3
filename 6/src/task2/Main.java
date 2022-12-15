package task2;

public class Main {
    public static void main(String[] args) {
        // Создаем экземпляр класса MovablePoint
        MovablePoint point = new MovablePoint(1, 2, 3, 4);
        System.out.println(point);
        // Двигаем point вверх и влево
        point.moveUp();
        point.moveLeft();
        System.out.println(point);
        // Создаем экземпляр класса MovableCircle
        MovableCircle circle = new MovableCircle(4, 3, 2, 1, 4);
        System.out.println(circle);
        // Двигаем circle вниз и вправо
        circle.moveDown();
        circle.moveRight();
        System.out.println(circle);
        // Создаем экземпляр класса MovableRectangle
        MovableRectangle rectangle = new MovableRectangle(1, 2, 5, 6, 1, 2);
        System.out.println(rectangle);
        // Двигаем rectangle вверх и влево
        rectangle.moveUp();
        rectangle.moveLeft();
        System.out.println(rectangle);
    }
}