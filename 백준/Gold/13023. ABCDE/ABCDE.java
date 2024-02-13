import java.io.*;
import java.util.*;

public class Main {
	static List<Integer>[] edges;
	static int N,M;
	static boolean[] v;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		edges = new ArrayList[N];
		
		for(int i=0;i<N;i++) edges[i] = new ArrayList<>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			edges[s].add(e);
			edges[e].add(s); // 양방향
		}
		
		for(int i=0;i<N;i++) {
			v = new boolean[N];
			dfs(i,1);
		}
		System.out.println(0);
		
	}
	
	static void dfs(int start, int d) {
		if(d==5) { // 조건 만족시 종료
			System.out.println(1);
			System.exit(0);
		}
		
		v[start] = true;
		for(int i=0;i<edges[start].size();i++) {
			int end = edges[start].get(i);
			if(v[end]) continue;
			v[end] = true;
			dfs(end, d+1);
			v[end] = false;
		}
		
	}

}