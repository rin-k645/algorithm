import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split("-");
		
		int result = Integer.MAX_VALUE;
		for(int i = 0; i < input.length; i++) {
			String[] addition = input[i].split("\\+");
			
			int temp = 0;
			for(int j = 0; j < addition.length; j++) {
				temp += Integer.parseInt(addition[j]);
			}
			
			if(result == Integer.MAX_VALUE)
				result = temp;
			else
				result -= temp;
		}
		
		System.out.println(result);
	}

}
