import java.util.*;
import java.io.*;

class Point {
	int y, x;
	char c;

	public Point(int y, int x, char c) {
		this.y = y;
		this.x = x;
		this.c = c;
	}
}

public class Main {
	static char[][] arr = new char[12][6];
	static String input;
	static int ans;
	static Queue<Point> q = new ArrayDeque<>();
	static boolean[][] visited = new boolean[12][6];
	static boolean[][] visitedCopy = new boolean[12][6];
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static boolean g;
	static int chk;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 12; i++) {
			input = br.readLine();
			for (int j = 0; j < input.length(); j++) {
				arr[i][j] = input.charAt(j);
			}
		}
		while (!g) {
			chk=0;
			search(); // 끝나면 4개 이상이였던 좌표 visited 체크 되어있음.
			boom(); // 터트리고 ans++
			down(); // 내리기
//			int c = 0;
//			for (int i = 0; i < 12; i++) {
//				for (int j = 0; j < 6; j++) {
//					if (visited[i][j] == true)
//						c++;
//				}
//			}
			if (chk == 0)
				g = true;
		}
		System.out.println(ans);

	}

	static void search() {
		visited = new boolean[12][6];
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if (arr[i][j] != '.' && visited[i][j] == false) { // 방문도 안했고 색깔이면 돌리기
					cp(visitedCopy, visited);
					if (bfs(new Point(i, j, arr[i][j])) < 4) { // 4이하면
						cp(visited, visitedCopy); // 원상복귀
					}
				}
			}
		}
	}

	static int bfs(Point p) {
		q.offer(p);
		int cnt = 1;
		visited[p.y][p.x] = true;

		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];

				if (0 <= nx && nx < 6 && 0 <= ny && ny < 12 && arr[ny][nx] == cur.c && visited[ny][nx] == false) { // 애초에
					visited[ny][nx] = true;
					Point np = new Point(ny, nx, arr[ny][nx]);
					q.offer(np);
					cnt++;
				}
			}
		}
		return cnt;
	}

	static void boom() {
		int cnt = 0;
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if (visited[i][j] == true) {
					arr[i][j] = '.';
					cnt++;
					chk++;
				}
			}
		}
		if(cnt!=0) ans++;
	}

	static void cp(boolean[][] a, boolean[][] b) {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				a[i][j] = b[i][j];
			}
		}
	}

	static void down() {
		for (int j = 0; j < 6; j++) {
			for (int i = 11; i > 0; i--) {
				if (arr[i][j] == '.') {
					// 위에 있는 지 체크
					for (int y = i - 1; y >= 0; y--) {
						if (arr[y][j] != '.') { // 있으면 교환
							arr[i][j] = arr[y][j];
							arr[y][j] = '.';
							break;
						}
					}
				}
			}
		}
	}

}