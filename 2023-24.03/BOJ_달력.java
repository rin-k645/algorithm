package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_�޷� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] calendar = new int[367];
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			calendar[start] += 1;
			calendar[end + 1] += -1;
		}
		
		//Ž��
		int area = 0; //����: ������ ����
		boolean opened = false; //���� ���ȴ���
		int start = 0, end = 0;
		int sum = 0; //���� ��
		int max = 0; //���� ���� �ִ� ���� ��
		
		for(int i = 1; i <= 366; i++) {
			if(!opened && calendar[i] > 0) { //���� ����
				start = i;
				opened = true;
			}
			
			if(opened) { //���ӵ� ������
				sum += calendar[i];
				max = Math.max(max, sum);
				
				if(sum == 0) { //���� ���� ����
					end = i;
					area += (end - start) * max; //���� ����
					opened = false; //�ʱ�ȭ
					sum = 0;
					max = 0;
				}
			}
		}
		
		System.out.println(area);
	}

}
