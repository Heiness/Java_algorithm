import java.io.*;
import java.util.*;

public class Main {
	static int[] heights = new int[9];
	static int[] tmp = new int[7];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<9;i++) heights[i] = Integer.parseInt(br.readLine()); // 값 대입
		
		comb(0, 0, 0);
	}
	
	static void comb(int d, int start, int sum) {
		if(d==7) {
			if(sum==100) for(int n: tmp) System.out.println(n);
			return;
		}
		for(int i=start;i<9;i++) {
			tmp[d] = heights[i];
			comb(d+1,i+1,sum+heights[i]);
		}
	}
}