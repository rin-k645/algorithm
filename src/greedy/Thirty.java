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

	    for (int i = 0; i < N.length(); i++){ //숫자 배열로 변환
	        num[i] = N.charAt(i) - '0';
	    }
		
		//숫자 내림차순 정렬
		Arrays.sort(num);
		int temp;
		for(int i = 0; i < num.length / 2; i++) {
		    temp = num[i];
		    num[i] = num[(num.length - 1) - i];
		    num[(num.length - 1) - i] = temp;
		 }
		
		if(num[num.length - 1] != 0) { //마지막 자리가 0이 아니면
			System.out.println(-1);
		} else {
			//3의 배수 판정법 : 모든 자릿수의 합이 3의 배수
			int sum = 0;
			for(int i = 0; i < num.length; i++) {
				sum += num[i];
			}
			
			if(sum % 3 == 0) { //3의 배수이면
				for(int i = 0; i < num.length; i++) {
					System.out.print(num[i]);
				}
			} else {
				System.out.println(-1);
			}
		}
		
	}

}
