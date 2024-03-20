package algorithm;

import java.io.*;

public class BOJ_�������� {
	static int N;
	static String min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		make("", 0);
		
		System.out.println(min);
		
	}

	public static boolean make(String str, int count) {
		if(count == N) {
			min = str;
			return true;
		}
		
		for(int i = 1; i <= 3; i++) {
			//�κ� ������ �Ǵ��� Ȯ��
			StringBuilder sb = new StringBuilder(str);
			sb.append(i);
			
			if(!isBad(sb.toString()) && make(sb.toString(), count + 1)) { //���� �����̸� Ž��
				return true;
			}
		}
		
		return false;
	}

	public static boolean isBad(String str) {
		for(int i = 1; i <= str.length() / 2; i++) {
			String s1 = str.substring(str.length() - i, str.length());
			String s2 = str.substring(str.length() - (i * 2), str.length() - i);
			
			if(s1.equals(s2)) { //���� ����
				return true;
			}
		}
		return false;
	}
	
}
