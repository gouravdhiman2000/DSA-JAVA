import java.util.ArrayList;

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

    //Convert BST to Balanced BST
    public static Node balanceBST(Node root){
        //1-> Calculate InOrder Sequence
        ArrayList<Integer> inOrder = new ArrayList<>();
        getInOrder(root, inOrder);

        //2-> Sorted InOrder AL -> Balanced BST
        root = createBalancedBST(inOrder, 0, inOrder.size()-1);

        return root;

    }
    //fxn for InOrder Traversal
    public static void getInOrder(Node root, ArrayList<Integer> inOrder){
        if(root == null) return;

        getInOrder(root.left, inOrder); //Left
        inOrder.add(root.data); //root
        getInOrder(root.right, inOrder); //right
    }

    //fxn to create BST
    public static Node createBalancedBST(ArrayList<Integer> inOrder, int st, int end){
        if(st > end) return null;

        int mid = (st+end)/2;

        Node root = new Node(inOrder.get(mid));
        root.left = createBalancedBST(inOrder, st, mid -1);
        root.right = createBalancedBST(inOrder, mid + 1, end);

        return root;
    }
    public static void main(String[] args) {
        int arr[] ={3,5,6,8,10,11,12};

        //Node root = createBST(arr, 0, arr.length-1);
        //preOrder(root); // 8,5,3,6,11,10,12

        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        /*
                        8
                       /  \
                      6    10
                     /      \
                    5        11
                   /          \
                  3            12
         */

        root = balanceBST(root);
        preOrder(root); // 8->5->3->6->11->10->12
        /*
                        8
                       / \
                      5   11
                     / \  / \
                    3   6 10  12
         */     

    }
}
