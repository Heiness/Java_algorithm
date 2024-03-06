import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Deque<Integer> q = new ArrayDeque<>();
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String c = st.nextToken();
			if(c.equals("push")) q.offer(Integer.parseInt(st.nextToken()));				
			else if(c.equals("front")) {
				if(q.isEmpty()) sb.append(-1).append("\n");
				else sb.append(q.peekFirst()).append("\n");
			}
			else if(c.equals("back")) {
				if(q.isEmpty()) sb.append(-1).append("\n");
				else sb.append(q.peekLast()).append("\n");
			}
			else if(c.equals("size")) sb.append(q.size()).append("\n");
			else if(c.equals("empty")) {
				if(q.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}
			else if(c.equals("pop")) {
				if(q.isEmpty()) sb.append(-1).append("\n");
				else sb.append(q.pollFirst()).append("\n");
			}
		}
		System.out.println(sb);
	}

}