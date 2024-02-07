import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int[][] graph; 
		int[][] cnt;
		int[] ans;
		
		int[] dy = {-1,1,0,0};
		int[] dx = {0,0,-1,1};
		for(int tc=1;tc<T+1;tc++) {
			int N = Integer.parseInt(br.readLine());
			ans = new int[2];
			graph = new int[N][N];
//			cnt = new int[N][N];
			Queue<int[]> q = new ArrayDeque<>();
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) graph[i][j] = Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					q.offer(new int[] {i,j});
					int tmp=1;
					while(!q.isEmpty()) {
						int[] now = q.poll();
						int y = now[0];
						int x = now[1];
						for(int d=0;d<4;d++) {
							int ny = y+dy[d];
							int nx = x+dx[d];
							if(0<=ny&&ny<N&&0<=nx&&nx<N&&graph[ny][nx]==graph[y][x]+1) {
								tmp++;
								q.offer(new int[] {ny,nx});
								
							}
						}
					}
					if(ans[1] < tmp) {
						ans[0] = graph[i][j];
						ans[1] = tmp;
					}
					else if(ans[1]==tmp && ans[0]>graph[i][j]) ans[0] = graph[i][j];
				}
			}
			sb.append("#").append(tc).append(" ").append(ans[0]).append(" ").append(ans[1]).append("\n");
		}
		System.out.println(sb);
	}
}