import java.util.ArrayList;

public class merge2BSTs {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }
    //function forInOrder Sequence
    public static void getInOrder(Node root, ArrayList<Integer> arr){
        if(root == null) return;

        getInOrder(root.left, arr);
        arr.add(root.data);
        getInOrder(root.right, arr);

    }
    //function to createBST
    public  static Node createBST(ArrayList<Integer> arr, int st, int end){
        if(st > end) return null;

        int mid = (st + end)/2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr, st, mid-1);
        root.right = createBST(arr, mid+1, end);

        return root;
    }
    //preOrder Sequence to print balancedBST
    public static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    //function for Merege 2 BSTs
    public static Node mergerBSTs(Node root1, Node root2){
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        //Step 1-> Find InOrder Sequence of BST1, BST2
        getInOrder(root1, arr1);
        getInOrder(root2, arr2);

        //Step 2-> Merge AL arr1, arr2
        int i=0, j=0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while(i < arr1.size() && j < arr2.size()){
            if(arr1.get(i) <= arr2.get(j)){
                finalArr.add(arr1.get(i));
                i++;
            }
            else{
                finalArr.add(arr2.get(j));
                j++;
            }
        }
        //For remaining
        while(i < arr1.size()){
            finalArr.add(arr1.get(i));
            i++;
        }
        while(j < arr2.size()){
            finalArr.add(arr2.get(j));
            j++;
        }

        //Step 3-> sorted AL -> balanced BST
        return createBST(finalArr, 0, finalArr.size()-1);
    }

    public static void main(String[] args) {
        //BST-1
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        //BST-2
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergerBSTs(root1, root2);
        preOrder(root); // 3->1->2->9->4->12
    }
}
