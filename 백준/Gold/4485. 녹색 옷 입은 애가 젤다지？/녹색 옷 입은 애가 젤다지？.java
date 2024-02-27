import java.io.*;
import java.util.*;

public class Main {
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = 1;
		while(true){
			int N = Integer.parseInt(br.readLine());
			if(N==0) break;
			boolean[][] visited = new boolean[N][N];
			int[][] arr = new int[N][N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			PriorityQueue<int []> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[2], o2[2]));
			pq.offer(new int[] {0,0,arr[0][0]});
//			visited[0][0] = true;
			
			while(!pq.isEmpty()) {
				int[] now = pq.poll();
				int y = now[0];
				int x = now[1];
				int cost = now[2];
				if(y==N-1&&x==N-1) {
					sb.append("Problem").append(" ").append(tc).append(":").append(" ").append(cost).append("\n");
					break;
				};
				if(visited[y][x]) continue;
				visited[y][x] = true;
//				System.out.println(tc);
				for(int i=0;i<4;i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					if(0<=ny&&ny<N&&0<=nx&&nx<N&&!visited[ny][nx]) {
						pq.offer(new int[] {ny,nx,cost + arr[ny][nx]});
					}
				}
				
			}
			tc++;
		}
		System.out.println(sb);
	}

}