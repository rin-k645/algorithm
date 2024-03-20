package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_����� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //����� ��
		int[] arr = new int[N]; //���
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//����
		Arrays.sort(arr); //Ž���� ���� ����
		
		int ans1 = arr[0]; //���� : ���1
		int ans2 = arr[N - 2]; //���� : ���2
		int ans3 = arr[N - 1]; //���� : ���3
		long min = 3_000_000_000L;
		
		for(int i = 0; i < N - 2; i++) {
			int left = i + 1; //���� �ε���
			int right = N - 1; //������ �ε���
			
			while(left < right) {
				long sum = (long)arr[i] + arr[left] + arr[right]; //��� ȥ��
				
				System.out.println(sum);
				
				//��ǥ ã��
				if(Math.abs(sum) < min) { //Ư������ 0�� ���� ����� -> ����
					ans1 = arr[i];
					ans2 = arr[left];
					ans3 = arr[right];
					min = Math.abs(sum);
				}
				
				//������ �̵�
				if(sum > 0) { //������ ������ �� ŭ
					right--; //�����ʿ��� ������
				} else { //���� ������ �� ŭ
					left++; //���ʿ��� ������
				}
			}
		}
		
		//���
		System.out.println(ans1 + " " + ans2 + " " + ans3);
	}

}
