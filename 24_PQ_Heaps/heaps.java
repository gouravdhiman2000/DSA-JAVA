import java.util.ArrayList;

public class heaps {
    static class Heap{
        //Define ArrayList
        ArrayList<Integer> arr = new ArrayList<>();

        //add in heap
        public void add(int data){  //Total T.C to add in heap -> O(log n)
            //1-> add data at last index
            arr.add(data); //O(1)
            int x = arr.size()-1; // x is child index
            int parent = (x-1)/2; //parent index

            while(arr.get(x) > arr.get(parent)){ //O(log n)
                //Swap
                int temp = arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);

                //update index
                x = parent;
                parent = (x-1)/2;
            }   
        }

        //peek from heap
        public int peek(){
            return arr.get(0); //minimum value always at root i=0
        }

        //Remove from heap
        public int remove(){
            int data = arr.get(0);

            //1-> Swap 1st and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //2-> Delete last index
            arr.remove(arr.size()-1);

            //heapify(root)
            heapify(0); //i=0
            return data;
        }

        //heapify function
        private void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i; //root is minimum in minHeap

            if (left < arr.size() && arr.get(minIdx) < arr.get(left)) {
                minIdx = left;
            }
            if(right < arr.size() && arr.get(minIdx) < arr.get(right)){
                minIdx = right;
            }

            if(minIdx != i){
                //Swap -> root with minimum value index
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);
                
                heapify(minIdx); //calling heapify for minIdx
            }
        }

        //check heap is empty or not
        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }
    public static void main(String[] args) {
        Heap pq = new Heap();
        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(5);

        while(!pq.isEmpty()){
            System.out.println(pq.peek()); //o/p-> sorted min to max (minHeap)
            pq.remove();
        }
    }
}
