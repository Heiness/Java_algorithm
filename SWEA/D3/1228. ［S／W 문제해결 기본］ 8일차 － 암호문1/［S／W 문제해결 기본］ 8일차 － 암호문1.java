import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		List<Integer> li;
		
		for(int tc=1;tc<11;tc++) {
			li = new LinkedList<>();
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) li.add(Integer.parseInt(st.nextToken()));
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				
				st.nextToken();
				int x =  Integer.parseInt(st.nextToken());
				int y =  Integer.parseInt(st.nextToken());
				for(int j=0;j<y;j++) li.add(x+j,Integer.parseInt(st.nextToken()));
			}
			sb.append("#").append(tc).append(" ");
			for(int i=0;i<10;i++) sb.append(li.get(i)).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}

}