import java.util.Stack;

public class implement_Queue_using_two_Stacks {
    static class Queue{
        static Stack <Integer> s1 = new Stack<>();
        static Stack <Integer> s2 = new Stack<>();

        public static boolean isEmpty(){
            return s1.isEmpty();
        }
    
        //add - O(n)
        public static void add(int data){
            //Step - 1
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            //Step - 2
            s1.push(data);
    
            //Step - 3
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
    
        //remove - O(1)
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue Empty");
                return -1;
            }
            return s1.pop();
        }

        //peek - O(1)
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue Empty");
                return -1;
            }
            return s1.peek();
        } 
    }
     public static void main(String args[]){
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
       
        q.add(4);
       
        q.add(5);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
