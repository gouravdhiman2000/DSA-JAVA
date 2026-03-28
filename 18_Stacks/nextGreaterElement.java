import java.util.Stack;

public class nextGreaterElement {
    
    public static void main(String[] args) {
        int arr[] = {6,8,0,1,3};
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int nxtGreater[] = new int[n];

        for(int i=n-1; i>=0; i--){
            //1-> while loop
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }

            //2-> If -else
            if(s.isEmpty()){
                nxtGreater[i] = -1;
            }
            else{
                nxtGreater[i] = arr[s.peek()];
            }

            // 3-> push index in stack
            s.push(i);
        }
        
        for(int i=0; i<nxtGreater.length; i++){
            System.out.print(nxtGreater[i] + " ");
        }
        System.out.println();
    }
}
