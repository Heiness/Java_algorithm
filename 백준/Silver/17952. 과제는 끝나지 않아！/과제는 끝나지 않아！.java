import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int ans=0;
		
		Deque<int[]> s = new ArrayDeque<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken())==0) { // 최근 과제 남은 시간 감소
				if(!s.isEmpty()) s.peekLast()[1]--;
			}
			else { // 새 과제들어올 경우 착수
				int A = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				s.offer(new int[] {A,T-1});
			}
//			for(int[] ns: s) System.out.print(Arrays.toString(ns)+" ");
//			System.out.println();
			if(!s.isEmpty() && s.peekLast()[1]==0) {
				int[] now = s.pollLast();
				ans+=now[0];
			}
		}
		System.out.println(ans);
		
	}

}