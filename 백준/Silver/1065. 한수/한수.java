import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		int result = 0;
		
		if(1 <= N && N <= 99) //1~99일 경우
			result = N; //자기자신만큼
		
		int count = 99; //99까지의 한수
		if(100 <= N && N <= 1000) { //100~1000일 경우
			for(int i  = 100; i <= N; i++) {
				int hundred = i / 100; //백의 자리
				int ten = i % 100 / 10; //십의 자리
				int one = i % 100 % 10; //일의 자리
				
				if((hundred - ten) == (ten - one))
					count++;
			}
			
			result = count;
		}
		
		System.out.println(result);
	}

}