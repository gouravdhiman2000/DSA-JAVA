import java.util.LinkedList;
import java.util.*;
public class deque {
    public static void main(String[] args) {
        Deque<Integer> d = new LinkedList<>();
        d.addFirst(1);
        d.addFirst(2);
        d.addLast(3);
        d.addLast(4);
        System.out.println(d);
        // d.removeLast(); 
        d.removeFirst();
        System.out.println(d);
        System.out.println("First el = "+ d.getFirst());
        System.out.println("Last el = "+ d.getLast());
    }
}
