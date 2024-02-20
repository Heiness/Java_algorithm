import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] edgeArray = new int[N+1];
		List<Integer>[] graph = new ArrayList[N+1];
		for(int i=1;i<N+1;i++) graph[i] = new ArrayList<>();
		
		int[] d = new int[N+1];
		
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			d[i] = Integer.parseInt(st.nextToken());
			
			while(true) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp==-1) break;
				graph[tmp].add(i);
				edgeArray[i]++;
			}
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i=1;i<N+1;i++) if(edgeArray[i]==0) q.offer(i);
		int[] result = new int[N+1];
		for(int i=1;i<N+1;i++) result[i] = d[i];
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int node: graph[now]) {
				result[node] = Math.max(result[node], result[now]+d[node]);
				edgeArray[node]--;
				if(edgeArray[node]==0) q.offer(node);
			}
		}
		
		for(int i=1;i<N+1;i++) sb.append(result[i]).append("\n");
		System.out.println(sb);
	}

}