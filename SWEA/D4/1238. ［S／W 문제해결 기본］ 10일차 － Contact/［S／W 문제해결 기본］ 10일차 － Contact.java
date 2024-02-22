import java.io.*;
import java.util.*;

public class Solution {
	static int N, M;
	static int[] ans;
	static List<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int tc = 1; tc < 11; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			ans= new int[2];

			graph = new ArrayList[100 + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N/2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(graph[a]==null) graph[a]= new ArrayList<>();
				if(graph[b]==null) graph[b]= new ArrayList<>();
				
				graph[a].add(b);
			}
			
			bfs(M);
			sb.append("#").append(tc).append(" ").append(ans[1]).append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int start) {
		boolean[] visited = new boolean[101];
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {start,0});
		visited[start]=true;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int node = now[0];
			int cnt = now[1];
			
//			System.out.println("!!"+now[0]+"/"+ans[0]+" "+ans[1]);
//			for(int[] n: q) System.out.println(n[0] +" "+ n[1]);
//			System.out.println();
			if(ans[0]<cnt) {
				ans[0] = cnt;
				ans[1] = node;
			}
			else if(ans[0]==cnt && ans[1] < node) ans[1] = node;
			for(int next: graph[node]) {
				if(!visited[next]) {
					visited[next]=true;
					q.offer(new int[] {next, cnt+1});
				}
			}
		}
	}
}