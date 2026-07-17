import java.util.*;
public class PriorityQueues {
    static class Student implements Comparable<Student>{ //Interface -> overriding
        String name;
        int rank;
        
        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }
        //overriding -> parent class func. that child class also implements that function too
        @Override 
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }
    public static void main(String[] args) {
        //PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // pq.add(3);
        // pq.add(4); //O(log n)
        // pq.add(1);
        // pq.add(7);

        pq.add(new Student("A", 4));
        pq.add(new Student("B", 1));
        pq.add(new Student("C", 3));
        pq.add(new Student("D", 2));

        while(!pq.isEmpty()){
            //System.out.println(pq.peek()); //O(1)
            System.out.println(pq.peek().name + " -> " + pq.peek().rank);
            pq.remove(); //O(log n)
        }
        
    }
}
