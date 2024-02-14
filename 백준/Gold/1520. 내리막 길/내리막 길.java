import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr,dp;
	static int[] dy = { 0, 0, -1, 1 };
	static int[] dx = { -1, 1, 0, 0 };
	static boolean[][] v;
	static int ans, N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][M + 1];
		dp = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= M; j++)
				dp[i][j] = -1;
		v = new boolean[N][M];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		System.out.println(dfs(1, 1));
	}

	static int dfs(int y, int x) {
		if (y == N && x == M)
			return 1; // 도착 1반환
		if (dp[y][x] != -1)
			return dp[y][x]; // 경로 계산 완료일 경우 해당값 반환

		// 끝도 아니고 방문해본적이 없는 칸이므로 계산
		dp[y][x]=0;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (0< ny && ny <= N && 0 < nx && nx <= M && arr[y][x] > arr[ny][nx]) {
				dp[y][x] += dfs(ny, nx);
			}
		}
		return dp[y][x];
	}
}