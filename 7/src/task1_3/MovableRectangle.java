package task1_3;

public class MovableRectangle implements Movable{
    private MovablePoint topLeft;
    private MovablePoint bottomRight;
    public MovableRectangle (int x1, int y1, int x2, int y2, int xSpeed1,
                             int ySpeed1, int xSpeed2,
                             int ySpeed2) {
        this.topLeft = new MovablePoint(x1, y1, xSpeed1, ySpeed1);
        this.bottomRight = new MovablePoint(x2, y2, xSpeed2, ySpeed2);
    }
    @Override
    public String toString() {
        return "Rectangle (" + topLeft.x + ", " + topLeft.y + ", " +
                bottomRight.x + ", " + bottomRight.y + ")";
    }
    @Override
    public void moveUp() {topLeft.moveUp(); bottomRight.moveUp();}
    @Override
    public void moveDown() {topLeft.moveDown(); bottomRight.moveDown();}
    @Override
    public void moveRight() {topLeft.moveRight();
        bottomRight.moveRight();}
    @Override
    public void moveLeft() {topLeft.moveLeft(); bottomRight.moveLeft();}

    public boolean SpeedTest(){
        return (topLeft.xSpeed * topLeft.xSpeed + topLeft.ySpeed * topLeft.ySpeed == bottomRight.xSpeed * bottomRight.xSpeed + bottomRight.ySpeed * bottomRight.ySpeed);
    }

    public static void main(String[] args){
        MovableRectangle rectangle = new MovableRectangle(1,1,2,2,1,3,3,1);
        System.out.println(rectangle.SpeedTest());
    }
}
