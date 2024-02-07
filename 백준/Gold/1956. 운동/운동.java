import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int M= 10_000*500;
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int[][] dist = new int[V][V];
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			dist[a-1][b-1] = c;
		}
		
		for(int i=0;i<V;i++) for(int j=0;j<V;j++) if(i!=j&& dist[i][j]==0) dist[i][j] = M;
		
		for(int k=0;k<V;k++) {
			for(int i=0;i<V;i++) {
				for(int j=0;j<V;j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		int ans = M;
		for(int i=0;i<V;i++) {
			for(int j=i+1;j<V;j++) {
				if(dist[i][j]!=M&&dist[j][i]!=M) ans = Math.min(ans, dist[i][j] + dist[j][i]);
			}
		}
		System.out.println(ans==M?-1:ans);
		
	}

}