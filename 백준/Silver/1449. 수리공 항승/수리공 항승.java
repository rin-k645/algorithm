import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int L = Integer.parseInt(input[1]);
		
		String[] place = br.readLine().split(" ");
		
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(place[i]);
		}
		
		Arrays.sort(arr);
		
		int count = 1;
		int temp =  arr[0];
		for(int i = 0; i < N; i++) {
			if(arr[i] - temp > L - 1) {
				temp = arr[i];
				count++;
			}
		}
		
		System.out.println(count);
	}

}
