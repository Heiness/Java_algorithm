import java.io.*;
import java.util.*;

public class Solution {
	static boolean[] v = new boolean[9];
	static int scoreA, scoreB;
	static Integer[] A,B;
	static Set<Integer> Ap, Bp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<T+1;tc++) {
			scoreA=0;
			scoreB=0;
			Ap = new TreeSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18));
			Bp = new TreeSet<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<9;i++) Bp.add(Integer.parseInt(st.nextToken()));
			Ap.removeAll(Bp);
			A = Ap.toArray(new Integer[0]);
			B = Bp.toArray(new Integer[0]);
			perm(0,0,0);
			sb.append("#").append(tc).append(" ").append(scoreB).append(" ").append(scoreA).append("\n");
		}
		System.out.println(sb);
	}
	
	static void perm(int d, int sumA, int sumB) {
		if(d==9) {
			if(sumA>sumB) scoreA++;
			else if(sumA<sumB) scoreB++;
			return;
		}
		
		for(int i=0;i<9;i++) {
			if(v[i]) continue;
			v[i] = true;
			if(A[i] > B[d]) perm(d+1, sumA + A[i] + B[d], sumB);
			else perm(d+1, sumA , sumB + A[i] + B[d]);
			v[i] = false;
		}
	}

}