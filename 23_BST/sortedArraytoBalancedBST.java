public class sortedArraytoBalancedBST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }
    public static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    //Sorted Array to Balanced BST
    public static Node createBST(int arr[], int st, int end){
        if(st > end) return null; //invalid case

        int mid = (st+end)/2;
        Node root = new Node(arr[mid]);

        //Recursively create LST
        root.left = createBST(arr, st, mid-1);

        //Recursively create RST
        root.right = createBST(arr, mid+1, end);

        return root;
    }
    public static void main(String[] args) {
        int arr[] ={3,5,6,8,10,11,12};

        Node root = createBST(arr, 0, arr.length-1);
        preOrder(root); // 8,5,3,6,11,10,12
    }
}
