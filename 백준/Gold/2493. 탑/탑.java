import java.io.*;
import java.util.*;

class top{
	int h;
	int i;
	
	public top(int h, int i) {
		this.h = h;
		this.i = i;
	}
}

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayDeque<top> q = new ArrayDeque<>();
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine()); 
		
		for(int i=0;i<N;i++) {
			int now = Integer.parseInt(st.nextToken());
			if(q.isEmpty()) {
				sb.append(0).append(" ");
				q.offer(new top(now, i));
			}
			else {
				while(true) { // q가 없거나 큰 값을 만날 때까지
					if(q.isEmpty()) { // 없으면 0
						sb.append(0).append(" ");
						q.offer(new top(now, i));
						break;
					}
					
					else if(q.peekLast().h<now) q.pollLast(); // 작은 값이면 제거
					
					else { // 큰 값이면 넣고 값 출력
						sb.append(q.peekLast().i+1).append(" ");
						q.offer(new top(now, i));
						break;
					}
				}
			}
		}
		System.out.println(sb);
	}
}