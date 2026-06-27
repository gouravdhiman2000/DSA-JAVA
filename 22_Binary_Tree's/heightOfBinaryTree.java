public class heightOfBinaryTree {
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
    //height of binary tree
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }
    // count number of nodes
    public static int count(Node root){
        if(root == null){
            return 0;
        }
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount + rightCount + 1;
    }
    //sum of nodes
    public static int sum (Node root){
        if(root == null){
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        return leftSum + rightSum + root.data;
    }
    //diameter of BT - approach 1
    public static int diameter(Node root){
        if(root == null){
            return 0;
        }
        int ld = diameter(root.left);
        int lh = height(root.left);

        int rd = diameter(root.right);
        int rh = height(root.right);

        int selfdia = lh + rh + 1;

        return Math.max(selfdia, Math.max(ld, rd));
    }

    //diameter of BT - approach 2
    static class Info{
        int dia;
        int ht;
        public Info(int dia, int ht){
            this.dia = dia;
            this.ht = ht;
        }
    }

    public static Info diameter2(Node root){
        if(root == null){
            return new Info(0,0);
        }
        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int dia = Math.max(Math.max(leftInfo.dia, rightInfo.dia), leftInfo.ht + rightInfo.ht + 1);

        int ht = Math.max(leftInfo.ht , rightInfo.ht) + 1;

        return new Info(dia, ht);
    }
    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             / \ / \
            4  5 6  7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        //System.out.println(height(root));

        //System.out.println(count(root));

        //System.out.println(sum(root));

        //System.out.println(diameter(root));

        Info result = diameter2(root);

        System.out.println("Diameter of Binary Tree = " + result.dia);
        System.out.println("Height of Binary Tree = " + result.ht);
    }
}
