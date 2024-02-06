import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Edge>[] adjacencyList;
    static int[] distance;
    static boolean[] visited;
    static PriorityQueue<Edge> queue = new PriorityQueue<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        adjacencyList = new ArrayList[n + 1];
        for (int i = 1; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjacencyList[start].add(new Edge(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);

        System.out.println(distance[end]);
    }

    private static void dijkstra(int start, int end) {
        distance[start] = 0;
        queue.add(new Edge(start, 0));

        while (!queue.isEmpty()) {
            Edge current = queue.poll();
            int currentV = current.vertex;

            if (visited[currentV] && currentV == end) {
                return;
            } else if (visited[currentV]) {
                continue;
            }

            visited[currentV] = true;

            for (Edge adjacency : adjacencyList[currentV]) {
                if (distance[adjacency.vertex] > distance[currentV] + adjacency.weight) {
                    distance[adjacency.vertex] = distance[currentV] + adjacency.weight;
                    queue.add(new Edge(adjacency.vertex, distance[adjacency.vertex]));
                }
            }
        }
    }
}

class Edge implements Comparable<Edge> {
        int vertex;
        int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge) {
            if (this.weight > edge.weight) {
                return 1;
            }
            return -1;
        }
    }