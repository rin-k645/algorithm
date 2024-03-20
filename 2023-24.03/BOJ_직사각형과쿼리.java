package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_���簢�������� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //��� ũ��
		
		int[][] A = new int[N + 1][N + 1]; //���
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][][] dp = new int[11][N + 1][N + 1]; //��� (i, j)������ �ش� ��ȣ�� ����
		
		//��� (i, j)������ �� ��ȣ�� ���� ���ϱ�
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				for(int k = 1; k <= 10; k++) {
					dp[k][i][j] = dp[k][i - 1][j] + dp[k][i][j - 1] - dp[k][i - 1][j - 1];
				}
				dp[A[i][j]][i][j]++;
			}
		}
		
		int Q = Integer.parseInt(br.readLine()); //���� ��
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < Q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int answer = 0;
			for(int num = 1; num <= 10; num++) {
				int count = dp[num][x2][y2] - dp[num][x1 - 1][y2] - dp[num][x2][y1 - 1] + dp[num][x1 - 1][y1 - 1];
			
				if(count > 0) answer++;
			}
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
	}

}
