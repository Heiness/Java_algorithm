import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<11;tc++) {
			ArrayDeque<Character> q = new ArrayDeque<Character>();
			int ans;
			br.readLine();
			String input = br.readLine();
			int len = input.length();
			label: for(int i=0;i<len;i++) {
				char c = input.charAt(i);
				char t;
				if(c=='(') t=')';
				else if(c=='[') t=']';
				else if(c=='{') t='}';
				else if(c=='<') t='>';
				else if(c==')') t='(';
				else if(c==']') t='[';
				else if(c=='}') t='{';
				else t='<';
				
				for(char qc: q) {
					if(qc==t)  {
						q.remove(t); // 있으면 제거
						continue label;
					}
				}
				
				q.offer(c); // 없으면 넣기
			}
			
			if(q.isEmpty()) ans=1; // 없으면 유효 있으면 무효
			else ans=0;
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}