public class implement_queue_using_Arrays {
    static class Queue{
        static int arr[];
        static int size;
        static int rear;

        Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public static boolean isEmpty(){
            return rear == -1;
        }

        //Add Operation - O(1)
        public static void add(int data){
            if(rear == size-1) { //check queue is full or not
                System.out.println("Queue is Full");
                return;
            }
            rear = rear+1;
            arr[rear] = data;
        }

        //Remove Operation - O(n)
        public static int remove(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            int front = arr[0];
            for(int i=0;i<rear; i++){
                arr[i] = arr[i+1];
            }
            rear = rear - 1;
            return front;
        }

        //peek Operation - front Value - O(1)
        public static int peek(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            return arr[0]; //front value;
        }
    }
    //main func.
    public static void main(String args[]){
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
