import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] dist = new int[N][N];

		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if(a==-1&&b==-1) break;
			dist[a-1][b-1] = 1;
			dist[b-1][a-1] = 1;
		}

		for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) if (i != j && dist[i][j] == 0) dist[i][j] = 100;
		
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
			}
		}
		int[] tmp = new int[N];
		int minV=100;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) if(tmp[i]<dist[i][j]) tmp[i] = dist[i][j];
			minV = Math.min(minV, tmp[i]);
		}
		
		int ansP = 0;
		int[] ans = new int[50]; 
		int idx=0;
		for(int i=0;i<N;i++) {
			if(minV==tmp[i]) {
				ansP++;
				ans[idx++] = i;
			}
		}
		
		sb.append(minV).append(" ").append(ansP).append("\n");
		for(int i=0;i<idx;i++) {
			sb.append(ans[i]+1).append(" ");
		}
		System.out.println(sb);

	}
}