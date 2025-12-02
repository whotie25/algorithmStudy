package Graph;
import java.util.Scanner;

public class LinkedListGraphTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertexes : ");
        int vertexes = sc.nextInt();
        LinkedListGraph graph = new LinkedListGraph(vertexes);

        System.out.print("Enter numver of edges : ");
        int edges = sc.nextInt();
        for(int i = 0; i < edges; i++) {
            System.out.print("enter pair of vertex : ");
            int v_1 = sc.nextInt();
            int v_2 = sc.nextInt();

            graph.addEdge(v_1, v_2);
        }
        sc.close();

        System.out.println(graph);
    }
}
