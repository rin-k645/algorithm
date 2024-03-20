package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_���չ� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] size = new int[M * 2 + 1];
		
		for(int i = 0; i < M; i++) { //1�� �ʱ�ȭ
			Arrays.fill(size, 1);
		}
		
		//����
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			//�����ڸ� �ڶ��
			int idx = 0;
			for(int j = 0; j <= 2; j++) {
				int n = Integer.parseInt(st.nextToken());
				
				for(int k = 0; k < n; k++) {
					size[idx++] += j;
				}
			}
		}
		
		//���
		StringBuilder sb = new StringBuilder();
		
		for(int i = M - 1; i >= 0; i--) {
			sb.append(size[i] + " ");
			
			for(int j = M; j < 2 * M - 1; j++) { //������ �״�� ������
				sb.append(size[j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
