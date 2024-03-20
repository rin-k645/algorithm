package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ1863 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); //���� �ٲ�� ������ ��ǥ ����
		
		Stack<Integer> stack = new Stack<>(); //stack�� y ��ǥ�� �׾Ƴ���
		
		int answer = 0; //���� ����
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			//���� �ٲ�� ������ ��ǥ
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			//���� ������ ���� ������ ������ ������, ���� �� ī��Ʈ
			while(!stack.empty() && y < stack.peek()) { //�������� ����
				stack.pop();
				answer++;
			}
			
			if(!stack.contains(y)) { //���� ���� ���ÿ� �ֱ�
				stack.add(y);
			}
		}
		
		
		//���� �� ���ÿ� ������ 0�̻��̸� ī��Ʈ
		for(int i : stack) { 
			if(i > 0) answer++;
		}
		
		//���
		System.out.println(answer);
	}

}
