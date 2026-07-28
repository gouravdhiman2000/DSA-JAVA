import java.util.LinkedHashMap;
import java.util.TreeMap;

public class linkedHashMap_TreeMap {
    public static void main(String[] args) {
        //LinkedHashMap - keys are insertion ordered
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 150);
        lhm.put("China", 100);
        lhm.put("USA", 50);
        lhm.put("Nepal", 30);

        System.out.println(lhm);

        //TreeMap -> sorting is based on keys
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 150);
        tm.put("China", 100);
        tm.put("USA", 50);
        tm.put("Nepal", 30);

        System.out.println(tm);


    }
}
