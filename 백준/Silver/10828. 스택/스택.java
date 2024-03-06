import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> s = new ArrayDeque<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String C = st.nextToken();
			int n = 0;
			if(C.equals("push")) n = Integer.parseInt(st.nextToken());
			
			if(C.equals("push")) {
				s.offer(n);
			}
			else if(C.equals("top")) {
				if(s.isEmpty()) sb.append(-1).append("\n");
				else sb.append(s.peekLast()).append("\n");
			}
			else if(C.equals("pop")) {
				if(s.isEmpty()) sb.append(-1).append("\n");
				else sb.append(s.pollLast()).append("\n");
			}
			else if(C.equals("size")) sb.append(s.size()).append("\n");
			else {
				if(s.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}

}