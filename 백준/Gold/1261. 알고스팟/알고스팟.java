import java.io.*;
import java.util.*;

public class Main {
	static int[] dy = {-1,1,0,0}, dx = {0,0,-1,1};
	static int N,M,ans;
	static int[][] arr;
//	static Queue<int[]> q = new ArrayDeque<>();
	static boolean[][] visited;
	static PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[2], o2[2]));
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M];
		arr = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			for(int j=0;j<M;j++) arr[i][j] = input.charAt(j) -'0';
		}
		pq.offer(new int[] {0,0,0});
		visited[0][0] = true;
		
		while(!pq.isEmpty()) {
			int now[] = pq.poll();
			int y = now[0];
			int x = now[1];
			int cost = now[2];
			
			if(y==N-1&&x==M-1) {
				System.out.println(cost);
				return;
			}
			for(int i=0;i<4;i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(0<=ny&&ny<N&&0<=nx&&nx<M&&!visited[ny][nx]) {
					visited[ny][nx] = true;
					if(arr[ny][nx]==1) pq.offer(new int[] {ny,nx,cost+1});
					else pq.offer(new int[] {ny,nx,cost});
				}
			}
		}
	}

}