import java.io.*;
import java.util.*;

public class Main {
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] arr = new char[N][N];
		boolean[][] visited = new boolean[N][N];
		for(int i=0;i<N;i++) arr[i] = br.readLine().toCharArray();
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[2], o2[2]));
		pq.offer(new int[] {0,0,0});
		visited[0][0] = true;
		
		while(!pq.isEmpty()) {
//			for(int[] t: pq) System.out.print(t[0] + " " + t[1] + " " + t[2] + " / ");
//			System.out.println();
			int[] now = pq.poll();
			int y = now[0];
			int x = now[1];
			int c = now[2];
			
			if(y==N-1&&x==N-1) {
				System.out.println(c);
				break;
			}
			
			for(int i=0;i<4;i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				if(0<=ny&&ny<N&&0<=nx&&nx<N&&!visited[ny][nx]) {
					visited[ny][nx] = true;
					if(arr[ny][nx]=='0') pq.offer(new int[] {ny,nx,c+1});
					else pq.offer(new int[] {ny,nx,c});
				}
			}
		}
		
		
	}

}