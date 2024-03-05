import java.io.*;
import java.util.*;

public class Main {
	static class Edge implements Comparable<Edge>{
		int node;
		long w;
		char s;
		public Edge(int node, long w) {
			this.node = node;
			this.w = w;
		}
		public Edge(int node, long w, char s) {
			this.node = node;
			this.w = w;
			this.s = s;
		}
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.w, o.w);
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N,M;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		long[] distM = new long[N+1];
		long[] distS = new long[N+1];
		List<Edge>[] graph = new ArrayList[N+1];
		for(int i=1;i<N+1;i++) {
			graph[i] = new ArrayList<>();
			distM[i] = Long.MAX_VALUE;
			distS[i] = Long.MAX_VALUE;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new Edge(b,c));
			graph[b].add(new Edge(a,c));
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int maxM = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			distM[tmp] = 0;
			pq.offer(new Edge(tmp,0,'M'));
		}
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int maxS = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			distS[tmp] = 0;
			pq.offer(new Edge(tmp,0,'S'));
		}
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			int nowV = now.node;
			long nowW = now.w;
			char s = now.s;
			
			if(s=='M'&&distM[nowV]<nowW) continue;
			if(s=='S'&&distS[nowV]<nowW) continue;
			
			for(Edge next: graph[nowV]) {
				int nextV = next.node;
				long nextW = next.w;
				long d = nextW+nowW;
				if(s=='M'&&distM[nextV]>d&&d<=maxM) {
					distM[nextV] = d;
					pq.offer(new Edge(nextV,d,s));
				}
				else if(s=='S'&&distS[nextV]>d&&d<=maxS) {
					distS[nextV] = d;
					pq.offer(new Edge(nextV,d,s));
				}
			}
		}
		
//		System.out.println(Arrays.toString(distM));
//		System.out.println(Arrays.toString(distS));
		Long ans = Long.MAX_VALUE;
		for(int i=1;i<N+1;i++) {
			if(distS[i]!=0&&distS[i]!=Long.MAX_VALUE&&distM[i]!=0&&distM[i]!=Long.MAX_VALUE) {
				Long tmp = distS[i] + distM[i];
				if(tmp<ans) ans = tmp; 
			}
		}
		System.out.println(ans==Long.MAX_VALUE ? -1 : ans);
	}

}