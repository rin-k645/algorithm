package algorithm;

import java.util.*;
import java.io.*;

public class BOJ_�ްԼҼ���� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N + 2]; //��ӵ��� �������� ������ ������ �ްԼ� �迭
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		arr[N] = 0; //��ӵ��� ������
		arr[N + 1] = L; //��ӵ��� ������
		
		Arrays.sort(arr); //�̺�Ž�� ���� ����
		
		int answer = binarySearch(arr, M, L); //Ÿ�� : ��ġ�� �ްԼ� ��
		
		System.out.println(answer);
	}

	public static int binarySearch(int[] arr, int m, int l) {
		int low = 1; //�ްԼҰ� �Ÿ� �ּҰ�
		int high = l; //�ްԼҰ� �Ÿ� �ִ밪
		int answer = high; //���� : �Ÿ� �ִ밪�� �ּ�
		
		while(low <= high) {
			int mid = (low + high) / 2; //�ް��Ұ� �Ÿ� ����
			int count = 0; //�� ���� �ްԼ� ����
			
			//�ްԼ� ��ġ�ϱ�
			for(int i = 1; i < arr.length; i++) {
				count += (arr[i] - arr[i - 1] - 1) / mid; //�ʿ��Ѹ�ŭ �� ����
			}
			
			if(count <= m) { //�ްԼ� ����
				answer = mid; //�ּ� ����
				high = mid - 1; //���� �ٿ��� ���� ��ġ�ϱ�
			} else {
				low = mid + 1; //���� �ø���
			}
		}
		
		return answer;
	}

}
