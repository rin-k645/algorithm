import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		
		int zeroCount = 0;
		int oneCount = 0;
		char temp = S.charAt(0);
		
		if(temp == '0')
			zeroCount = 1;
		else
			oneCount = 1;
		
		for(int i = 1; i < S.length(); i++) {
			char letter = S.charAt(i);
			
			if(letter != temp) {
				if(temp == '0') {
					oneCount++;
					temp = letter;
				} 
				else {
					zeroCount++;
					temp = letter;
				}
			}
		}
		
		System.out.println(Math.min(zeroCount, oneCount));
	}

}
