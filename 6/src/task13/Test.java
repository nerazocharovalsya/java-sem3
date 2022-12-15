package task13;

public class Test implements Display, Observer{
    private static int count = 0;

    private StringBuilder str;
    private int id;

    public Test()
    {
        count++;
        id = count;
        str = new StringBuilder();
    }

    public void update(StringBuilder st)
    {
        str.replace(0, str.length(), st.toString());
    }

    public void display()
    {
        System.out.println("Display " + id + ": " + str);
    }

    public static void main(String... args)
    {
        ObserverStringBuilder str = new ObserverStringBuilder("Hello");
        Test display1 = new Test();
        str.setObserver(display1);
        display1.display();
        str.insert("WWW", 3);
        str.removeObserver(display1);
        display1.display();
    }
}
