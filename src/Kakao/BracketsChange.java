package Kakao;

import java.util.Stack;

public class BracketsChange {

	public static void main(String[] args) {
		String p1 = "(()())()";
		String p2 = ")(";
		String p3 = "()))((()";

		System.out.println(solution(p1));
		System.out.println(solution(p2));
		System.out.println(solution(p3));
	}
	
	public static String solution(String p) {
		if(check(p)) { //�ùٸ� ��ȣ ���ڿ�
			return p;
		}
		
		//�ùٸ� ��ȣ ���ڿ� X
		String answer = change(p); //��ȯ�ϱ�
		
		return answer;
    }

	public static boolean check(String str) {
		Stack<Character> stack = new Stack<>();
		
		for(int j = 0; j < str.length(); j++) {
			char ch = str.charAt(j); //���� �ϳ� ����
			
			if(ch == '(') // '('�� ���ÿ� �ְ� 
				stack.push(ch);
			else { // ')'�϶�
				if(stack.isEmpty()) { //��������� ��
					return false;
				}
				else
					stack.pop(); //�ƴϸ� ���� �ִ� '(' ����
			}
		}

		return true;
	}
	
	public static String change(String w) {
		//���� ������
		
		
		//���
		
		return null;
	}

}
