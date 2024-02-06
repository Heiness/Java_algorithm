import java.io.*;
import java.util.*;

public class Main {
	static int M, N, ans;
	static int[][] arr;
	static Queue<int[]> tl = new ArrayDeque<>();
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int i = 0; i < N; i++) { // 값 입력
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		check_tomato();
		effect();
		for(int i=0;i<N;i++) for(int j=0;j<M;j++) {
			ans = Math.max(ans,arr[i][j]);
			if(arr[i][j]==0) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(ans-1);
		
	}

	static void check_tomato() {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (arr[i][j] == 1) {
					tl.offer(new int[] { i, j });
				}
	}

	static void effect() {
		int[] tmt;
		while (!tl.isEmpty()) {
			tmt = tl.poll();
			int y = tmt[0];
			int x = tmt[1];
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (0 <= ny && ny < N && 0 <= nx && nx < M && arr[ny][nx] == 0) {
					arr[ny][nx] = arr[y][x]+1;
					tl.offer(new int[] {ny,nx});
				}
			}
		}
	}
}