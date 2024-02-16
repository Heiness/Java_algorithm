import java.io.*;
import java.util.*;

public class Solution {
	static int ans, N;
	static int[][] nodes;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<T+1;tc++) {
			N = Integer.parseInt(br.readLine());
			nodes = new int[N+2][2];
			visited = new boolean[N+2];
			ans = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			nodes[0][0] = Integer.parseInt(st.nextToken());
			nodes[0][1] = Integer.parseInt(st.nextToken());
			nodes[N+1][0] = Integer.parseInt(st.nextToken());
			nodes[N+1][1] = Integer.parseInt(st.nextToken());
			for(int i=1;i<N+1;i++) {
				nodes[i][0] = Integer.parseInt(st.nextToken());
				nodes[i][1] = Integer.parseInt(st.nextToken());
			}
			dfs(0,0,0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int d, int total, int now) {
		int tmp;
		if(d==N) {
			tmp = Math.abs(nodes[now][0] - nodes[N+1][0]) + Math.abs(nodes[now][1] - nodes[N+1][1]);
			total += tmp;
			ans = Math.min(ans, total); // 모든점 방문 시 결과 비교
			return;
		}
		
		for(int i=1;i<N+1;i++) {
			if(visited[i]) continue;
			tmp = Math.abs(nodes[now][0] - nodes[i][0]) + Math.abs(nodes[now][1] - nodes[i][1]); // 계산해서 넣음
			visited[i] = true;
			dfs(d+1, total+tmp, i);
			visited[i] = false;
		}
		
		
	}
}