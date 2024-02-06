import java.io.*;
import java.util.*;

import javax.xml.parsers.FactoryConfigurationError;

public class Solution {
	static int N, ans;
	static char[][] graph;
	static Queue<int[]> q = new ArrayDeque<>();
	static int[] dy = { 0, 0, -1, 1, -1, -1, 1, 1 };
	static int[] dx = { -1, 1, 0, 0, -1, 1, -1, 1 };

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {
			ans = 0;
			N = Integer.parseInt(br.readLine());
			graph = new char[N][N];

			for (int i = 0; i < N; i++) { // map 입력
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					graph[i][j] = input.charAt(j);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (graph[i][j] == '.' && search(i, j) == 0) {
						q.offer(new int[] { i, j });
						click();
						ans++;
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (graph[i][j] == '.') {
						q.offer(new int[] { i, j });
						click();
						ans++;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static void click() {
		graph[q.peek()[0]][q.peek()[1]] = '!';

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int y = now[0];
			int x = now[1];

			if(search(y,x)!=0) break;
			for (int i = 0; i < 8; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				

				if (0 <= ny && ny < N && 0 <= nx && nx < N && graph[ny][nx] == '.') {
					if (search(ny, nx) == 0) q.offer(new int[] { ny, nx });
						graph[ny][nx] = '!';
				}
			}
		}
	}

	static int search(int y, int x) {
		int cnt = 0;
		int ny = 0, nx = 0;
		for (int i = 0; i < 8; i++) {
			ny = y + dy[i];
			nx = x + dx[i];
			if (0 <= ny && ny < N && 0 <= nx && nx < N && graph[ny][nx] == '*')
				cnt++;
		}
		return cnt;
	}
}