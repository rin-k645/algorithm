package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddingOneTwoThree {
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int[] dp = new int[12];
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i <= 11; i++) {
			for(int j = 1; j <= 3; j++) {
				if(i - j == 0) {
					dp[i] += 1;
				} else {
					dp[i] += dp[i - j];
				}
			}
			
		}
		
		int[] answer = new int[T];
		
		for(int i = 0; i < T; i++) {
			n = Integer.parseInt(br.readLine());
			
			answer[i] = dp[n];
		}
		
		for(int i = 0; i < T; i++) {
			System.out.println(answer[i]);
		}
		
	}

}
