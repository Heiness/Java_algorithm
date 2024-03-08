import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		TreeMap<Integer, Integer> tm;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<T+1;tc++) {
			int N = Integer.parseInt(br.readLine());
			tm = new TreeMap<>();
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				char c = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				if(c=='I') tm.put(num, tm.getOrDefault(num, 0)+1);
				else{
					int cnt = tm.size();
					if(cnt==0) continue; // 비었으면 스킵
					int tmp=0;
					if(num==1) tmp = tm.lastKey();
					else tmp = tm.firstKey();
					if(tm.get(tmp)==1) tm.remove(tmp);
					else tm.put(tmp, tm.get(tmp)-1);
				}
			}
			if(tm.isEmpty()) sb.append("EMPTY").append("\n");
			else sb.append(tm.lastKey()).append(" ").append(tm.firstKey()).append("\n");
		}
		System.out.println(sb);
		
	}

}