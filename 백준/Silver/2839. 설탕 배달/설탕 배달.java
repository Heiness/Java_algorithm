import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int ans=Integer.MAX_VALUE;
		int tmp=0;
		for(int i=0;i<N/3;i++) {
			tmp = N-3*i;
			int cnt = i;
			while(true) {
				if(tmp==0) break;
				if(tmp%5==0) tmp-=5;
				else if(tmp%3==0) tmp-=3;
				else break;
				cnt++;
			}
			ans = tmp==0 ? Math.min(ans, cnt) : ans;
		}
		ans = ans==Integer.MAX_VALUE ? -1 : ans;
		System.out.println(ans);
	}

}