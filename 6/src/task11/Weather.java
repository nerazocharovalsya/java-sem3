package task11;

public class Weather implements Convertable {
    public int temperature;

    public Weather(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public int convertToK() {
        return temperature + 273;
    }

    @Override
    public int convertToF() {
        return (int) (temperature * 1.8 + 32);
    }

    public static void main(String[] args){
        Weather weather = new Weather(10);
        System.out.println(weather.convertToK());
        System.out.println(weather.convertToF());
    }
}
