import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class hashMapOperations {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        //Insert - O(1)
        map.put("India", 150);
        map.put("China", 100);
        map.put("USA", 50);
        map.put("Nepal", 30);
        map.put("Indonesia", 20);

        System.out.println(map); //Random Output -> because HashMap are UnOrdered map

        //Get - O(1)
        System.out.println(map.get("India")); //print that key -> value
        
        System.out.println(map.get("Russia")); //If key is not present -> null

        //containsKey - O(1) -> T/F If key is present or not
        System.out.println(map.containsKey("India")); //true
        System.out.println(map.containsKey("Russia")); //false

        //remove - O(1) -> print removed key value
        System.out.println(map.remove("China")); //100
        System.out.println(map); 

        //size
        System.out.println(map.size());

        //isEmpty
        System.out.println(map.isEmpty());

        //Iterate on hashMap
        Set<String> keys = map.keySet(); //O(1) -> return a Set containing all the keys

        for(String k : keys){ //O(n)
            System.out.println("Key = " + k + " , " + "Value = " + map.get(k)); //Random Order
        }

        Set<Map.Entry<String, Integer>> entries = map.entrySet();  //O(1)- return both key and value

        for(Map.Entry<String, Integer> entry : entries){
            System.out.println("Key = " + entry.getKey() + " , " + "Value = " + entry.getValue());
        }
    } 
}
