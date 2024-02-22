import java.awt.Image;
import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	static int ans, N, M;
	static PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]); 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		for(int i=0;i<N;i++) parent[i] = i; 
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			pq.offer(new int[] {a,b,c});
		}
		
		int sum=0;
		int cnt=0;
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			if(union(now[0],now[1])) {
				sum+=now[2];
				if(++cnt==N-1) break;
			}
		}
		System.out.println(sum);
	}
	
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a==b) return false;
		if(a<b) parent[b] = a;
		else parent[a] = b;
		
		return true;
	}
	
	static int find(int x) {
		if(parent[x]==x) return x;
		else return parent[x] = find(parent[x]);
	}

}