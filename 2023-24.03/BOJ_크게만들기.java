package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_ũ�Ը���� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
	
		String str = br.readLine();
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = str.charAt(i) - '0';
		}
		
		Stack<Integer> stack = new Stack<>();
		
		int count = 0; //���ݱ��� ���� ���� ����

		for(int n : arr) {
			while(!stack.isEmpty() && stack.peek() < n && count < K) { //���� �־�� �� ���ں��� ���� ���� ����
				stack.pop();
				count++;
			}
			
			stack.add(n); //���� �ֱ�
		}
		
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			if(count < K) { //�տ��� K�� ��ŭ �� �������� ��� �����ϱ�
				stack.pop();
				count++;
			} else {
				sb.append(stack.pop()); //���� ���� �ڿ������� �����
			}
		}
		
		System.out.println(sb.reverse()); //����� ���
	}

}
