import java.io.*;
import java.util.*;

public class Main {
	static int K,N,M,ans=Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[][][] visited;
	static int[] dy= {-1,1,0,0}, dx= {0,0,-1,1};
	static int[] dy2= {-2,-2,-1,-1,1,1,2,2}, dx2= {-1,1,-2,2,-2,2,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[K+1][N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		PriorityQueue<int []> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[2], o2[2]));
		Queue<int[]> q = new ArrayDeque<>();
		visited[0][0][0] = true;
		q.offer(new int[] {0,0,0,0});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int y = now[0];
			int x = now[1];
			int c = now[2];
			int j = now[3];
//			System.out.println(1);
//			System.out.println(y+" "+x+" "+c+" "+j);
			if(y==N-1&&x==M-1) {
				ans = Math.min(ans, c);
//				System.out.println(c+" "+j);
				continue;
			}
			
			if(j<K) { // 말 이동
				for(int i=0;i<8;i++) {
					int ny = y+dy2[i];
					int nx = x+dx2[i];
					if(0<=ny&&ny<N&&0<=nx&&nx<M&&!visited[j+1][ny][nx]&&arr[ny][nx]==0) {
						visited[j+1][ny][nx]=true;
						q.offer(new int[] {ny,nx,c+1,j+1});
					}
				}
			}
			
			for(int i=0;i<4;i++) { // 원숭이 이동
				int ny = y+dy[i];
				int nx = x+dx[i];
				
				if(0<=ny&&ny<N&&0<=nx&&nx<M&&!visited[j][ny][nx]&&arr[ny][nx]==0) {
					visited[j][ny][nx] = true;
					q.offer(new int[] {ny,nx,c+1,j});
				}
			}
		}
		
		System.out.println(ans==Integer.MAX_VALUE?-1:ans);
	}

}