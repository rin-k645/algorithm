package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculateDate {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int E = Integer.parseInt(input[0]);
		int S = Integer.parseInt(input[1]);
		int M = Integer.parseInt(input[2]);
		
		int e = 0, s = 0, m = 0;
		int year = 0;
		
		while(true) {
			if(e == E && s == S && m == M) {
				break;
			}
			
			e++;
			s++;
			m++;
			year++;
			
			if(e == 16) {
				e = 1;
			}
			if(s == 29) {
				s = 1;
			}
			if(m == 20) {
				m = 1;
			}
		}
		
		System.out.println(year);
	}

}
