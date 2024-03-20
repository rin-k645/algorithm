package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_�����Ǵ޿��� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//dp �ʱ�ȭ
		int[][][] dp = new int[3][N][M];
		
		for(int j = 0; j < M; j++) { //0�� -> �迭��
			dp[0][0][j] = arr[0][j];
			dp[1][0][j] = arr[0][j];
			dp[2][0][j] = arr[0][j];
		}
		
		for(int i = 0; i < N; i++) { //M-1�� -> �ִ�
			dp[0][i][M - 1] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < N; i++) { //0�� -> �ִ�
			dp[2][i][0] = Integer.MAX_VALUE;
		}
		
		//����
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < M; j++) {
				//�׷� �̵�
				if(j < M - 1) {
					dp[0][i][j] = Math.min(dp[1][i - 1][j + 1], dp[2][i - 1][j + 1]) + arr[i][j];
				}
				//��� �̵�
				dp[1][i][j] = Math.min(dp[0][i - 1][j], dp[2][i - 1][j]) + arr[i][j];
				//�ٷ� �̵�
				if(j > 0) {
					dp[2][i][j] = Math.min(dp[0][i - 1][j - 1], dp[1][i - 1][j - 1]) + arr[i][j];
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int j = 0; j < M; j++) { //������ �� ��� ����
			for(int k = 0; k < 3; k++) { //��� ���� Ž��
				min = Math.min(min, dp[k][N - 1][j]);
			}
		}
		
		//���
		System.out.println(min);
	}

}
