package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Treasure {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		int[] B = new int[N];

		String[] input1 = br.readLine().split(" ");
		String[] input2 = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(input1[i]);
			B[i] = Integer.parseInt(input2[i]);
		}
		
		//A 내림차순 정렬
		Arrays.sort(A);
		int temp;
		for(int i = 0; i < N / 2; i++) {
		    temp = A[i];
		    A[i] = A[(N - 1) - i];
		    A[(N - 1) - i] = temp;
		 }

		Arrays.sort(B); //B 오름차순 정렬
		
		int S = 0;
		for(int i = 0; i < N; i++) {
			S += A[i] * B[i];
		}
		
		System.out.println(S);
	}

}
