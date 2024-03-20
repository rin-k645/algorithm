package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_�κ��� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); //�迭�� ����
		int S = Integer.parseInt(st.nextToken()); //���ؾ� �ϴ� �κ���
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//����		
		int left = 0;
		int sum = 0; //�κ��� ����
		int min = 100001; //����: �κ����� �ּ� ����
		
		for(int right = 0; right < N; right++) { //������ ������ �ϳ��� �ű��
			sum += arr[right]; //�տ� ������ ���� ���ϱ�
			
			while(left <= right && sum >= S) { //left�� right�� �Ѿ�� ����������, ���� S�̻��϶�����
				min = Math.min(min, right + 1 - left); //�ּڰ� ����
				sum -= arr[left];
				left++; //���� ������ ����
			}
		}
		
		//���
		if(min == 100001) { //���� ����� ���� �Ұ���
			System.out.println(0);
		} else { //����
			System.out.println(min);
		}
	}

}
