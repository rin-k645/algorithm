package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_점수따먹기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N + 1][M + 1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[N + 1][M + 1]; //행렬 (i, j)까지의 합
		
		//행렬(1,1)~(i, j)까지의 합 구하기
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr[i][j];
			}
		}
		
		//행렬(x1,y1)~(x2, y2)까지의 합 구하기
		int max = Integer.MIN_VALUE;
		
		for(int x1 = 1; x1 <= N; x1++) {
			for(int y1 = 1; y1 <= M; y1++) {
				for(int x2 = x1; x2 <= N; x2++) {
					for(int y2 = y1; y2 <= M; y2++) {
						max = Math.max(max, dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1]);
					}
				}
			}
		}
		
		System.out.println(max);
	}

}
