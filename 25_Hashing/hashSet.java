import java.util.*;
public class hashSet {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(2);

        set.remove(2);

        System.out.println(set);
        System.out.println(set.size());

        if(set.contains(2)){
            System.out.println("Set contains");
        }
        else{
            System.out.println("Don't contains");
        }

        set.clear();

        System.out.println(set.isEmpty());
    }
}
