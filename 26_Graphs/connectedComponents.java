import java.util.*;

public class connectedComponents {

    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // BFS for all connected components
    public static void bfs(ArrayList<Edge>[] graph) {

        boolean visit[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {

            if (!visit[i]) {
                System.out.print("Component: ");
                bfsUtil(graph, i, visit);
                System.out.println();
            }
        }
    }

    // BFS for one component
    public static void bfsUtil(
            ArrayList<Edge>[] graph,
            int src,
            boolean[] visit) {

        Queue<Integer> q = new LinkedList<>();

        q.add(src);

        while (!q.isEmpty()) {

            int curr = q.remove();

            if (!visit[curr]) {

                // Step 1: Visit
                System.out.print(curr + " ");

                // Step 2: Mark visited
                visit[curr] = true;

                // Step 3: Add neighbours
                for (int i = 0; i < graph[curr].size(); i++) {

                    Edge e = graph[curr].get(i);

                    if (!visit[e.dest]) {
                        q.add(e.dest);
                    }
                }
            }
        }
    }


    // DFS for all connected components
    public static void dfs(ArrayList<Edge>[] graph) {

        boolean visit[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {

            if (!visit[i]) {

                System.out.print("Component: ");
                dfsUtil(graph, i, visit);
                System.out.println();
            }
        }
    }


    // DFS for one component
    public static void dfsUtil(
            ArrayList<Edge>[] graph,
            int curr,
            boolean[] visit) {

        // Step 1: Visit
        System.out.print(curr + " ");

        // Step 2: Mark visited
        visit[curr] = true;

        // Step 3: Visit neighbours
        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);

            if (!visit[e.dest]) {
                dfsUtil(graph, e.dest, visit);
            }
        }
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


        // BFS
        System.out.println("BFS:");
        bfs(graph);


        // DFS
        System.out.println("\nDFS:");
        dfs(graph);
    }
}
