package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_LCS2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] s1 = br.readLine().toCharArray();
		char[] s2 = br.readLine().toCharArray();

		int[][] dp = new int[s1.length + 1][s2.length + 1];

		for (int i = 1; i < s1.length + 1; i++) {
			for (int j = 1; j < s2.length + 1; j++) {
				if (s1[i - 1] == s2[j - 1]) { // �� ���� ����
					dp[i][j] = dp[i - 1][j - 1] + 1; // ���� �밢�� ������ +1
				} else { // �ٸ�
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // ���ʰ� ���� �� ū ��
				}
			}
		}
		
		//���� ���ϱ�
		Stack<Character> stack = new Stack<>();
		
		int i = s1.length; //�ڿ������� �ٿ����鼭 ������
		int j = s2.length;
		
		while(i != 0 && j != 0){
	        if(dp[i][j] == dp[i - 1][j]){ //���� ������
	            i--; //���� �̵�
	        }else if(dp[i][j] == dp[i][j - 1]){ //���ʰ� ������
	            j--; //�������� �̵�
	        }else{ //�ƴϸ�
	        	stack.push(s1[i - 1]); //���� ���
	            i--; //�밢�� ���� �̵�
	            j--;
	        }
	    }
		
		//���
		System.out.println(dp[s1.length][s2.length]);
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
		
	}

}
