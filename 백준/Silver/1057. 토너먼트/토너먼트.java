import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int Kim = Integer.parseInt(input[1]);
		int Lim = Integer.parseInt(input[2]);
		
		int count = 0;
		while(true) {
			count++;
			
			if((Kim + 1) / 2 == (Lim + 1) / 2)
				break;
			
			Kim = (Kim + 1) / 2;
			Lim = (Lim + 1) / 2;
		}
		
		System.out.println(count);
	}

}
