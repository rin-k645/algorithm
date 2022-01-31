package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AtoB {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		
		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		
		int result = 0;
		
		while(true) {
			if(B < A) {
				result = -1;
				break;
			}
			if(B == A) {
				result++;
				break;
			}
				
			if(B % 10 == 1) { //1로 끝나는 경우
				result++;
				B /= 10; //1 때어내기
			} else if(B % 2 == 0) {
				result++;
				B /= 2;
			} else {
				result = -1;
				break;
			}
		}
		
		System.out.println(result);
	}

}
