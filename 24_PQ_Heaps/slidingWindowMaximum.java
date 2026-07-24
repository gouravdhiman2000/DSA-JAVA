import java.util.PriorityQueue;

class Pair{
    int val, idx;

    public Pair(int val, int idx){
        this.val = val;
        this.idx = idx;
    }
}

public class slidingWindowMaximum {
    public static void main(String[] args) {
        int arr[] ={1,3,-1,-3,5,3,6,7};
        int k = 3; //window size
        int n = arr.length;
        int res[] = new int[n-k+1];

        //descending Order
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.val, a.val));

        //1st window
        for(int i=0; i<k; i++){
            pq.add(new Pair(arr[i], i));
        }
        res[0] = pq.peek().val; //maxValue

        for(int i=k; i<n; i++){
            while(pq.size() > 0 && pq.peek().idx <= (i-k)){
                pq.remove();
            }
            pq.add(new Pair(arr[i], i));

            res[i-k+1] = pq.peek().val;
        }

        //print result
        for(int i : res){
            System.out.print(i + " "); //3-3-5-5-6-7
        }
    }
}
