import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<T+1;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int ans = 0;
			HashSet<String> hs = new HashSet<String>();
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) hs.add(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) if(hs.contains(st.nextToken())) ans++;
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
				
		}
		System.out.println(sb);
	}

}