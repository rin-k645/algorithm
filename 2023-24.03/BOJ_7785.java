package algorithm;

import java.util.*;
import java.io.*;

public class BOJ_7785 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		HashSet<String> set = new HashSet<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
			String name = st.nextToken();
			String statement = st.nextToken();
			
			if(statement.equals("enter")) {
				set.add(name);
			} else {
				set.remove(name);
			}
		}
		
		//정렬
		List<String> list = new ArrayList<String>(set);
		Collections.sort(list, Collections.reverseOrder());
		
		//출력
		StringBuilder sb = new StringBuilder();
		
		for(String str : list) {
			sb.append(str + "\n");
		}
		
		System.out.println(sb);
	}

}
