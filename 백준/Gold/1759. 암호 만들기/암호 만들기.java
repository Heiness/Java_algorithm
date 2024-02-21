import java.io.*;
import java.util.*;

public class Main {
	static int L,C;
	static char[] alphas;
	static char[] answer;
	static StringBuilder sb;
	static String mo = "aeiou";
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		alphas = new char[C];
		answer = new char[L];
		for(int i=0;i<C;i++) alphas[i] = st.nextToken().charAt(0);
		Arrays.sort(alphas);
		comb(0,0,0,0);
		System.out.println(sb);
		br.close();
	}
	
	static void comb(int d, int start, int c1, int c2) {
		if(d==L) {
			if(c1>1 && c2>0) {
				for(int i=0;i<L;i++) sb.append(answer[i]);
				sb.append("\n");
			}
			return;
		}
		
		for(int i=start;i<C;i++) {
			answer[d] = alphas[i];
			if(answer[d]=='a'||answer[d]=='e'||answer[d]=='i'||answer[d]=='o'||answer[d]=='u') comb(d+1, i+1, c1, c2+1);
			else comb(d+1, i+1, c1+1, c2);
		}
	}
}