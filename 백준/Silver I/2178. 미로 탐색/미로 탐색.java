import java.io.*;
import java.util.*;

public class Main {

	static StringTokenizer st;
	static BufferedReader br;

	static int N, M;
	static boolean map[][];
	static Queue<int[]> q;

	static final int dx[] = { 1, -1, 0, 0 };
	static final int dy[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new boolean[N][M];

		for (int n = 0; n < N; n++) {
			String line = br.readLine();
			for (int m = 0; m < M; m++) {
				map[n][m] = (line.charAt(m) - '0' == 1) ? true : false;
			}
		}

		bfs(0, 0, 1);
		br.close();
	}

	private static void bfs(int n, int m, int cnt) {
		q = new ArrayDeque<int[]>();
		q.offer(new int[] { n, m, cnt });
		map[n][m] = false;
//		cnt = 1;

		while (!q.isEmpty()) {
			int ij[] = q.poll();
			int i = ij[0];
			int j = ij[1];
			cnt = ij[2];

			if(i==N-1&&j==M-1) {
				System.out.println(cnt); 
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int nx = i + dx[d];
				int ny = j + dy[d];

//				System.out.println(ny+" "+nx+" ");
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny]) {
					map[nx][ny] = false;
					q.offer(new int[] { nx, ny, cnt+1 });
				}
			}
		}
	}
}