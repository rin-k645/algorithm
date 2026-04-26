import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		String[] input = br.readLine().split(" ");
	
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(input[i]);
		
		List result = new ArrayList();
		
		for(int i = N - 1; i >= 0; i--)
			result.add(arr[i], i + 1);
		
		for(int i = 0; i < N; i++)
			System.out.print(result.get(i) + " ");
	}

}
