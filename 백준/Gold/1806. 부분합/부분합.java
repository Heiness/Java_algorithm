import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int s=0,e=0,sum=0,ans=Integer.MAX_VALUE;
		
		while(true) {
			if(sum>=S) {
				ans = Math.min(ans, e-s);
				sum-=arr[s++];
			}
			else if(e==N) break;
			else sum+=arr[e++];
		}
		System.out.println(ans==Integer.MAX_VALUE ? 0 : ans);
	}

}