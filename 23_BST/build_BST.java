public class build_BST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }
    //insert function for BST
    public static Node insert(Node root, int val){
        if(root == null){
            //create new Node, insert value in it
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            //leftSubTree
            root.left = insert(root.left, val);
        }
        else{
            //root.data < val -> rightSubTree
            root.right = insert(root.right, val);
        }
        return root;
    }
    //InOrder Traversal in BST
    public static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    //Search in a BST
    public static boolean search(Node root, int key){
        if(root == null) return false;

        if(root.data == key) return true;

        if(root.data > key){
            //search in LST
            return search(root.left, key);
        }
        else{
            //root.data < key -> search in RST
            return search(root.right, key);
        }
    }

    //Delete a Node in BST
    public static Node delete(Node root, int val){
        if(root.data < val){
            //search the deleting node in RST
            root.right = delete(root.right, val);
        }
        else if(root.data > val){
            //search the deleting node in LST
            root.left = delete(root.left, val);
        }
        else{
            //Found the deleting Node
            //Case 1 -> Leaf Node
            if(root.left == null && root.right == null){
                return null;
            }
            //Case 2-> One child
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            //Case 3 -> Two children
            //Step 1-> find Inorder Successor
            Node IS = findInOrderSuccessor(root.right); //IS -> Left most node in right Subtree
            //Step 2-> Replace value with IS
            root.data = IS.data; //replace
            //Step 3-> Delete the node for IS
            root.right = delete(root.right, IS.data); //Delete IS
        }
        return root;
    }
    public static Node findInOrderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    //print in range 
    public static void printInRange(Node root, int k1, int k2){
        if(root == null) return;

        if(root.data >= k1 && root.data <= k2){
            //k1 <= root.data <= k2
            printInRange(root.left, k1, k2); //Left subtree
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2); //right subtree
        }
        else if(root.data < k1){
            //left Subtree
            printInRange(root.left, k1, k2);
        }
        else{
            //root.data > k2 -> right Subtree
            printInRange(root.right, k1, k2);
        }

    }
    public static void main(String[] args) {
        int values[] ={8,5,3,1,4,6,10,11,14};
        Node root = null;

        for(int i=0; i<values.length; i++){
            root = insert(root, values[i]);
        }
        inOrder(root); //To verify correct BST is constructed or not, because inOrder Traversal on BST gives Sorted Sequence
        System.out.println();

        // if(search(root, 8)){
        //     System.out.println("Key Found in BST");
        // }
        // else{
        //     System.out.println("Key Not Found in BST");
        // }

        //delete(root, 1);//case - 1 
        //delete(root, 10); //case - 2 
        // delete(root, 5);//case - 3  
        // System.out.println();
        // inOrder(root);

        printInRange(root, 5, 12);
    }
}
