package algorithm;

import java.io.*;

public class BOJ_1543 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String text = br.readLine(); //����
		String voca = br.readLine(); //ã������ �ܾ�
		
		String str = text.replaceAll(voca, ""); //ã������ �ܾ �������� ����
		
		int answer = -1; //���� : �ܾ� ���� Ƚ��
		if(text.length() == str.length()) { //�������� ���� ���� ����
			answer = 0; //�ܾ� ���� ����
		} else { //�������� ���� ��
			answer = (text.length() - str.length()) / voca.length();
		}
		
		System.out.println(answer);
	}

}
