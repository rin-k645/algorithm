package а╤гу;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SettingBridge {
	static int[][] dp = new int[30][30];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int result = combination(M, N);
			
			sb.append(result).append('\n');
		}
		
		System.out.println(sb);
	}

	public static int combination(int n, int r) {
		if(dp[n][r] > 0) {
			return dp[n][r]; 
		}
		
		if(n == r || r == 0) {
			return dp[n][r] = 1;
		}
		
		return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
	}

}
