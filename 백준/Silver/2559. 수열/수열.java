import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int s=0, e=M-1, sum=0, ans=-2000;
		for(int i=0;i<M;i++) sum+=arr[i]; // 초기 sum값
		ans = Math.max(sum, ans);
		for(int i=0;i<N-M;i++) {
			sum-=arr[s++];
			sum+=arr[++e];
			if(ans<sum) ans = sum;
		}
		System.out.println(ans);
	}
}