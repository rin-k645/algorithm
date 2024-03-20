package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_�����ڳ����ֱ�3 {
	static int N; //���� ũ��
	static int[] arr; //����
	static int[] op; //�����ں� ����
	static int[] result; //������ ���� ���
	static int max = -1000000000; //���� : �ִ�
	static int min = 1000000000; //���� : �ּڰ�
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		op = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
	
		for(int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		//����
		result = new int[N - 1];
		
		permutation(0);
		
		//���
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void permutation(int depth) {
		if(depth == N - 1) {
			int result = calculate(); //���� ���
			
			max = Math.max(max, result);
			min = Math.min(min, result);
			
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(op[i] != 0) { //�ش� �����ڰ� ������
				op[i]--;
				result[depth] = i; //������ ���� ����
				permutation(depth + 1); //���� �ڸ� Ž��
				op[i]++;
			}
		}
	}

	public static int calculate() {
		Stack<Integer> stack = new Stack<>();
		
		stack.add(arr[0]); //ó�� �� �ְ� ����
		
		for(int i = 1; i < N; i++) {
			int num = 0; //�߰� ���� ���
			
			if(result[i - 1] == 0) { //����
				num = arr[i];
			} else if(result[i - 1] == 1) { //����
				num = arr[i] * -1;
			} else if(result[i - 1] == 2) { //����
				num = stack.pop() * arr[i];
			} else if(result[i - 1] == 3) { //������
				num = stack.pop() / arr[i];
			}
			
			stack.add(num); //�߰� ���� ��� �ֱ�
		}
		
		int result = 0; //���� ���
		for(int n : stack) {
			result += n;
		}
		
		return result;
	}

}
