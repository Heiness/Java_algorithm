import java.io.*;
import java.util.*;

public class Main {
	static int N,D,C;
	static boolean[] visited;
	static int[] dist;
	static List<int[]>[] graph;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<T+1;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken()); 
			C = Integer.parseInt(st.nextToken());
			graph = new ArrayList[N+1];
			dist = new int[N+1];
			for(int i=1;i<N+1;i++) {
				graph[i] = new ArrayList<>();
				dist[i] = Integer.MAX_VALUE;
			}
			
			for(int i=0;i<D;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
//				graph[a].add(new int[] {b,c});
				graph[b].add(new int[] {a,c});
			}
			
			dist[C] = 0;
			dijk(C);
			int max = 0;
			int maxCnt = 0;
			for(int i=1;i<N+1;i++) {
				if(dist[i]!=Integer.MAX_VALUE) {
					if(max < dist[i]) max = dist[i];
					if(dist[i]!=Integer.MAX_VALUE) maxCnt++;
				}
			}
			sb.append(maxCnt).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
		
	}
	static void dijk(int S) {
		PriorityQueue<int []> pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o1[1], o2[1]));
		pq.offer(new int[] {S,0});
		visited = new boolean[N+1];
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			int nowV = now[0];
			int totalW = now[1];
			
			if(visited[nowV]) continue;
			visited[nowV] = true;
			
			for(int[] next: graph[nowV]) {
				int nextV = next[0];
				int nextW = next[1];
				int d = totalW + nextW;
				if(!visited[nextV] && dist[nextV] > d) {
					dist[nextV] = d;
					pq.offer(new int[] {nextV, d});
				}
			}
		}
	}

}