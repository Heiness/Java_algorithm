import java.io.*;
import java.util.*;

public class Solution {
	static int[] dy = {-1,1,0,0}, dx = {0,0,-1,1};
	static int[][] arr;
	static Set<String> nums;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<T+1;tc++) {
			arr = new int[4][4];
			nums = new HashSet<>();
			
			for(int i=0;i<4;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<4;j++) arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					dfs(1,i,j,""+arr[i][j]);
				}
			}
			sb.append("#").append(tc).append(" ").append(nums.size()).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int d, int y, int x, String s) {
		if(d==7) {
			nums.add(s);
			return;
		}
		
		for(int i=0;i<4;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			if(0<=ny&&ny<4&&0<=nx&&nx<4) {
				dfs(d+1, ny, nx, s+arr[ny][nx]);
			}
		}
	}
}