package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_�����¦�������Ѻκм���large {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); //���� S�� ���� 
		int K = Integer.parseInt(st.nextToken()); //������ �� �ִ� �ִ� Ƚ��
		
		int[] S = new int[N]; //����
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		//����
		int right = 0;
		int count = 0; //Ȧ���� ����
		int max = 0; //���� : �ִ� ����
		
		for(int left = 0; left < N; left++) { //���� ������ �ϳ��� �Űܰ���
			while(right < N && (count < K || S[right] % 2 == 0)) { //������ �����͸� Ȧ���� K�� �̸� or ¦���϶����� �ű�
				if(S[right] % 2 == 1) count++; //Ȧ���� ���� ����
				right++;
			}
			
			max = Math.max(max, right - left - count); //¦���� ���� ����
			
			if(S[left] % 2 == 1) count--; //���� �����Ͱ� Ȧ���̸� ���� ����
		}
		
		//���
		System.out.println(max);
	}

}
