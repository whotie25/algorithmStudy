package AL002_Search;
import java.util.Scanner;
import java.util.Arrays;
import Graph.LinkedListGraph;
import Queue.LinkedQueue.LinkedQueue;

public class BFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // GRAPH INPUT
        System.out.print("Enter a number of vertexes : ");
        int vertexCount = sc.nextInt();
        LinkedListGraph graph = new LinkedListGraph(vertexCount);
        System.out.print("Enter a numver of edges : ");
        int edgeCount = sc.nextInt();
        System.out.print("Enter \'Y\' if edges are directed, otherwise enter \'N\' : ");
        boolean isDirected = (sc.next().charAt(0) =='Y')?true:false;
        if(isDirected) {
            for(int i = 0; i < edgeCount; i++) {
                System.out.print("Enter a pair of vertexes : ");
                int v_1 = sc.nextInt();
                int v_2 = sc.nextInt();

                graph.addEdge(v_1, v_2);
            }
        } else {
            for(int i = 0; i < edgeCount; i++) {
                System.out.print("Enter a pair of vertexes : ");
                int v_1 = sc.nextInt();
                int v_2 = sc.nextInt();

                graph.addEdge(v_1, v_2);
                graph.addEdge(v_2, v_1);
            }
        }

        // START VERTEX INPUT
        System.out.print("Enter a start vertex : ");
        int start = sc.nextInt();
        sc.close();

        // BFS
        int[] distance = bfs(graph, start);
        
        // OUTPUT
        System.out.println(Arrays.toString(distance));
    }

    // BFS FUNCTION
    public static int[] bfs(LinkedListGraph _graph, int _start) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        
        boolean[] visited = new boolean[_graph.vertexCount()];
        int[] distance = new int[_graph.vertexCount()];
        Arrays.fill(distance, _graph.vertexCount());

        // INITIALIZATION
        visited[_start] = true;
        distance[_start] = 0;
        queue.add(_start);

        // SEARCH
        while(!queue.empty()) {
            int currVertex = queue.remove();
            int[] currNeighbor = _graph.neighborToArray(currVertex);
            for(int neighbor : currNeighbor) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[currVertex] + 1;
                    queue.add(neighbor);
                }
            }

        }

        return distance;
    }
}
