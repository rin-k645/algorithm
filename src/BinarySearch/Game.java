//백준 1072번: 게임

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
		long low = 1; //추가하는 판 수 최솟값
		long high = X; //최댓값
		
		if(Z1 >= 99) { //Z가 절대 변하지 않음
			answer = -1;
		} else {
			while(low <= high) {
				long mid = (low + high) / 2;
				
				Z2 = ((Y + mid) * 100) / (X + mid);
				
				if(Z2 < Z1 + 1) { //Z가 바뀌지 X
					low = mid + 1;
				} else { //Z가 바뀌면
					high = mid - 1;
					answer = mid;
				}
			}
		}
		
		System.out.println(answer);
	}

}
