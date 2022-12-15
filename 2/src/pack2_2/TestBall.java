package pack2_2;

public class TestBall {
    public static void main(String[] args){
        Ball ball = new Ball();
        ball.setX(1);
        ball.setY(1);
        ball.move(3,7);
        System.out.println(ball.toString());
    }
}
