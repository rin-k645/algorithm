package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoteControl {
	static boolean[] broken;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		broken = new boolean[10];
		
		if (M != 0) {
			String[] input = br.readLine().split(" ");
			for(int i = 0; i < M; i++) {
				int num = Integer.parseInt(input[i]);
				broken[num] = true;
			}
		}
		
		int min = Math.abs(N - 100);
		for(int i = 0; i < 1000000; i++) {
			int numButton = pressNum(i); //���� ��ư Ƚ��
			if (numButton > 0) {
				int moveButton = Math.abs(N - i); //�̵� ��ư Ƚ��
				min = Math.min(min, numButton + moveButton);
			}
		}
		
		System.out.println(min);
	}

	public static int pressNum(int num) {
		int count = 0;
		
		if (num == 0) {
            if (broken[0]) { //0 ��ư�� ���夷
                return 0;
            } else { //0 ��ư ����x
                return 1;
            }
        }
		
		while(num > 0) {
			if(broken[num % 10]) { //���峭 ��ư
				return 0;
			}
			count++; //��ư ����x -> ������
			num /= 10; //�ڸ��� �ø���
		}
		
		return count;
		
	}

}
