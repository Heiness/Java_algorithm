import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		int s=0,e=N-1;
		long[] tmp= new long[2];
		long now = Long.MAX_VALUE;
		
		while(s<e) {
			long sum = Math.abs(arr[s] + arr[e]); // 합
			if(now>sum) {
				now = sum;
				tmp[0] = arr[s];
				tmp[1] = arr[e];
			}
			if(now==0) {
				System.out.println(tmp[0]+" "+tmp[1]);
				return;
			}
			
			if(Math.abs(arr[s])>Math.abs(arr[e])) s++;
			else e--;
		}
		System.out.println(tmp[0]+" "+tmp[1]);
	}

}