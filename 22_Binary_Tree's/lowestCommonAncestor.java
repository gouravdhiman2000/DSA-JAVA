import java.util.*;
public class lowestCommonAncestor {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    //Approach 1 -> to find Lowest common Ancestor
    public static boolean getPath(Node root, int n, ArrayList <Node> path){
        if(root == null) return false;

        path.add(root);
        if(root.data == n) return true;

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundright = getPath(root.right, n, path);

        if(foundLeft || foundright) return true;

        path.remove(path.size()-1);

        return false;
    }
    public static Node lca(Node root, int n1, int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root,n1, path1);
        getPath(root,n2, path2);

        //last common ancestor
        int i=0;
        for(; i<path1.size() && i<path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }
        //last equal node index -> i-1 th index

        Node lca = path1.get(i-1);
        return lca;
    }

    //Approach 2 -> to find Lowest common Ancestor
    public static Node lca2(Node root, int n1, int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        //find lca in left and Right subtree
        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        //Case 1-> leftLca = valid value and rightLca = null -> return leftLca;
        if(rightLca == null) return leftLca;

        //Case 2-> rightLca = valid value and leftLca = null -> return rightLca;
        if(leftLca == null) return rightLca;

        //Case 3-> rightLca && leftLca != null -> return root
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4, n2 = 5;
        System.out.println(lca2(root, n1, n2).data);
    }
}
