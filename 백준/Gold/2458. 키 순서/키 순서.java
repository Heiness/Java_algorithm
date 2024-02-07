import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] graph = new boolean[N][N];
		
		for(int i=0;i<M;i++) { // 대입
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			graph[a][b]=true; // 단방향 그래프
		}
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					graph[i][j] = graph[i][j] ||(graph[i][k] && graph[k][j]);
				}
			}
		} // 연결 가능 여부 check
		int cnt,ans=0;
		for(int i=0;i<N;i++) {
			cnt=0;
			for(int j=0;j<N;j++) {
				if(graph[i][j]||graph[j][i]) cnt++;
			}
			if(cnt==N-1) ans++;
		}
		
		System.out.println(ans);
		
		
	}

}