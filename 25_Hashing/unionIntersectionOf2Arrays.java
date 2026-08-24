import java.util.HashSet;

public class unionIntersectionOf2Arrays {
    public static void main(String[] args) {
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};

        HashSet<Integer> set = new HashSet<>();
        //union
        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }
        for(int i=0; i<arr2.length; i++){
            set.add(arr2[i]);
        }

        System.out.println("Union = " + set.size());

        for(int union : set){
            System.out.println("Union elements = " + union);
        }

        //Intersection
        set.clear();
        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }

        int count = 0;
        for(int i=0; i<arr2.length; i++){
            if(set.contains(arr2[i])){
                count++;
                System.out.println("Intersection Elements = " + arr2[i]);
                set.remove(arr2[i]);
            }
        }
        System.out.println("Intersection = " + count);
    }
}
