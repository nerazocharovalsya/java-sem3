public class illegalAddress extends Error{
    public illegalAddress(String address){
        super("Нет адреса: " + address + "");
    }
}
