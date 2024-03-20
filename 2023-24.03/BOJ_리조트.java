package algorithm;

import java.io.*;
import java.util.*;

class BOJ_����Ʈ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<Integer> set = new HashSet<>(); //�� �� ���� �� ����
		
		if(M > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < M; i++) {
				set.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		//����
		int[][] dp = new int[N + 6][N + 3]; //��, ���� ����
		
		for(int[] arr : dp) { //�ִ����� �ʱ�ȭ
			Arrays.fill(arr, Integer.MAX_VALUE);
		}
		
		dp[0][0] = 0;
		
		for(int i = 0; i < N + 1; i++) {
			for(int j = 0; j < N + 1; j++) {
				if(dp[i][j] == Integer.MAX_VALUE) continue; //�Ұ����� ��� �ǳʶٱ�
				
				//�� ��
				if(set.contains(i + 1)) {
					dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);
				}
				
				//���� 3�� �̻�
				if(j >= 3) {
					dp[i + 1][j - 3] = Math.min(dp[i + 1][j - 3], dp[i][j]);
				}
				
				//1�ϱ�
				dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 10000);
				
				//3�ϱ�
				for(int k = 1; k <= 3; k++) {
					dp[i + k][j + 1] = Math.min(dp[i + k][j + 1], dp[i][j] + 25000);
				}
				
				//5�ϱ�
				for(int k = 1; k <= 5; k++) {
					dp[i + k][j + 2] = Math.min(dp[i + k][j + 2], dp[i][j] + 37000);
				}
			}
		}
		
		for(int i = 0; i < N + 1; i++) {
			for(int j = 0; j < N + 1; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		
		int min = Integer.MAX_VALUE;
		for(int j = 0; j < N + 1; j++) { //�ּڰ� ���ϱ�
			min = Math.min(min, dp[N][j]);
		}
		
		System.out.println(min);
	}

}
