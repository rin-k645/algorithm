package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_����_��Ƹ� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
		
		int N = Integer.parseInt(st.nextToken()); //a�� ����
		int M = Integer.parseInt(st.nextToken()); //z�� ����
		int K = Integer.parseInt(st.nextToken()); //k��°
		
		int[][] dp = new int[N + M + 1][N + 1]; //n+mCn
		
		for (int i = 0; i < N + M + 1; i++) {
	        for(int j = 0; j <= i && j < N + 1; j++) {
	            if(j == 0 || i == j ) {
	            	dp[i][j] = 1;
	            }else {
	            	dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
	            }
	        }
	    }
		
		if(dp[N + M][N] < K) { //������ ���ϵǾ� �ִ� ���ڿ��� ������ K���� ����
			System.out.println(-1);
		} else {
			//���ڿ� ���ϱ�
			
		}
		
	}

}
