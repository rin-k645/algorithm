package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_비슷한단어 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		List<String> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			if(!list.contains(str)) { //중복 제거
				list.add(str);
			}
		}
		
		int maxM = 0;
		int sIdx = 0;
		int tIdx = 0;
		
		for(int i = 0; i < list.size() - 1; i++) {
			for(int j = i + 1; j < list.size(); j++) {
				int m = getM(list.get(i), list.get(j));
				
				if(m > maxM) {
					maxM = m;
					sIdx = i;
					tIdx = j;
				}
			}
		}
		
		//출력
		System.out.println(list.get(sIdx));
		System.out.println(list.get(tIdx));
	}

	public static int getM(String str1, String str2) {
		int minLen = Math.min(str1.length(), str2.length());
		
		int count = 0;
		for(int i = 0; i < minLen; i++) {
			if(str1.charAt(i) != str2.charAt(i)) break;
			
			count++;
		}
				
		return count;
	}

}
