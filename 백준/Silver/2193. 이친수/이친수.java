import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[N + 1][2];

		//첫번째 자릿수(1)
		dp[1][0] = 0;
		dp[1][1] = 1;
				
		//두번째 자릿수~
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j <= 1; j++) {
				if(j == 0)
					dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
				if(j == 1)
					dp[i][1] = dp[i - 1][0];
			}
		}
		
		//경우의 수 더하기
		long result = dp[N][0] + dp[N][1];
				
		System.out.println(result);
	}

}