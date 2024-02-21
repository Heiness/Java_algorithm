import java.io.*;
import java.util.*;

public class Solution {
	static int N,M,ans;
	static boolean[] visited;
	static List<Integer>[] graph;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<T+1;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			graph = new ArrayList[N+1];
			visited = new boolean[N+1];
			ans=0;
			for(int i=1;i<N+1;i++) graph[i] = new ArrayList<>();
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a].add(b);
				graph[b].add(a);
			}
			
			for(int i=1;i<N+1;i++) {
				if(!visited[i]) {
					search(i);
					ans++;
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	static void search(int n) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(n);
		visited[n] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int node: graph[now]) {
				if(visited[node]) continue;
				visited[node] = true;
				q.offer(node);
			}
		}
		
		
	}

}