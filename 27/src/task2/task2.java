package task2;

import java.util.HashMap;
import java.util.Map;

public class task2 {
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<>();

        map.put("А", "Б");
        map.put("В", "Г");
        map.put("Д", "Е");
        map.put("Ж", "Б");
        map.put("З", "И");
        map.put("К", "Л");
        map.put("М", "Н");
        map.put("О", "Е");

        return map;
    }
    public static int getSameFirstNameCount(HashMap<String, String> map, String name)
    {
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getValue().equals(name)) {
                count++;
            }
        }
        return count;
    }
    public static int getSameLastNameCount(HashMap<String, String> map, String lastName)
    {
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getKey().equals(lastName)) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Map<String, String> map;
        map = createMap();
        System.out.println(map);
        System.out.println(getSameFirstNameCount((HashMap<String, String>) map, "Е"));
        System.out.println(getSameLastNameCount((HashMap<String, String>) map, "Ж"));
    }
}
