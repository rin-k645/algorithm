//���� 1072��: ����

package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		long X = Integer.parseInt(input[0]);
		long Y = Integer.parseInt(input[1]);
		
		long Z1 = (Y * 100) / X;
		long Z2 = (Y * 100) / X;
		
		long answer = 0;
		long low = 1; //�߰��ϴ� �� �� �ּڰ�
		long high = X; //�ִ�
		
		if(Z1 >= 99) { //Z�� ���� ������ ����
			answer = -1;
		} else {
			while(low <= high) {
				long mid = (low + high) / 2;
				
				Z2 = ((Y + mid) * 100) / (X + mid);
				
				if(Z2 < Z1 + 1) { //Z�� �ٲ��� X
					low = mid + 1;
				} else { //Z�� �ٲ��
					high = mid - 1;
					answer = mid;
				}
			}
		}
		
		System.out.println(answer);
	}

}
