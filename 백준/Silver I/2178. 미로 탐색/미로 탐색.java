import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		
		int[] dy = {0,0,-1,1};
		int[] dx = {-1,1,0,0};
		
		for(int i=0;i<N;i++) { // 입력
			String input = br.readLine();
			for(int j=0;j<M;j++) arr[i][j] = input.charAt(j) - '0';
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0,0});
		arr[0][0] = 0;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int y = now[0];
			int x = now[1];
			
			for(int i=0;i<4;i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(0<=ny&&ny<N&&0<=nx&&nx<M&&arr[ny][nx]==1) {
					q.offer(new int[] {ny,nx});
					arr[ny][nx]=arr[y][x]+1;
				}
			}
		}
		
		System.out.println(arr[N-1][M-1]+1);
		
	}

}