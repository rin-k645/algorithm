package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_LCS {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] s1 = br.readLine().toCharArray();
		char[] s2 = br.readLine().toCharArray();
			
		int[][] dp = new int[s1.length + 1][s2.length + 1];
		
		for(int i = 1; i < s1.length + 1; i++) {
			for(int j = 1; j < s2.length + 1; j++) {
				if(s1[i - 1] == s2[j - 1]) { //두 문자 같음
					dp[i][j] = dp[i - 1][j - 1] + 1; //왼쪽 대각선 위에서 +1
				} else { //다름
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); //왼쪽과 위에 중 큰 값
				}
			}
		}
		
		System.out.println(dp[s1.length][s2.length]);
	}

}
