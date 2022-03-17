package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WineTasting {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int[] glass = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			glass[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[n + 1];
		
		dp[1] = glass[1];
		
		if(n >= 2) {
			dp[2] = glass[1] + glass[2];
		}
		
		for(int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(glass[i - 1] + dp[i - 3], dp[i - 2]) + glass[i]);
		}
		
		System.out.println(dp[n]);
	}

}
