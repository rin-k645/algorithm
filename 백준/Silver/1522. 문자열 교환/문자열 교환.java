import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int length = str.length();
		
		int count_a = 0;
		for(int i = 0; i < length; i++) {
			if(str.charAt(i) == 'a') count_a++;
		}
		
		int min = length;
		for(int i = 0; i < length; i++) {
			int count_b = 0;
			for(int j = i; j < i + count_a; j++) {
				if(str.charAt(j % length) == 'b') count_b++;
			}
			min = Math.min(min, count_b);
		}
		
		System.out.println(min);
	}

}