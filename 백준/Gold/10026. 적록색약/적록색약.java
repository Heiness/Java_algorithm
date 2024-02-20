import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int[] ans = new int[2];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		visited = new boolean[N][N];
		
		for(int i=0;i<N;i++) arr[i] = br.readLine().toCharArray();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					bfs1(i, j, arr[i][j]);
					ans[0]++;
				}
			}
		}
		
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					ans[1]++;
					bfs2(i, j, arr[i][j]);
				}
			}
		}
		
		sb.append(ans[0]).append(" ").append(ans[1]);
		System.out.println(sb);
	}
	
	static void bfs1(int y,int x, char color) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {y,x});
		visited[y][x]=true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			y = now[0];
			x = now[1];
			
			for(int i=0;i<4;i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(0<=ny&&ny<N&&0<=nx&&nx<N&&!visited[ny][nx]&&arr[ny][nx]==color) {
					q.offer(new int[] {ny,nx});
					visited[ny][nx] = true;
				}
			}
		}
	}
	
	static void bfs2(int y,int x, char color) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {y,x});
		visited[y][x]=true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			y = now[0];
			x = now[1];
			
			for(int i=0;i<4;i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(0<=ny&&ny<N&&0<=nx&&nx<N&&!visited[ny][nx]) {
					if(color=='B'&&arr[ny][nx]=='B') {
							q.offer(new int[] {ny,nx});
							visited[ny][nx] = true;
					}
					else if(color!='B'&&(arr[ny][nx]=='R'||arr[ny][nx]=='G')){
						q.offer(new int[] {ny,nx});
						visited[ny][nx] = true;
					}
				}
			}
		}
	}

}