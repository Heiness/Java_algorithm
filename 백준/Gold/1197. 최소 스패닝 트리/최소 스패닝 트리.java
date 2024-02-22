import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[] parent;
	static PriorityQueue<Edge> edges = new PriorityQueue<>();
	
	static class Edge implements Comparable<Edge> {
		int a, b, weight;

		Edge(int a, int b, int weight) {
			this.a = a;
			this.b = b;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
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
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges.offer(new Edge(a,b,c));
		}
		
		parent = new int[N+1];
		for(int i=0;i<N+1;i++) parent[i]=i;
		
		int sum=0;
		int cnt=0;
		
		for(int i=0;i<M;i++) {
			Edge edge = edges.poll();
			if(union(edge.a,edge.b)) { // true면
				sum+=edge.weight;
				if(++cnt==M-1) break;
			}
		}
		System.out.println(sum);
		br.close();
	}
	

}