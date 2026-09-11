import java.util.*;

public class detectCycle{

    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean visit[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!visit[i]){
                if(detectCycleUtil(graph, visit, i, -1)){
                    return true;
                    //Cycle exists in one of the parts/components
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean visit[], int curr, int par){
        visit[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            //case - 3
            if(!visit[e.dest]){
                if(detectCycleUtil(graph, visit, e.dest, curr)){
                    return true;
                }
                return true;
            }

            //case - 1
            else if(visit[e.dest] && e.dest != par){
                return true;
            }

            //case - 2 -> do nothing -> continue
        }
        return false;
    }
    
    public static void main(String[] args) {

        int V = 9;

        ArrayList<Edge>[] graph = new ArrayList[V];

        // Create ArrayList for every vertex
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }


        // Component 1
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));


        // Component 2
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));


        // Component 3
        graph[6].add(new Edge(6, 7));
        graph[6].add(new Edge(6, 8));

        graph[7].add(new Edge(7, 6));
        graph[7].add(new Edge(7, 8));

        graph[8].add(new Edge(8, 6));
        graph[8].add(new Edge(8, 7));


       System.out.println(detectCycle(graph));
    }
}
