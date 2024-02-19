import java.io.*;
import java.util.*;

public class Main {
	static int[] dy = {0,0,-1,1};
	static int[] dx = {-1,1,0,0};
	static int N,M;
	static int[][] arr;
	static List<int[]> kill;
	static int cnt,day;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) cnt++;
			}
		}
		
		while(cnt!=0) {
			day++;
			kill = new ArrayList<>();
			bfs(); // 돌리고
			kill(); // 죽이기
//			for(int[] v: arr) System.out.println(Arrays.toString(v));
		}
		System.out.println(sb);
		
		
	}
	
	static void kill() {
//		System.out.println(cnt);
		if(kill.size()==cnt) {
			sb.append(day).append("\n").append(cnt);
		}
		for(int[] ia : kill) arr[ia[0]][ia[1]] = 0; 
		cnt-=kill.size();
	}
	
	static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		q.offer(new int[] {0,0});
		visited[0][0]=true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int y = now[0];
			int x = now[1];
			
			for(int i=0;i<4;i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(0<=ny&&ny<N&&0<=nx&&nx<M&&!visited[ny][nx]) {
					if(arr[ny][nx]==1) {
						visited[ny][nx] = true;
						kill.add(new int[] {ny,nx});
						continue;
					}
					q.offer(new int[] {ny,nx});
					visited[ny][nx] = true;
					
				}
			}
		}
//		for(boolean[] v: visited) System.out.println(Arrays.toString(v));
	}

}