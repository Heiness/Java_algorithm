import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[] dist;
	static List<int[]>[] graph;
	static boolean[] visited;
	static PriorityQueue<int []> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1], o2[1]));
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		dist = new int[N+1];
		graph = new ArrayList[N+1];
		for(int i=1;i<N+1;i++) {
			graph[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new int[] {b,c});
			graph[b].add(new int[] {a,c});
		}
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		pq.offer(new int[] {S,0});
		dist[S] = 0;
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			int nowV = now[0];
			int nowW = now[1];
			if(nowV == E) {
				System.out.println(nowW);
				return;
			}
			if(visited[nowV]) continue;
			visited[nowV] = true;
			for(int[] next: graph[nowV]) {
				int nextV = next[0];
				int nextW = next[1];
				int d = nowW + nextW;
				if(!visited[nextV] && dist[nextV] > d) {
					dist[nextV] = d;
					pq.offer(new int[] {nextV, d});
				}
			}
		}
	}
}