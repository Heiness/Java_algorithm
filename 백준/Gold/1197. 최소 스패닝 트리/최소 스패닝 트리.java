import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		// Kruscal
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		parent = new int[V+1];
		for (int i =0; i<=V; i++) {
			parent[i] = i;
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>(
				(o1,o2) -> o1[2] - o2[2]);
		
		for (int i =0; i<E ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int in = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			pq.add(new int[] {from,in,weight});
		}
		
		// 최소 스패닝 트리 작성
		int count = 0; 
		long cost = 0;
		while (count != V-1) {
			int[] cur = pq.poll();
			
			if (union(cur[0],cur[1])) {
				count++;
				cost = (long)(cost + (long)cur[2]);
			}
		}
		
		System.out.println(cost);
		
	}
	
	public static boolean union(int a, int b) {
		int aNode = find(a);
		int bNode = find(b);
		
		if (aNode==bNode) return false;
		
		parent[bNode] = aNode;
		return true;
		
	} 
	
	public static int find(int a) {
		if (a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}

}