import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][M+1];
		
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<M+1;j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<M+1;j++) {
				int maxA = Math.max(arr[i-1][j-1]+arr[i][j], arr[i-1][j]+arr[i][j]);
				int maxB = Math.max(arr[i][j-1]+arr[i][j], maxA);
				
				arr[i][j] = maxB;
			}
		}
		System.out.println(arr[N][M]);
		
	}

}