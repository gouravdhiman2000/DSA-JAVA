import java.util.HashMap;

public class majorityElement {
    public static void main(String[] args) {
        int arr[] = {1,3,2,5,1,3,1,5,1};

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0)+ 1);
        }

        for(Integer key : map.keySet()){
            if(map.get(key) > arr.length / 3){
                System.out.println(key); //1 - 4 freq >= n/3
            }
        }
    }
}
