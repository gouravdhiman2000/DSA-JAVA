
import java.util.ArrayList;
import java.util.LinkedList;

public class hashMapImplementation {
    static class HashMap <K, V>{ //generic -> parameeterized types
        private class Node{
            K key;
            V value;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n; //n
        private int N; //N

        private LinkedList<Node> buckets[]; //N= buckets.length

        @SuppressWarnings ("unchecked")
        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];

            for(int i=0; i<4; i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            int hc = key.hashCode(); //given code can be +ve, -ve

            return Math.abs(hc) % N;
        }

        private int searchInLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            int di = 0;
            for(int i=0; i<ll.size(); i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return di;
                }
                di++;
            }
            return -1;
        }

        private void rehash(){
            LinkedList<Node> oldBuck[] = buckets;

            buckets  = new LinkedList[N * 2];
            N = 2 * N;

            for(int i=0; i<buckets.length; i++){
                buckets[i] = new LinkedList<>();
            }

            //Nodes - add in bucket
            for(int i=0; i<oldBuck.length; i++){
                LinkedList<Node> ll = oldBuck[i];

                for(int j=0; j<ll.size(); j++){
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value){
            int bi = hashFunction(key);  //0 to size-1;

            //Search on LL, find the data index
            int di = searchInLL(key, bi);  //return valid , -1

            if(di != -1){
                //valid data index
                Node node = buckets[bi].get(di);
                node.value = value; //update
            }
            else{
                //di = -1
                buckets[bi].add(new Node(key,value));
                n++;
            }

            double lamda = (double) n / N;

            if(lamda > 2.0){
                rehash();
            }
        }

        public boolean containsKey(K key){
            int bi = hashFunction(key);  //0 to size-1;

            //Search on LL, find the data index
            int di = searchInLL(key, bi);  //return valid , -1

            if(di != -1){
                //valid data index
                return true;
            }
            else{
                //di = -1
                return false;
            }
        }

        public V get(K key){
            int bi = hashFunction(key);  //0 to size-1;

            //Search on LL, find the data index
            int di = searchInLL(key, bi);  //return valid , -1

            if(di != -1){
                //valid data index
                Node node = buckets[bi].get(di);
                n--;
                return node.value;
            }
            else{
                //di = -1
                return null;
            }
        }

        public V remove(K key){
            int bi = hashFunction(key);  //0 to size-1;

            //Search on LL, find the data index
            int di = searchInLL(key, bi);  //return valid , -1

            if(di != -1){
                //valid data index
                Node node = buckets[bi].remove(di);
                return node.value;
            }
            else{
                //di = -1
                return null;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0; i<buckets.length; i++){
                LinkedList<Node> ll = buckets[i];

                for(Node node : ll){
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n == 0;
        }
    }
    public static void main(String[] args) {
        HashMap<String , Integer> map = new HashMap<>();

        map.put("India", 150);
        map.put("China", 100);
        map.put("USA", 50);
        map.put("Nepal", 30);

        ArrayList<String> keys = map.keySet();

        for(String key : keys){
            System.out.println(key); //output in random order
        }

        System.out.println(map.get("India")); //150
        System.out.println(map.get("Nepal")); //30 
        System.out.println(map.get("Russia")); //null
        System.out.println(map.remove("China")); //100
    }
}
