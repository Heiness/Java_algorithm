import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		List<int[]> li = new ArrayList<>();
		List<int[]> cnt = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			li.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}
		
		li.sort((o1,o2)->o1[1]==o2[1]?o1[0]-o2[0]:o1[1]-o2[1]);
		
		cnt.add(li.get(0));
		for(int[] il: li.subList(1, N)) if(cnt.get(cnt.size()-1)[1]<=il[0]) cnt.add(il);
		System.out.println(cnt.size());
	}
}