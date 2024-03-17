import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> d = new ArrayDeque<>();
		for(int tc=0;tc<N;tc++) {
			st = new StringTokenizer(br.readLine());
			String c = st.nextToken();
			if(c.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				d.offer(num);
			}
			else if(c.equals("front")) {
				if(d.isEmpty()) sb.append(-1).append("\n");
				else sb.append(d.peekFirst()).append("\n");
			}
			else if(c.equals("back")) {
				if(d.isEmpty()) sb.append(-1).append("\n");
				else sb.append(d.peekLast()).append("\n");
			}
			else if(c.equals("empty")) sb.append(d.isEmpty() ? 1 : 0).append("\n");
			else if(c.equals("size")) sb.append(d.size()).append("\n");
			else sb.append(d.isEmpty() ? -1 : d.poll()).append("\n");
		}
		System.out.println(sb);
	}

}