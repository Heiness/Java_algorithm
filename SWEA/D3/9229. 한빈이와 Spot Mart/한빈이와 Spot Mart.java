import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<T+1;tc++) {
			int ans=-1;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			
			// 과자 무게가 초과시 end-1
			// 무게가 부족시 start+1
			int start=0,end=N-1;
			while(start<end) {
				int sum = arr[start]+arr[end];
				if(sum>M) end--;
				else {
					ans = Math.max(ans,sum);
					start++;
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

}