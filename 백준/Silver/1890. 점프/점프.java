import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//구현
		long[][] dp = new long[N][N];
		
		dp[0][0] = 1;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int dist = arr[i][j];
				
				if(dist == 0) break;
				
				if(i + dist < N) { //아래로
					if(dp[i][j] > 0) {
						dp[i + dist][j] += dp[i][j];
//						System.out.println((i + dist) + ", " + j);
					}
					
				}
				
				if(j + dist < N) { //오른쪽으로
					if(dp[i][j] > 0) {
						dp[i][j + dist] += dp[i][j];
//						System.out.println(i + ", " + (j +  dist));
					}
				}
			}
		}
		
		System.out.println(dp[N - 1][N - 1]);
	}

}