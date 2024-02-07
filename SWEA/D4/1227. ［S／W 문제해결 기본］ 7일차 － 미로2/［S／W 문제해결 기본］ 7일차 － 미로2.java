import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		char[][] graph = new char[100][100];
		Queue<int[]> q;

		int[] dy = { 1, -1, 0, 0 };
		int[] dx = { 0, 0, 1, -1 };
		int[] F;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <11; tc++) {
			q = new ArrayDeque<>();
			F = new int[2];
			br.readLine();
			for (int i = 0; i < 100; i++) {
				String input = br.readLine();
				if (input.contains("3")) {
					F[0] = i;
					F[1] = input.indexOf("3");
				}
				graph[i] = input.toCharArray(); // 값 넣기
			}
			graph[1][1] = 1;
			q.offer(new int[] { 1, 1 });
			while (!q.isEmpty()) {
				int[] now = q.poll();
				int y = now[0];
				int x = now[1];

				for (int i = 0; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					if (0 <= ny && ny < 100 && 0 <= nx && nx < 100 && graph[ny][nx] != '1') {
						q.offer(new int[] { ny, nx });
						graph[ny][nx] = '1';
					}
				}
			}
			int ans = graph[F[0]][F[1]] == '3' ? 0 : 1;
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}