import java.util.*;
public class FrequencyOfElements {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("apple");
        list.add("orange");

        Map<String, Integer> map = new HashMap<>();

        for(String item : list){
            if(map.containsKey(item))
                map.put(item, map.get(item) + 1);
            else
                map.put(item, 1);
        }
        System.out.println("Frequency of Elements: " + map);
    }
}
