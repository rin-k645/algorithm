package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LIS {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		
		String[] input = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(input[i]);
		}
		
		int[] dp = new int[N];
		
		dp[0] = 1;
		
		for(int i = 1; i < N; i++) {
			dp[i] = 1;
			
			for(int j = 0; j < i; j++) {
				if(A[j] < A[i] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
		}
	
		int max = dp[0];
		for(int i = 1; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
}
