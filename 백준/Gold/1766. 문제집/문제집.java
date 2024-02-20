import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] graph = new ArrayList[N+1];
		for(int i=1;i<N+1;i++) graph[i] = new ArrayList<>();
		int[] edgeArray = new int[N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			edgeArray[b]++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=1;i<N+1;i++) if(edgeArray[i]==0) pq.offer(i);
		
		while(!pq.isEmpty()) {
			int now = pq.poll();
			sb.append(now).append(" ");
			
			for(int node: graph[now]) {
				edgeArray[node]--;
				if(edgeArray[node]==0) pq.offer(node);
			}
		}
		
		System.out.println(sb);
	}

}