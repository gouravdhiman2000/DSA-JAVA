import java.util.PriorityQueue;

public class minimumCost_ToConnectAllRopes {
    public static int minimumCost(int arr[]){
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //min heap
        //push all the ropes in min heap
        for(int i=0; i<n;i++){
            pq.add(arr[i]);
        }
        //jab tak ek se zada element hai-> add in min heap
        int ans = 0;
        while(pq.size() > 1){
            int a = pq.remove();
            int b = pq.remove();
            int newRope = a+b;
            ans += newRope;
            pq.add(newRope);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {4,2,7,6,9};
        System.out.println( minimumCost(arr));
    }   
}
