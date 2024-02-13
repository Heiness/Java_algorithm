import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		
		int target = Integer.parseInt(br.readLine());
		int s = 0, e = n-1, ans = 0;
		
		while(true) {
			if(s>=e) break;
			int sum = arr[s] + arr[e];
			if(sum==target) ans++;
			if(sum<target) s++;
			else e--;
		}
		System.out.println(ans);
	}

}