import java.io.*;
import java.util.*;

public class Solution {
	static int[] dy = {-1,1,0,0}, dx = {0,0,-1,1};
	static int N,M,K,ans;
	static int[][] arr, status; // status
	static PriorityQueue<int[]> pq;
	static PriorityQueue<int[]> pq2;
//	static List<int[]> cells;
	static final int MID = 400;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<T+1;tc++) {
			ans=0;
			pq = new PriorityQueue<>((o1,o2)-> o1[3]==o2[3] ? o1[2]-o2[2] : o1[3] - o2[3]);
			status = new int[800][800];
			pq2 = new PriorityQueue<>((o1,o2)-> o1[2]-o2[2]); // -1은
//			cells = new ArrayList<>();
			
			arr = new int[800][800];
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			for(int i=MID;i<MID+N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=MID;j<MID+M;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j]!=0) {
						pq.offer(new int[] {i,j,arr[i][j],arr[i][j]+1}); // [3]은 활성화까지 남은시간.
						status[i][j] = 1;
					}
				}
			}
			// 씨를 뿌린 뒤인 활성화 세포 별도 관리 -> linkedlist?
			// 활성화 시간 다된 세포 번식 pq
//			for(int[] cell: pq) System.out.print(Arrays.toString(cell)+" ");
//			System.out.println();
			for(int h=1;h<K+1;h++) {
				for(int[] cell: pq) {
					cell[3]--; // 
				}
				for(int[] cell: pq2) {
					cell[2]--; // 
				}
				
//				for(int[] cell: pq) System.out.print(Arrays.toString(cell)+" ");
				expand();
				for(int i=MID-h-1;i<MID+N+h+1;i++) {
					for(int j=MID-h;j<MID+M+h+1;j++) {
						if(arr[i][j]>0) status[i][j]=1;
//						System.out.printf("%3d ",arr[i][j]);
//						System.out.print(" ");
					}
//					System.out.println();
				}
				while(!pq2.isEmpty() && pq2.peek()[2]==0) { // 활성시간 체크
					pq2.poll();
					}
				}
			
			for(int i=MID-K-1;i<MID+N+K+1;i++) for(int j=MID-K;j<MID+M+K+1;j++) if(arr[i][j]>0) ans++;
//			System.out.println(ans+pq2.size());
			sb.append("#").append(tc).append(" ").append(ans+pq2.size()).append("\n");
//			for(int[] cell: pq2) System.out.print(Arrays.toString(cell)+" ");
				
			}
		System.out.println(sb);
			
		}
	
	
	static void search(int h) { // -1은 죽은세포, 0은 빈칸, 
		for(int i=MID-h;i<MID+N+h+1;i++) {
			for(int j=MID-h;j<MID+M+h+1;j++) {
				if(arr[i][j]!=0) pq.offer(new int[] {i,j,arr[i][j]}); 
			}
		}
	}
	
	static void expand() {
		// 생명력이 약한 녀석이 먼저하도록
		while(!pq.isEmpty() && pq.peek()[3]==0) { // 시간 된 애들 있으면 계속 확산 후 비활성화 상태로 넣기
			int[] now = pq.poll();
			int y = now[0];
			int x = now[1];
			int power = now[2];
			if(arr[y][x]!=power) continue;
			arr[y][x] = -1; // 활성 상태로 변경
			pq2.offer(new int[] {y,x,power-1});
			
			// po
			for(int i=0;i<4;i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				
				if(0<=ny&&ny<800&&0<=nx&&nx<800&&0<=arr[ny][nx]&&arr[ny][nx]<power&&status[ny][nx]==0) {
					arr[ny][nx] = power;
//					status[ny][nx] = 1;
					pq.offer(new int[] {ny,nx,power,power+1});
				}
			}
		}
		
		
	}

}