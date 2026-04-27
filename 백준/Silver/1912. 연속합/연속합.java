import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N + 1];
		
		String[] row = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			arr[i + 1] = Integer.parseInt(row[i]);
		}
		
		//계산
		int[] dp = new int[N + 1];
		
		//n = 1일 때
		dp[1] = arr[1];
		
		//n >= 2일 떄
		int max = arr[1];
		
		for (int i = 2; i <= N; i++) {
			dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
			
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);

	}

}