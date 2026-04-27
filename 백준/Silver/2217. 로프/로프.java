import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [] weight = new int[N];
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			
			weight[i] = Integer.parseInt(input);
		}
		
		Arrays.sort(weight);
		
		int temp;
		for(int i = 0; i < N / 2; i++) {
		    temp = weight[i];
		    weight[i] = weight[(N - 1) - i];
		    weight[(N - 1) - i] = temp;
		 }
	    
		int wk = 0;
		int max = 0;
		for(int i = 0; i < N; i++) {
			wk = weight[i] * (i + 1);
			
			if(wk >= max)
				max = wk;
		}
		
		System.out.println(max);

	}

}
