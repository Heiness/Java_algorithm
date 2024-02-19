import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	static int sz = 2;
	static int eatenFish;
	static final int dx[] = { -1, 0, 0, 1 };
	static final int dy[] = { 0, -1, 1, 0 };
	static int r, c;
	static int ans;
	static boolean success = true;
	static boolean v[][];
	static void huntingFish() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { r, c, 0 });
		int aX = Integer.MAX_VALUE;
		int aY = aX;
		int depth = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int[] top = q.poll();
			int x = top[0];
			int y = top[1];
			int cnt = top[2];
			if(cnt > depth)
				break;
			if (map[x][y] < sz && map[x][y] > 0) {
				if(aX > x) {
					aX = x;
					aY = y;
				}else if(aX == x && aY > y) {
					aX = x;
					aY = y;
				}
				depth = cnt;
				success = true;
				continue;
			}
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				if (map[nx][ny] > sz || v[nx][ny])
					continue;
				v[nx][ny] = true;
				q.offer(new int[] { nx, ny, cnt + 1 });
			}
		}
		if(success) {
			map[r][c] = 0;
			map[aX][aY] = 0;
			r = aX;
			c = aY;
			M--;
			eatenFish++;
			ans += depth;
		}
		if(sz == eatenFish) {
			sz++;
			eatenFish = 0;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					map[i][j] = 0;
					r = i;
					c = j;
					continue;
				}
				if (map[i][j] > 0) {
					M++;
				}
			}
		}
		while (M > 0 && success) {
			success = false;
			v = new boolean[N][N];
			huntingFish();
		}
		System.out.println(ans);
	}
}