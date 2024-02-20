import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static StringTokenizer st;
	static List<Integer>[] edges;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		edges = new ArrayList[N+1]; // AL 생성
		for(int i=1;i<N+1;i++) edges[i] = new ArrayList<>();
		int[] edgeArray = new int[N+1]; 
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edges[a].add(b); 
			edgeArray[b]++;
		}
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i=1;i<N+1;i++) if(edgeArray[i]==0) q.offer(i);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			sb.append(now).append(" ");
			
			// 배열값이 0 이면 대입, 순회하면서 넣고 값 빼기
			for(int n: edges[now]) { 
				edgeArray[n]--;
				if(edgeArray[n]==0) q.offer(n);
			}
		}
		System.out.println(sb);
		
	}

}