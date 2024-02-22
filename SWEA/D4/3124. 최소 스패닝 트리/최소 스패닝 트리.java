import java.io.*;
import java.util.*;

public class Solution {

	static class Node implements Comparable<Node>{
		int from,to,w;
		
		public Node(int from, int to, int w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
			
	}
	
//	static long ans;
	static int[] parent;
	static PriorityQueue<Node> pq;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<T+1;tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			parent = new int[V+1];
			for(int i=0;i<V+1;i++) parent[i] = i;
			pq = new PriorityQueue<>();
			
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				pq.offer(new Node(a,b,c));
			}
			
			long ans=0;
			int cnt=0;
			
			while(!pq.isEmpty()) {
				Node p = pq.poll();
				if(union(p.from,p.to)) {
					ans+=p.w;
					if(++cnt==V-1) break;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
		}
		System.out.println(sb);
	}
	
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a==b) return false;
		if(a<b) parent[b]=a;
		else parent[a]=b;
		return true;
	}
	
	static int find(int x) {
		if(parent[x]==x) return x;
		else return parent[x] = find(parent[x]);
	}
}