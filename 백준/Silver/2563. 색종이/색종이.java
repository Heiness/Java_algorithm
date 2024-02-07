import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		int[][] arr = new int[100][100];
		int ans = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		for(int tc=0;tc<N;tc++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			for(int i=0;i<10;i++) {
				int ny = y + i; 
				for(int j=0;j<10;j++) {
					int nx = x + j;
					if(0<=ny&&ny<100&&0<=nx&&nx<100&&arr[ny][nx]==0) {
						arr[ny][nx]=1;
						ans++;
					}
				}
			}
		}
		System.out.println(ans);
	}

}