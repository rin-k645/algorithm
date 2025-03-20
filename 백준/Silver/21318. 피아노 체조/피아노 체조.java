import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1]; //i번째까지 실수하는 곡 개수
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			if(arr[i - 1] > arr[i]) { //실수하게 되는 경우
				dp[i] = dp[i - 1] + 1;
			} else {
				dp[i] = dp[i - 1];
			}
		}
		
		StringBuilder sb = new  StringBuilder();
		int Q = Integer.parseInt(br.readLine());
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			sb.append(dp[y] - dp[x] + "\n");
		}
		System.out.println(sb);
	}

}
