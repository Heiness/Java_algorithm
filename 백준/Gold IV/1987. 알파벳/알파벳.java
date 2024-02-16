import java.io.*;
import java.util.*;

public class Main {
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int N,M,ans;
	static char[][] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		
		for(int i=0;i<N;i++) arr[i] = br.readLine().toCharArray();
		
		dfs(arr[0][0]+"",1,0,0);
		System.out.println(ans);
		
		
	}
	static void dfs(String visited, int length, int y, int x) {
		for(int i=0;i<4;i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(0<=ny&&ny<N&&0<=nx&&nx<M&&!visited.contains(arr[ny][nx]+"")) {
				dfs(visited+arr[ny][nx], length+1, ny, nx);
			}
		}
		
		if(ans<length) ans = length;
	}
}