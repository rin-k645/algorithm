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
		if(check(p)) { //올바른 괄호 문자열
			return p;
		}
		
		//올바른 괄호 문자열 X
		String answer = change(p); //변환하기
		
		return answer;
    }

	public static boolean check(String str) {
		Stack<Character> stack = new Stack<>();
		
		for(int j = 0; j < str.length(); j++) {
			char ch = str.charAt(j); //문자 하나 추출
			
			if(ch == '(') // '('면 스택에 넣고 
				stack.push(ch);
			else { // ')'일때
				if(stack.isEmpty()) { //비어있으면 끝
					return false;
				}
				else
					stack.pop(); //아니면 먼저 있던 '(' 빼줌
			}
		}

		return true;
	}
	
	public static String change(String w) {
		//문자 나누기
		
		
		//재귀
		
		return null;
	}

}
