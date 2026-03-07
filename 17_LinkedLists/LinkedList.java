public class LinkedList {
    
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    //Size of a Linkedlist
    public static int size;

    //Methods-> Operation to be performed on LL is done by methods
    public void addFirst(int data){
        //Step 1-> create new node
        Node newNode = new Node(data);
        size++;
        //Base case->assuming LL is empty -> first create a newNode
         if(head == null){
            head = tail = newNode;
            return;
        }

        //Step 2-> newNode next = head;
        newNode.next = head; //Link

        //Step 3-> Update head value -> head = newNode
        head = newNode;
    }

    public void addLast(int data){

        //Step 1-> create a new Node
        Node newNode = new Node(data);
        size++;
        //Base case -> If LL is empty
        if(head == null){
            head = tail = newNode;
            return;
        }

        //Step 2-> Tail next = newNode
        tail.next = newNode;

        //Step 3-> tail = newNode
        tail = newNode;
    }

    //print method
    public void print(){
        //Base case-> LL is empty
        if(head == null){
            System.err.println("LinkedList is Empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.err.print(temp.data + "->");
            temp = temp.next;
        }
        System.err.println("null");
    }

    //add in the middle
    public void add(int idx, int data){
        //Special Case
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while(i < idx-1){
            temp = temp.next;
            i++;
        }

        // i = idx-1; temp-> prev
        newNode.next = temp.next;
        temp.next = newNode;

    }

    //removeFirst method->return the value of node which is deleting
    public int removeFirst(){
        //Special case
        //case 1-> LL is empty
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        //Case 2-> If Head and Tail pointing to same node means it is a single node
        else if(size == 1){
            int val = head.data;
            //change both head and tail
            head = tail = null;
            //size also changes
            size = 0;

            return val;
        }
        int val = head.data;
        head = head.next;
        //removing node so size changes
        size--;
        return val;
    }

    //removeLast method -> delete tail node, return the value of that node
    public int removeLast(){
        //Case-1 If LL is empty
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        //Case 2-> If Head and Tail pointing to same node means it is a single node
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        //prev node index: i = size-2
        Node prev = head;
        for(int i=0;i<size-2; i++){
            prev = prev.next;
        }
        int val = prev.next.data; //tail.data
        prev.next = null;
        tail = prev;
        //size changes if removig from last
        size--;
        return val;
    }

    //Iterative Search in LL
    public int itrSearch(int key){
        Node temp = head;
        int i=0;

        while(temp!= null){
            //key found case
            if(temp.data == key){
                return i;
            }
            //update temp and i
            temp = temp.next;
            i++;
        }
        //key not found
        return -1;
    }

    //Recursive Search
    //In recSearch func. head is getting changed, so we created helper func. to chnage the head, helper func. is the actual recursive func.
    public int helper(Node head, int key){
        //base case
        if(head == null){
            return -1;
        }

        if(head.data == key){
            return 0;
        }
        //track can helper func. find the key in the rest of the LL
        int idx = helper(head.next, key);
        //if not able to find
        if(idx == -1){
            return -1;
        }
        //if able to find
        return idx+1;
    }
    public int recSearch(int key){
        return helper(head, key);
    }

    //Reverse a LL -> Iterative Approach
    public void reverseLL(){
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr!= null){
            //Steps
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //update head node
        head = prev;
    }

    //Find and remove Nth Node from End
    public void deleteNthfromEnd(int n){
        //1-> Calculate size of LL
        int sz = 0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            sz++;
        }
        //Corner Case->Agar head ko delete krna ho
        if(n == sz){
            head = head.next; //removeFirst operation
            return;
        }
        //sz-n
        int i = 1;
        int iToFind = sz-n;
        Node prev = head;
        while(i < iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    public static void main(String[] args) {
            // write your code here
            LinkedList ll = new LinkedList();
            ll.print();
            ll.addFirst(2);
            ll.print();
            ll.addFirst(1);
            ll.print();
            ll.addLast(4);
            ll.print();
            ll.addLast(5);
            ll.add(2,3);
            ll.print();

            System.out.println("Linkedlist_Size: "+ ll.size);

            // ll.removeFirst();
            // ll.print();

            // System.out.println("Linkedlist_Size: "+ ll.size);

            // ll.removeLast();
            // ll.print();
            // System.out.println("Linkedlist_Size: "+ ll.size);

            // System.out.println(ll.itrSearch(3));
            // System.out.println(ll.itrSearch(10));

            // System.out.println(ll.recSearch(3));
            // System.out.println(ll.recSearch(10));

            // ll.reverseLL();
            // ll.print();

            ll.deleteNthfromEnd(3);
            ll.print();
        }
    }



