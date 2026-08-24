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

        //Iteration in Hashset
        HashSet<String> cities = new HashSet<>();
        cities.add("Palampur");
        cities.add("Solan");
        cities.add("Biara");
        cities.add("Panchrukhi");

        //using iterators
        Iterator i = cities.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        //using enhanced for loop
        for(String city : cities){
            System.out.println(city);
        }

        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Palampur");
        lhs.add("Solan");
        lhs.add("Biara");
        lhs.add("Panchrukhi");
        System.out.println(lhs); //output as -> of insertion order


        TreeSet<String> ts = new TreeSet<>();
        ts.add("Palampur");
        ts.add("Solan");
        ts.add("Biara");
        ts.add("Panchrukhi");
        System.out.println(ts); //output as -> ascending order

    }
}
