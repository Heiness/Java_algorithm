import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq1 = new PriorityQueue<>((o1,o2)->-Integer.compare(o1, o2));
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		int l1=0,l2=0;
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			if(l1==l2) { // 같으면 무조건 앞에 넣어야함 - 그래야 힙1의 배출이 중간값.
				pq1.offer(num);
				l1++;
			} else {
				pq2.offer(num);
				l2++;
			}
			
			if(l1!=0 && l2!=0) {
				if(pq1.peek()>pq2.peek()) {
					int tmp = pq1.poll();
					pq1.offer(pq2.poll());
					pq2.offer(tmp);
				}
			}
			
			sb.append(pq1.peek()).append("\n");
		}
		System.out.println(sb);
	}

}