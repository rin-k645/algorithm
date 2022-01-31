package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Thirty {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();
		int[] num = new int[N.length()];

	    for (int i = 0; i < N.length(); i++){ //���� �迭�� ��ȯ
	        num[i] = N.charAt(i) - '0';
	    }
		
		//���� �������� ����
		Arrays.sort(num);
		int temp;
		for(int i = 0; i < num.length / 2; i++) {
		    temp = num[i];
		    num[i] = num[(num.length - 1) - i];
		    num[(num.length - 1) - i] = temp;
		 }
		
		if(num[num.length - 1] != 0) { //������ �ڸ��� 0�� �ƴϸ�
			System.out.println(-1);
		} else {
			//3�� ��� ������ : ��� �ڸ����� ���� 3�� ���
			int sum = 0;
			for(int i = 0; i < num.length; i++) {
				sum += num[i];
			}
			
			if(sum % 3 == 0) { //3�� ����̸�
				for(int i = 0; i < num.length; i++) {
					System.out.print(num[i]);
				}
			} else {
				System.out.println(-1);
			}
		}
		
	}

}
