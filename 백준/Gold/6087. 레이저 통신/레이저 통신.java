import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int w, h;
    static int startX, startY;
    static int answer = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new int[h][w];
        for (int i = 0; i < h; i++) {
            String str = br.readLine();
            for (int j = 0; j < w; j++) {
                char ch = str.charAt(j);
                if (ch == '.') {
                    arr[i][j] = -1;
                }
                if (ch == '*') {
                    arr[i][j] = -2;
                }
                if (ch == 'C') {
                    arr[i][j] = -3;
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs();
        System.out.println(answer);
    }

    // .: 빈 칸 -1
    // *: 벽 -2
    // C: 레이저로 연결해야 하는 칸 -3
    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY, 0});
        arr[startX][startY] = 0;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = tmp[0];
                int nc = tmp[1];
                int mirror = tmp[2];
                while (true) {
                    nr += dx[i];
                    nc += dy[i];
                    if (nr < 0 || nc < 0 || nr >= h || nc >= w) {
                        break;
                    }
                    if (arr[nr][nc] == -3) {
                        answer = Math.min(answer, mirror);
                        break;
                    } else if (arr[nr][nc] == -2) {
                        break;
                    } else if (arr[nr][nc] == -1) {
                        arr[nr][nc] = mirror;
                        q.offer(new int[]{nr, nc, mirror + 1});
                    } else if (arr[nr][nc] >= 0 && arr[nr][nc] != mirror) {
                        break;
                    }
                }

            }
        }
    }
}