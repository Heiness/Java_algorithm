import java.io.*;
import java.util.*;

public class Main {
	static int N, M, ans = Integer.MAX_VALUE;
	static char[][] arr;
	static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };
	static boolean[][][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visited = new boolean[2][N][M];

		for (int i = 0; i < N; i++)
			arr[i] = br.readLine().toCharArray();

		PriorityQueue<int[]> pq = new PriorityQueue<>(
				(o1, o2) -> o1[3] == o2[3] ? Integer.compare(o1[2], o2[2]) : Integer.compare(o1[3], o2[3]));
		pq.offer(new int[] { 0, 0, 1, 0 });
		visited[0][0][0] = true;

//		if(N==1&M==1) {
//			System.out.println(1);
//			return;
//		}
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int y = now[0];
			int x = now[1];
			int c = now[2];
			int w = now[3];

//			System.out.println(y + " " + x + " " + c + " " + w);
			if (y == N - 1 && x == M - 1) {
				ans = Math.min(ans, c);
			}

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (0 <= ny && ny < N && 0 <= nx && nx < M) {
					if (arr[ny][nx] == '1') { // 벽이면
						if (!visited[1][ny][nx]&&w==0) { // 부수지 않아야 이동 가능
							visited[1][ny][nx] = true;
							pq.offer(new int[] { ny, nx, c + 1, 1 });
						}
					} else {
						if (!visited[w][ny][nx]) {
							visited[w][ny][nx] = true;
							pq.offer(new int[] { ny, nx, c + 1, w });
						}
					}
				}
			}
		}
		if (ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);

	}

}