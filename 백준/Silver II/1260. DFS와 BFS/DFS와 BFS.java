import java.io.*;
import java.util.*;

public class Main {
	static int N,M,V;
	static List<Integer>[] edges;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		edges = new ArrayList[N+1]; // 0 안씀
		
		for(int i=1;i<N+1;i++) edges[i] = new ArrayList<>();
		for(int i=1;i<M+1;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			edges[s].add(e);
			edges[e].add(s);
		}
		
		for(int i=1;i<N+1;i++) Collections.sort(edges[i]);
		
		visited = new boolean[N+1];
		visited[V] = true;
		sb.append(V).append(" ");
		dfs(0,V);
		sb.append("\n");
		bfs();
		System.out.println(sb);
	}
	
	static void dfs(int d, int now) {
		
		for(int next: edges[now]) {
			if(visited[next]) continue;
			visited[next] = true;
			sb.append(next).append(" ");
			dfs(d+1,next);
		}
		
		
	}
	
	static void bfs() {
		sb.append(V).append(" ");
		
		Queue<Integer> q = new ArrayDeque<>();
		visited = new boolean[N+1];
		q.offer(V);
		visited[V] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int next: edges[now]) {
				if(visited[next]) continue;
				visited[next] = true;
				q.offer(next);
				sb.append(next).append(" ");
			}
		}
		sb.append("\n");
	}
}