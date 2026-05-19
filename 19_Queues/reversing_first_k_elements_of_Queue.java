import java.util.*;
public class reversing_first_k_elements_of_Queue {
    public static Queue<Integer> reverseFirstk (Queue<Integer> q , int k){
        int n = q.size();
        Deque<Integer> dq = new ArrayDeque<>();
        //Step-1 -> add first k elements of (q) into dq at the front of dq one by one
        for(int i=1; i<=k; i++){
            int element = q.remove();
            dq.push(element);
        }

        //Step-2 -> take elements from dq and add into Queue
        while(!dq.isEmpty()){
            q.add(dq.remove());
        }

        //Step-3 -> remove (n-k) elements from the front of Queue and push at back one by one
        for(int i=1;i<=n-k;i++){
            int element = q.remove(); //remove element
            q.add(element); //adding it at the back of queue
        }
        return q;
    }
    public static void main(String[] args) {
        Queue <Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        int k = 5;
        System.out.println(reverseFirstk(q, k));
    }
}
