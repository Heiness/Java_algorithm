import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> s = new ArrayDeque<>();
		
		int N = Integer.parseInt(br.readLine());
		int start = 1;
		for(int i=0;i<N;i++) {
			int M = Integer.parseInt(br.readLine());
			for(;start<=M;start++) {
				s.offer(start); // 값 넣기
				sb.append("+").append("\n");
			}
			if(s.peekLast()!=M) {
				System.out.println("NO");
				return;
			}
			
			s.pollLast(); // 값 빼기
			sb.append("-").append("\n");
		}
		System.out.println(sb);
	}

}