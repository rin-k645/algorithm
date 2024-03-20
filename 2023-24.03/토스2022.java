package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 토스2022 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine(); //입력
		
		int ans = -1;
		for(int i = 0; i < s.length() - 2; i++) {
			int num = Integer.parseInt(s.substring(i, i + 3));
			if(num % 111 == 0) ans = Math.max(num, ans);
		}
		
		System.out.println(ans);
	}

}
