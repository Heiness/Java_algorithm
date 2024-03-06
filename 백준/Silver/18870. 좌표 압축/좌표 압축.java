import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> m = new HashMap<>();
		List<Integer> nums = new ArrayList<>();
		List<Integer> sorted = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int t = Integer.parseInt(st.nextToken());
			nums.add(t);
			sorted.add(t);
		}
		Collections.sort(sorted);
		int idx=0;
		for(int num: sorted) if(!m.containsKey(num)) m.put(num,idx++);
		for(int num: nums) sb.append(m.get(num)).append(" ");
		System.out.println(sb);
		
	}

}