public class heapSort {
    public static void heapSort(int arr[]){
        //Step - 1-> build maxHeap 
        int n = arr.length;
        for(int i=n/2; i>=0; i--){
            heapify(i,n,arr); //i-index, n-size, arr- array
        }
        //Step 2-> push largest at end
        for(int i=n-1; i>0; i--){
            //Swap(largest -> first index with last Index)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            heapify(0, i, arr);
        }
    }
    public static void heapify(int i, int size, int arr[]){
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i; //i-> root
        
        if(left < size && arr[left] > arr[maxIdx]){
            maxIdx = left;
        }
        if(right < size && arr[right] > arr[maxIdx]){
            maxIdx = right;
        }

        if(maxIdx != i){
            //Swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(maxIdx, size, arr);
        }
    }
    public static void main(String[] args) {
        int arr[] ={1,2,4,5,3};
        heapSort(arr);
        //print
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    } 
}
