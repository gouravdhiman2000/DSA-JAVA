import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class activity_Selection {
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};

        //sorting if end[] is not sorted
        int act[][] = new int[start.length][3];
        for(int i=0; i<start.length;i++){
            act[i][0] = i;
            act[i][1] = start[i];
            act[i][2] = end[i];
        }
        //lamda fxn -> shortform of func.
        Arrays.sort(act, Comparator.comparingDouble( o -> o[2]));
        //In Java, Comparator is an interface for sorting Java Objects

        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        //1st activity
        maxAct = 1;
        ans.add(act[0][0]);
        //End time of 1st activity
        int lastEnd = act[0][2];

        for(int i=0; i< end.length; i++){
            if(act[i][1] >= lastEnd){
                //Select activity -> non-overlapping activity
                maxAct++;
                ans.add(act[i][0]);
                lastEnd = act[i][2];
            }
        }
        System.out.println("Max Activities = " +  maxAct);
        for(int i=0; i<ans.size(); i++){
            System.out.print("A" + ans.get(i) + " ");
        }   
    }
}
