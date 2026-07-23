import java.util.PriorityQueue;

public class connectNRopes {
    public static void main(String[] args) {
        int ropes[] = {2,3,3,4,6};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<ropes.length; i++){
            pq.offer(ropes[i]);
        }
        int cost = 0;
        while(pq.size() > 1){
            int min1 = pq.poll();
            int min2 = pq.poll();

            cost += min1 + min2;
            pq.offer(min1 + min2);

        }
        System.out.println("Cost of Connecting N Ropes is = " + cost); //41
    }
}
