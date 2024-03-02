import java.util.*;
import java.io.*;

public class Main {
	static int V,E,P;
	static int[] dist;
	static boolean[] visited;
	static List<int[]>[] graph;
	static PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1], o2[1]));
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		graph = new ArrayList[V+1];
		for(int i=1;i<V+1;i++) graph[i] = new ArrayList<>();
		dist = new int[V+1];
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] {b,c});
			graph[b].add(new int[] {a,c});
		}
		dijk(1);
		int tmp1 = dist[V];
		dijk(P);
		int tmp2 = dist[1] + dist[V];
		System.out.println(tmp1==tmp2 ? "SAVE HIM" : "GOOD BYE");
	}
	static void dijk(int S) {
		pq.offer(new int[] {S,0});
		for(int i=1;i<V+1;i++) dist[i] = Integer.MAX_VALUE;
		visited = new boolean[V+1];
		dist[S] = 0;
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			int nowV = now[0];
			int nowW = now[1];
			
			if(visited[nowV]) continue;
			visited[nowV] = true;
			for(int[] next: graph[nowV]) {
				int nextV = next[0];
				int nextW = next[1];
				int d = nextW + nowW;
				if(!visited[nextV]&&dist[nextV]>d) {
					dist[nextV] = d;
					pq.offer(new int[] {nextV, d});
				}
			}
		}
	}

}