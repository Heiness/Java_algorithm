import java.io.*;
import java.util.*;

public class Main {

	static final int INF = 1000 * 10000;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] dist = new int[N+1][N+1];
	
			for(int i=1;i<N+1;i++) {
				for(int j=1;j<N+1;j++) {
					if(i==j) dist[i][i] = 0;
					else dist[i][j] = INF;
				}
			}
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				dist[a][b] = c;
				dist[b][a] = c;
			}
			
			
			int nFnd = Integer.parseInt(br.readLine());
			int[] Fnd = new int[nFnd+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<nFnd+1;i++) Fnd[i] = Integer.parseInt(st.nextToken());
			
			for(int k=1;k<N+1;k++) {
				for(int i=1;i<N+1;i++) {
					for(int j=1;j<N+1;j++) {
						if(dist[i][j] > dist[i][k] + dist[k][j]) dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
			int d = Integer.MAX_VALUE;
			int ans = 0;
			for(int i=1;i<N+1;i++) {
				int tmp = 0;
				for(int j:Fnd) {
					if(dist[i][j]==Integer.MAX_VALUE) continue;
					tmp+=dist[i][j];
				}
				if(d>tmp) {
					d = tmp;
					ans = i;
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

}