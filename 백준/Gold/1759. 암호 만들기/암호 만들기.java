import java.io.*;
import java.util.*;

public class Main {
	static int L,C;
	static char[] alphas;
	static char[] answer;
	static boolean[] visited;
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visited = new boolean[C];
		
		st = new StringTokenizer(br.readLine());
		alphas = new char[C];
		answer = new char[L];
		for(int i=0;i<C;i++) alphas[i] = st.nextToken().charAt(0);
		Arrays.sort(alphas);
		comb(0,0,0,0);
		
		
	}
	
	static void comb(int d, int start, int c1, int c2) {
		if(d==L) {
			if(c1>1 && c2>0) System.out.println(String.valueOf(answer));
			return;
		}
		
		for(int i=start;i<C;i++) {
			char tmp = alphas[i];
			answer[d] = tmp;
			if("aeiou".contains(tmp+"")) comb(d+1, i+1, c1, c2+1);
			else comb(d+1, i+1, c1+1, c2);
		}
	}
}