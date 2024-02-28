import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] dist = new int[N][N];
		int[][] ans = new int[N][N];
		
		for(int i=0;i<N;i++) for(int j=0;j<N;j++) ans[i][j] = j+1;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i!=j) dist[i][j] = 2000000; 
			}
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
//			dist[a-1][b-1] = c;
//			dist[b-1][a-1] = c;
			dist[a-1][b-1] = dist[b-1][a-1] = Math.min(dist[a-1][b-1], c);
		}
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(dist[i][j] > dist[i][k]+dist[k][j]) {
						dist[i][j] = dist[i][k]+dist[k][j];
						ans[i][j] = ans[i][k];
					}
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i==j) {
					sb.append("-").append(" ");
					continue;
				}
				sb.append(ans[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}