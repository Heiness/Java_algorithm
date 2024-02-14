import java.io.*;
import java.util.*;


public class Main {
	static int[][] arr = new int[9][9];
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	static int cnt;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==0) cnt++;
			}
		}
		sudoku(0,0);

	}
	
	static void sudoku(int y, int x) {
		if(x==9) { // 열 가득 차면 행 이동
			sudoku(y+1, 0);
			return;
		}
		
		if(y==9) { // 행 가득 차면 출력 후 종료
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		
		if(arr[y][x]==0) {
			for(int n=0;n<10;n++) {
				if(check(y,x,n)) {
					arr[y][x] = n;
					sudoku(y, x+1);
				}
			}
			arr[y][x] = 0;
			return;
		}
		sudoku(y,x+1);
	}
	
	static boolean check(int y, int x, int n) { 
		for(int i=0;i<9;i++) if(arr[i][x]==n) return false; // 행 검사
		for(int i=0;i<9;i++) if(arr[y][i]==n) return false; // 열 검사
		
		int r = y/3 * 3;
		int c = x/3 * 3;
		
		for(int i=r;i<r+3;i++) {
			for(int j=c;j<c+3;j++) {
				if(arr[i][j]==n) return false; // 판 검사
			}
		}
		
		return true; // 미 존재시 true
	}
}