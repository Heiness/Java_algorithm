import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][3];
		
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<N+1;i++) {
			arr[i][0] = Math.min(arr[i-1][1], arr[i-1][2]) + arr[i][0];
			arr[i][1] = Math.min(arr[i-1][0], arr[i-1][2]) + arr[i][1];
			arr[i][2] = Math.min(arr[i-1][0], arr[i-1][1]) + arr[i][2];
		}
		
		System.out.println(Math.min(Math.min(arr[N][0], arr[N][1]), arr[N][2]));
		
	}

}