import java.util.HashMap;

public class largestSubarrayWithSumZero {
    public static void main(String[] args) {
        int arr[] = {15,-2,2,-8,1,7,10};
        int n = arr.length;
        HashMap<Integer,Integer> map= new HashMap<>();
        //sum, idx
        int sum = 0;
        int len = 0;

        for(int j=0; j<n; j++){
            sum += arr[j];
            if(map.containsKey(sum)){
                len = Math.max(len, j - map.get(sum)); //comparing length
            }
            else{
                map.put(sum, j);
            }
        }
        System.out.println("Largest Subarray with sum as 0 -> " + len);
    }
}
