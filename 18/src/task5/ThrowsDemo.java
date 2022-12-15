package task5;

public class ThrowsDemo {
    public void getDetails(String key) {
        try{
            System.out.println(key);
        }
        catch (Exception e){
            throw new NullPointerException("null key in getDetails");
            //System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        ThrowsDemo demo = new ThrowsDemo();
        demo.getDetails(null);
    }
}
