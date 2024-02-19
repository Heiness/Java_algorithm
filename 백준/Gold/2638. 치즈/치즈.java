import java.io.*;
import java.util.*;

public class Main {
	static int N,M, ans,cnt;
	static int[][] arr;
	static int[] dy = {-1,1,0,0}, dx = {0,0,-1,1};
	static List<int[]> kill;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
//		System.out.println(cnt);
		while(cnt>0) {
			ans++;
			kill = new ArrayList<>();
			bfs(); // 탐색
			kill();
//			for(int[] ia: arr) System.out.println(Arrays.toString(ia));
//			System.out.println();
		}
		
		System.out.println(ans);
	}
	
	static void kill() {
		for(int[] ia: kill) {
//			System.out.println(Arrays.toString(ia));
			arr[ia[0]][ia[1]] = 0; // 죽이기
			cnt--;
		}
	}
	static void bfs() {
		int[][] cnt = new int[N][M];
		
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0,0});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int y = now[0];
			int x = now[1];
			
			for(int i=0;i<4;i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(0<=ny&&ny<N&&0<=nx&&nx<M&&cnt[ny][nx]!=-1) {
					if(arr[ny][nx]==0) {
						cnt[ny][nx]=-1;
						q.offer(new int[] {ny,nx});
					}
					else { // 치즈
						if(++cnt[ny][nx]>=2) {
							kill.add(new int[] {ny,nx});
							cnt[ny][nx]=-1;
						}
					}
				}
			}
		}
	}
}