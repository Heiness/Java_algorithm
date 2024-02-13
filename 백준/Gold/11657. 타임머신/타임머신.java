import java.io.*;
import java.util.*;

public class Main {

	static class Edge{
		int start, end, cost;
		
		public Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Edge> edges = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge(start, end, cost));
		}
		
		long[] dist = new long[N+1];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[1] = 0;
		
		for(int i=1;i<=N;i++) {
			for(Edge e: edges) {
				if(dist[e.start]==Long.MAX_VALUE) continue;
				
				if(dist[e.end] > dist[e.start] + e.cost) {
					dist[e.end] = dist[e.start] + e.cost;
					
					if(i==N) {
						System.out.println(-1);
						System.exit(0);
					}
				}
			}
		}
		
		for(int i=2;i<N+1;i++) System.out.println(dist[i]!=Long.MAX_VALUE?dist[i]:-1);
	}

}