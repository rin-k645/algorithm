package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeliverSugar {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		
		int bag = 0;
		while(true) {
			if(input % 5 == 0 ) {
				bag += input / 5;
				break;
			} else {
				bag++;
				input -= 3;
			}
			
			if(input < 0) {
				bag = -1;
				break;
			}
		}
		
		System.out.println(bag);
	}
	
}
