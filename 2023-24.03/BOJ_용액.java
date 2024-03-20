package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_��� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //����� ��
		int[] arr = new int[N]; //���
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//����
		Arrays.sort(arr); //Ž���� ���� ����
		
		int left = 0; //���� �ε���
		int right = N - 1; //������ �ε���
		int min = 2_000_000_000;
		
		int ans1 = arr[0]; //���� : ���1
		int ans2 = arr[N - 1]; //���� : ���2
		
		while(left < right) {
			int sum = arr[left] + arr[right]; //��� ȥ��
			
			//��ǥ ã��
			if(Math.abs(sum) < min) { //Ư������ 0�� ���� ����� -> ����
				ans1 = arr[left];
				ans2 = arr[right];
				min = Math.abs(sum);
			}
			
			//������ �̵�
			if(sum > 0) { //������ ������ �� ŭ
				right--; //�����ʿ��� ������
			} else { //���� ������ �� ŭ
				left++; //���ʿ��� ������
			}
		}
		
		//���
		System.out.println(ans1 + " " + ans2);
	}

}
