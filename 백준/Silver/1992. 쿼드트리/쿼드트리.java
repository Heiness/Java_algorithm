import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static char[][] arr;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		
		for(int i=0;i<N;i++) arr[i] = br.readLine().toCharArray();
		
		char start = arr[0][0];
		boolean ck = false;
		label: for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(start!=arr[i][j]) {
					ck=true;
					break label;
				}
			}
		}
		if(!ck) {
			System.out.println(start);
			return;
		}
		dfs(0,0,N,N);
		System.out.println(sb);
	}
	
	static void dfs(int sy, int sx, int by, int bx) {
		// (sy,sx), ((by+sy)/2, (bx+sx)/2) (by,bx)
		char start;
		boolean ck;
		int midY = (by+sy)/2;
		int midX = (bx+sx)/2;
		
		
		sb.append("("); // 시작
		
		ck = false;
		start = arr[sy][sx];
		label: for(int i=sy;i<midY;i++) {
			for(int j=sx;j<midX;j++) {
				if(start!=arr[i][j]) {
					dfs(sy, sx, midY, midX); // 같지 않으면 돌입
					ck = true; 
					break label;
				}
			}
		}
		if(!ck) sb.append(start);
		
		ck = false;
		start = arr[sy][midX];
		label: for(int i=sy;i<midY;i++) {
			for(int j=midX;j<bx;j++) {
				if(start!=arr[i][j]) {
					dfs(sy, midX, midY, bx); // 같지 않으면 돌입
					ck = true;
					break label;
				}
			}
		}
		if(!ck) sb.append(start);
		
		ck = false;
		start = arr[midY][sx];
		label: for(int i=midY;i<by;i++) {
			for(int j=sx;j<midX;j++) {
				if(start!=arr[i][j]) {
					dfs(midY, sx, by, midX); // 같지 않으면 돌입
					ck = true;
					break label;
				}
			}
		}
		if(!ck) sb.append(start);
		
		ck = false;
		start = arr[midY][midX];
		label: for(int i=midY;i<by;i++) {
			for(int j=midX;j<bx;j++) {
				if(start!=arr[i][j]) {
					dfs(midY, midX, by, bx); // 같지 않으면 돌입
					ck = true;
					break label;
				}
			}
		}
		if(!ck) sb.append(start);
		
		sb.append(")"); // 끝
	}

}