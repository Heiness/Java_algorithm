import java.io.*;
import java.util.*;

public class Main {
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int N,M,ans;
	static int[][] arr;
	static boolean[] visited = new boolean[26];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			for(int j=0;j<M;j++) arr[i][j] = input.charAt(j)-'A'; // A~Z를 0~26으로 관리
		}
		
		visited[arr[0][0]] = true;
		dfs(1,0,0);
		System.out.println(ans);
		
		
	}
	static void dfs(int length, int y, int x) {
		for(int i=0;i<4;i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(0<=ny&&ny<N&&0<=nx&&nx<M&&!visited[arr[ny][nx]]) {
				int alp = arr[ny][nx];
				visited[alp] = true;
				dfs(length+1, ny, nx);
				visited[alp] = false;
			}
		}
		
		if(ans<length) ans = length;
	}
}