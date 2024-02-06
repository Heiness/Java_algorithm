import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] dist = new int[N][N];
		
		for(int i=0;i<N;i++) { // 플로이드-워셜 초기화
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp!=0) {
					dist[i][j] = tmp;
					continue;
				}
				dist[i][j] = 100_000_000;
			}
		}

		for(int k=0;k<N;k++) for(int i=0;i<N;i++) for(int j=0;j<N;j++) dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]); // 거리 최소화
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(dist[i][j]!=100_000_000) sb.append(1).append(" ");
				else sb.append(0).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
}