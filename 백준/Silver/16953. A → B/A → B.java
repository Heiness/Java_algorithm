import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int cnt=0;
		
		while(A!=B) {
			if(B<A) {
				System.out.println(-1);
				return;
			}
			if(B%10==1) B/=10;
			else if(B%2==0) B/=2;
			else {
				System.out.println(-1);
				return;
			}
			cnt++;
		}
		System.out.println(cnt+1);
	}

}