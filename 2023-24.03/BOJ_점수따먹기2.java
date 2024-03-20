package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_�������Ա�2 {

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
		
		int[][] dp = new int[N + 1][M + 1]; //��� (i, 1)~(i, j)������ ��
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				dp[i][j] = dp[i][j - 1] + arr[i][j];
			}
		}
		
		int max = Integer.MIN_VALUE; //���� : �κ� ��� ���� �ִ�
		
		for(int i = 1; i <= M; i++) {
			for(int j = i; j <= M; j++) {
				int sum = 0;
				for(int k = 1; k <= N; k++) { //�� �÷���
					int row = dp[k][j] - dp[k][i - 1]; //����
					sum += row; //���� ����
					if(row > sum) sum = row; //���� �� �� ũ��, ���� ��� ������ sum�� ����
					max = Math.max(max, sum); //�ִ� ����
				}
			}
		}
		
		System.out.println(max);
	}

}
