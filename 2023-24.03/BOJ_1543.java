package algorithm;

import java.io.*;

public class BOJ_1543 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String text = br.readLine(); //문서
		String voca = br.readLine(); //찾으려는 단어
		
		String str = text.replaceAll(voca, ""); //찾으려는 단어를 문서에서 제거
		
		int answer = -1; //정답 : 단어 등장 횟수
		if(text.length() == str.length()) { //문서에서 제거 되지 않음
			answer = 0; //단어 등장 안함
		} else { //문서에서 제거 됨
			answer = (text.length() - str.length()) / voca.length();
		}
		
		System.out.println(answer);
	}

}
