import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] graph = new int[N][N];
		
		for(int i=0;i<M;i++) { // 대입
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			graph[a][b]=1; // 단방향 그래프
		}
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					graph[i][j] = graph[i][j]>0 ||(graph[i][k]>0 && graph[k][j]>0) ? 1 : 0;
				}
			}
		} // 연결 가능 여부 check
		int cnt,ans=0;
		for(int i=0;i<N;i++) {
			cnt=0;
			for(int j=0;j<N;j++) {
				if(graph[i][j]>0||graph[j][i]>0) cnt++;
			}
			if(cnt==N-1) ans++;
		}
		
		System.out.println(ans);
		
		
	}

}