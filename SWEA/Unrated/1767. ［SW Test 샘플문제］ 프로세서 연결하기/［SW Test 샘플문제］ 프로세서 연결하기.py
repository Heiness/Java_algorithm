import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
	// static boolean visited[][];
	static int g[][];
	static int n;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static ArrayList<Core> ar;
	static int maxCore = Integer.MIN_VALUE;
	static int minLine = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine().trim());
        
		for (int i = 0; i < testCase; i++) {
			n = Integer.parseInt(br.readLine().trim());
			g = new int[n][n];
            ar = new ArrayList<Core>();
			String[] str;
			for (int j = 0; j < n; j++) {
				str = br.readLine().split(" ");
				for (int k = 0; k < n; k++) {
					g[j][k] = Integer.parseInt(str[k]);
					if (g[j][k] == 1) {
						ar.add(new Core(j, k));
					}
				}
			}
            
			dfs(0, 0, 0);
			System.out.println("#" + (i + 1) + " " + minLine);
            //전역변수를 사용하므로 테스트 케이스마다 초기화해주기!
			ar.clear();
			maxCore = Integer.MIN_VALUE;
			minLine = Integer.MAX_VALUE;
	

		}

	}

//인자로 코어리스트의 index와 선택된 코어의 개수, 연결선의 길이를 넘겨준다
	public static void dfs(int idx, int coreCnt, int lineLen) {

		if (idx == ar.size()) {
			if (coreCnt > maxCore) {
				maxCore = coreCnt;
				minLine = lineLen;

			} else if (coreCnt == maxCore) {
				if (minLine > lineLen) {
					minLine = lineLen;
				}
			}
			
			return;
		}
		Core c = ar.get(idx);

//남북동서 방향으로 탐색
		for (int i = 0; i < 4; i++) {
        
//벽에 붙어있는 코어이면 탐색하지 않고 코어의 개수를 늘림
			if (c.x == 0 || c.x == n - 1 || c.y == 0 || c.y == n - 1) {
				dfs(idx + 1, coreCnt + 1, lineLen);
				break;

			}
            //그방향으로 연결이 가능한지 체크
			int check = checkLine(i, c);
			int sx = c.x;
			int sy = c.y;
            //연결이 가능하다면 길이와 코어개수와 라인길이를 갱신해서 계속 탐색
			if (check != -1) {
				dfs(idx + 1, coreCnt + 1, lineLen + check);
             	//후에 다시 사용되므로 라인으로 체크되는 배열을 초기화
				for (int j = 0; j < check; j++) {
					sx += dx[i];
					sy += dy[i];
					g[sx][sy] = 0;

				}
			}

		}
        //코어를 선택하지않고 넘어가는 경우도 탐색
		dfs(idx + 1, coreCnt, lineLen);
	}

//연결이 가능한지 체크해주는함수
	public static int checkLine(int i, Core c) {
		int line = 0;
		int sx = c.x + dx[i];
		int sy = c.y + dy[i];
		boolean check = false;
		while (true) {
			line++;
				if ((sx == 0 || sx == n - 1 || sy == 0 || sy == n - 1) && g[sx][sy] == 0) {
					check = true;
					break;
				}
				if (g[sx][sy] != 0) {
					check = false;
					break;
				}
			sx += dx[i];
			sy += dy[i];

		}
		sx = c.x;
		sy = c.y;
        //연결이 가능하다면 라인을 2로 표시해주면서 그어줌
		if (check) {
			for (int idx = 0; idx < line; idx++) {
				sx += dx[i];
				sy += dy[i];
				g[sx][sy] = 2;

			}
			return line;
		}
		return -1;
	}

}

class Core {
	int x;
	int y;

	Core(int x, int y) {
		this.x = x;
		this.y = y;
	}

}