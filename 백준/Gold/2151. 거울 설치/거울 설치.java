import java.io.*;
import java.util.*;

public class Main {
	static int N, dY, dX;
	static int[][] arr;
	static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				char t = input.charAt(j);
				if (t == '*')
					arr[i][j] = -1; // 벽
				else if (t == '!')
					arr[i][j] = -2; // 거울
				else if (t == '#'){
					arr[i][j] = -3; // 문
					dY = i;
					dX = j;
				}
				else  arr[i][j] = -4; // nothing
			}
		}
		
		Queue<int[]> q = new ArrayDeque<>();
//		PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->Integer.compare(o1[2], o2[2]));
		q.offer(new int[] { dY, dX, 0 }); // y축이동
//		q.offer(new int[] { dY, dX, 1 ,0}); // x축이동
		arr[dY][dX] = 0;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int y = now[0];
			int x = now[1];
			int d = now[2];
//			int c = now[3];
//			System.out.println(d);
//			for(int[] t: arr) System.out.println(Arrays.toString(t));
//			System.out.println();
			
			for(int i=0;i<4;i++) {
//				if(d==0 && (i==2||i==3)) continue;
//				if(d==1 && (i==0||i==1)) continue;
				
				int ny = y;
				int nx = x;
				
				while(true) {
					ny += dy[i];
					nx += dx[i];
					
					if(ny<0 || ny>=N || nx<0 || nx>=N) break; // 불가
					if(arr[ny][nx]==-1) break; // 벽
					else if(arr[ny][nx]==-2) { // 거울
						q.offer(new int[] {ny,nx,d+1});
						arr[ny][nx] = 0;
//						break;
					}
					else if(arr[ny][nx]==-3){ // 문
						System.out.println(d);
						return;
					}
					else arr[ny][nx]=0;
				}
			}

		}
	}

}