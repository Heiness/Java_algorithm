import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		Deque<Integer> q = new ArrayDeque<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) q.add(i+1); // 대입
		int c=0;
		
		while(true) {
			if(q.size()==1) {
				System.out.println(q.peek());
				return;
			}
			if(c%2==0) q.poll();
			else q.add(q.poll());
			c++;
		}
		
	}

}