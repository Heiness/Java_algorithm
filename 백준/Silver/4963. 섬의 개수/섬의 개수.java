import java.io.*;
import java.util.*;

public class Main {
	static int[] dy = {-1,1,0,0,-1,-1,1,1};
	static int[] dx = {0,0,-1,1,-1,1,-1,1};
	static int cnt,N,M;
	static int[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			cnt = 0;
			
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			if(N==0&&M==0) break;
			arr = new int[N][M];
			visited = new boolean[N][M];
			
			for(int i=0;i<N;i++) { // 배열에 값 넣기
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) arr[i][j] = Integer.parseInt(st.nextToken()); 
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(arr[i][j]==1&&!visited[i][j]) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int y,int x) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {y,x});
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			y = now[0];
			x = now[1];
			
			for(int i=0;i<8;i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(0<=ny&&ny<N&&0<=nx&&nx<M&&!visited[ny][nx]&&arr[ny][nx]==1) {
					visited[ny][nx] = true;
					q.offer(new int[] {ny,nx});
				}
			}
		}
		
	}

}