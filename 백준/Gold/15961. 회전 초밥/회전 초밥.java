import java.io.*;
import java.util.*;

public class Main {
	static int N,D,K,C,ans, sushi[], cntSushi[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		sushi = new int[N];
		cntSushi = new int[D+1];
		
		for(int i=0;i<N;i++) {
			sushi[i] = Integer.parseInt(br.readLine());
			if(i<K) cntSushi[sushi[i]]++;
		}
		for(int i=1;i<D+1;i++) if(cntSushi[i]!=0) ans++;
		
		int start = 0, end = K-1;
		int cnt = ans;
		for(int i=0;i<N-1;i++) {
			start = i+1;
			int tmp = i+K;
			end = (tmp>=N) ? tmp%N : tmp;
			if(--cntSushi[sushi[start-1]]==0) cnt--;
			if(cntSushi[sushi[end]]++==0) cnt++;
			if(cnt>=ans) {
				if(cntSushi[C]==0) ans = cnt+1;
				else ans = cnt;
			}
		}
		System.out.println(ans);
	}

}