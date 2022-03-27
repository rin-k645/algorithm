package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SearchingNumber {
	static public int[] A;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		
		String[] input1 = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(input1[i]);
		}

		int M = Integer.parseInt(br.readLine());
		
		Arrays.sort(A); //탐색 전 정렬
		
		String[] input2 = br.readLine().split(" ");
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < M; i++) {
			int target = Integer.parseInt(input2[i]);
			int result = binarySearch(target, 0, A.length - 1);
			
			sb.append(result + "\n");	
		}
		
		System.out.println(sb);
	}

	public static int binarySearch(int target, int low, int high) {
		int mid;
		
		while(low <= high) {
			mid = (low + high) / 2;
			
			if(target == A[mid]) {
				return 1; //존재
			} else if(target < A[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		return 0; //존재x 
	}

}
