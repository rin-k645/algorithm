package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NormalKnapkSack {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input1 = br.readLine().split(" ");
		
		int N = Integer.parseInt(input1[0]);
		int K = Integer.parseInt(input1[1]);
		
		int[] W = new int[N + 1];
		int[] V = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			String[] input2 = br.readLine().split(" ");
			
			W[i] = Integer.parseInt(input2[0]);
			V[i] = Integer.parseInt(input2[1]);
		}
		
		int[][] dp = new int[N + 1][K + 1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= K; j++) {
				if(W[i] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}

}
