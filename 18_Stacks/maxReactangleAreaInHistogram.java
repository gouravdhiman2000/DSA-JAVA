import java.util.Stack;

public class maxReactangleAreaInHistogram {
    
    public static void maxArea(int arr[]){
        int n = arr.length;
        int nsr[] = new int[n];
        int nsl[] = new int[n];
        int maxArea = 0;

        //Next Smallest Right- O(n)
        Stack<Integer> s = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = n;
            }
            else{
                //top
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        //Next Smallest left - O(n)
        s = new Stack<>();
        for(int i=0; i<n; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1;
            }
            else{
                //top
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        //Current Area : Width = j-i-1 = nsr[i] - nsl[i] -1  -> O(n)
        for(int i=0; i<n; i++){
            int height = arr[i];
            int width = nsr[i]-nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        }
        System.out.println("Max Area in Histogram = " + maxArea);
     }
    public static void main(String[] args) {
        int arr[] = {2,1,5,6,2,3};
        maxArea(arr);
    }
}
