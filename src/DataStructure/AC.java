package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class AC {
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			String input1 = br.readLine();
			char[] p = input1.toCharArray();
			
			int n = Integer.parseInt(br.readLine());
			
			String input2 = br.readLine();
			String[] str = input2.substring(1, input2.length() - 1).split(","); //�Ľ�
			
			Deque<Integer> deque = new ArrayDeque<>();
			
			for(int j = 0; j < n; j++) {
				deque.add(Integer.parseInt(str[j]));
			}
			
			AC(p, deque);
		}
		
		System.out.println(sb);
	}

	public static void AC(char[] p, Deque<Integer> deque) {
		boolean reversed = false;
		
		for(int i = 0; i < p.length; i++) {
			if(p[i] == 'R') {
				reversed = !reversed; //���� �ٲ��ֱ�
			}
			
			if(p[i] == 'D') {
				if(deque.size() == 0) {
					sb.append("error\n");
					return;
				} else {
					if(!reversed) { //������
						deque.pollFirst();
					} else { //������
						deque.pollLast();
					}
				}
			}
		}
		
		PrintArray(deque, reversed); //���� ��� ���
	}

	public static void PrintArray(Deque<Integer> deque, boolean reversed) {
		sb.append("[");
		
		if(deque.size() != 0) {
			if(!reversed) { //������
				sb.append(deque.pollFirst());
				
				while(!deque.isEmpty()) {
					sb.append("," + deque.pollFirst());
				}
			} else { //������
				sb.append(deque.pollLast());
				
				while(!deque.isEmpty()) {
					sb.append("," + deque.pollLast());
				}
			}
		}
		
		sb.append("]\n");
	}

}
