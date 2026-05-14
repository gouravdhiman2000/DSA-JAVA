public class implementing_Queue_Using_LinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class Queue{
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty(){
            return head == null && tail == null;
        }
    
        //Add Operation - O(1)
        public static void add(int data){
            Node newNode = new Node(data);
            //adding 1st element in queue
            if(head == null){
                head = tail = newNode;
                return;
            }
    
            tail.next = newNode;
            tail = newNode;
        }
    
        //Remove Operation - O(1)
        public static int remove(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            int front = head.data;
            if(tail == head){
                //Single element in Queue
                tail = head = null;
            }
            else{
                head = head.next;
            }
            return front;
        }
    
        //peek Operation - front Value - O(1)
        public static int peek(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            return head.data; //front value;
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
