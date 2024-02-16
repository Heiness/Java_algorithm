import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M, D;
	static boolean [][] map;
	
	static boolean checkRange(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=M) return false;
		return true;
	}
	
	static int [][] combs;
	static int total = 0;
	static void comb(int index, int cnt, int [] c) {
		if(cnt==3) {
			combs[total++] = c.clone();
			return;
		}
		
		for(int i=index;i<M;i++) {
			c[cnt]=i;
			comb(i+1, cnt+1, c);
		}
	}
	
	static Point attack(boolean[][] testMap, int y, int time) {
		for(int l=1;l<=D;l++) {
			for(int j=-(l-1);j<=(l-1);j++) {
				int i = l-Math.abs(j);
				if((N-i)>=0 && (N-i)<N &&(y+j)>=0 && (y+j)<M && testMap[N-i][y+j]) {
					return new Point(N-i, y+j);
				}
			}
		}
		return null;
	}
	
	static boolean [][] forward(boolean [][] testMap, int time) {
		boolean [][] copy = new boolean[N][M];

		for(int i=time+1;i<N;i++) {
			copy[i] = testMap[i-1].clone();
		}
		
		return copy;
	}
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken())==1?true:false;
			}
		}
		combs = new int [M*(M-1)*(M-2)/6][3];
		comb(0, 0, new int [3]);
		
		int total = 0;
		for(int [] c : combs) {
			int ans = 0;
			boolean [][] testMap = new boolean[N][M];
			for(int i=0;i<N;i++) {
				testMap[i] = map[i].clone();
			}
			for(int i=0;i<N;i++) {
                List<Point> ps = new ArrayList<>();
				for(int j=0;j<3;j++) {
					Point p = attack(testMap, c[j], i);
					if(p != null) {
						ps.add(p);
					}
				}
				for(int j=0;j<ps.size();j++) {
					Point p = ps.get(j);
					if(testMap[p.x][p.y]) {
						testMap[p.x][p.y] = false;
						ans++;
					}
				}
				testMap = forward(testMap, i);
			}
			total = total<ans?ans:total;
		}
		System.out.println(total);
	}
}