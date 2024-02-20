import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<T+1;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int total=0;
			int[] times = new int[N+1];
			
			List<Integer>[] graph = new ArrayList[N+1]; // 그래프 생성
			for(int i=1;i<N+1;i++) graph[i] = new ArrayList<>();
			
			int[] edgeArray = new int[N+1];
			
			st = new StringTokenizer(br.readLine()); // 건축 시간 삽입
			for(int i=1;i<N+1;i++) times[i] = Integer.parseInt(st.nextToken());		
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a].add(b);
				edgeArray[b]++;
			}
			
			int target = Integer.parseInt(br.readLine()); 
			
			
			int[] result = new int[N+1];
			Queue<Integer> q = new ArrayDeque<>();
			for(int i=1;i<N+1;i++) {
				result[i] = times[i]; // 기본 세팅
				if(edgeArray[i]==0) q.offer(i);
			}
			
			while(!q.isEmpty()) {
				int now = q.poll();
				
				for(int node: graph[now]) {
					result[node] = Math.max(result[now] + times[node], result[node]);
					edgeArray[node]--;
					if(edgeArray[node]==0) q.offer(node);
				}
			}
			sb.append(result[target]).append("\n");
			
		}
		System.out.println(sb);
	}

}