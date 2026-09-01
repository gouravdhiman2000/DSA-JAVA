import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfsTraversalinGraph {
    public static class Edge{
        int src;
        int dest;
        

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
           
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>(); //null -> empty A.L
        }
        //Adding all the vertex's of the graph
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));
    }

    public static void bfs(ArrayList<Edge> graph[]){
        Queue<Integer> q = new LinkedList<>();

        boolean visit[] = new boolean[graph.length]; 

        q.add(0); //src - 0

        while(!q.isEmpty()){
            int curr = q.remove();
            if(!visit[curr]){
                // visit[curr]
                // Step-1
                System.out.print(curr  + " ");
                //Step - 2
                visit[curr] = true;
                //Step - 3
                for(int i=0; i < graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    //add neighbours of curr in queue
                    q.add(e.dest); 
                }
            }
        }
    }
    
    //dfs
    public static void dfs(ArrayList<Edge>[] graph, int curr , boolean visit[]){
        //visit
        System.out.print(curr + " ");
        visit[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            if(!visit[e.dest]){
                dfs(graph, e.dest, visit);
            }
        }
    }
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        bfs(graph); // 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6
        System.out.println();
        dfs(graph, 0, new boolean[V]); // 0 -> 1 -> 3 -> 4 -> 2 -> 5 -> 6
    }
}
