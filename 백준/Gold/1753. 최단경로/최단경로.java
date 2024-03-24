import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static List<int[]>[] graph;
	static PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1], o2[1]));
	static int[] dist;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		dist = new int[N+1];
		for(int i=1;i<N+1;i++) {
			graph[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		int S = Integer.parseInt(br.readLine());
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] {b,c});
		}
		
		dijk(S);
		for(int i=1;i<N+1;i++) sb.append(dist[i]==Integer.MAX_VALUE?"INF":dist[i]).append("\n");
		System.out.println(sb);
	}
	
	static void dijk(int S) {
		dist[S] = 0;
		pq.offer(new int[] {S,0});
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			int nowV = now[0];
			int nowW = now[1];
            if(dist[nowV]<nowW) continue;
			for(int[] next:graph[nowV]) {
				int nextV = next[0];
				int nextW = next[1];
				int d = nowW+nextW;
				if(dist[nextV]>d) {
					pq.offer(new int[] {nextV, d});
					dist[nextV] = d;
				}
			}
		}
	}
}