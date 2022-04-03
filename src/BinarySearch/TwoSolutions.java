package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoSolutions {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		String[] input = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(arr); //�̺� Ž���� ���� ����
		
		int left = 0; //���� �ε���
		int right = N - 1; //������ �ε���
		
		int max = 2000000000;
		int solution1 = arr[left];
		int solution2 = arr[right];
		
		while(left < right) {
			int sum = arr[left] + arr[right];
			
			if(Math.abs(sum) < max) { //0�� ����� ����̸� ����
				solution1 = arr[left];
				solution2 = arr[right];
				max = Math.abs(sum);
			}
			
			if(sum > 0) { //arr[right]�� ������ �� ũ��
				right--; //������ �ε��� ���̱�
			} else { //������
				left++; //���� �ε��� �ø���
			}
		}
		
		System.out.println(solution1 + " " + solution2);
	}

}
