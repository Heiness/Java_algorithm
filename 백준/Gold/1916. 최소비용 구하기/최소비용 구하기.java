import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int v, cost;

		public Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
	}

	static boolean[] visited;
	static int[] dist;
	static List<Node>[] adj;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		dist = new int[N];
		visited = new boolean[N];
		adj = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < M; i++) { // 인접 노드 넣기
			st = new StringTokenizer(br.readLine());
			adj[Integer.parseInt(st.nextToken()) - 1]
					.add(new Node(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())));
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		dijkstra(start - 1, end - 1);
		System.out.println(dist[end - 1]);
	}

	static void dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.cost - o2.cost;
			}
		});
		pq.add(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node now = pq.poll(); // class 필드 호출은 상당히 느림
			int nowV = now.v;
			int nowC = now.cost;
			if (visited[nowV] && nowV == end)
				return;
			else if (visited[nowV])
				continue;
			visited[nowV] = true;

			for (Node next : adj[nowV]) {
				if (!visited[next.v] && dist[next.v] > nowC + next.cost) {
					dist[next.v] = nowC + next.cost;
					pq.add(new Node(next.v, dist[next.v]));
				}
			}
		}
	}
}