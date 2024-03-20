package algorithm;

import java.util.*;
import java.io.*;

public class BOJ_2947 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
	
		int[] arr = new int[5];
		int[] goal = {1, 2, 3, 4, 5};
		
		for(int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		while(!Arrays.equals(arr, goal)) {
			for(int i = 0; i <= 3; i++) {
				if(arr[i] > arr[i + 1]) {
					int tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
					
					for(int j = 0; j < 5; j++) {
						System.out.print(arr[j] + " ");
					}
					System.out.println();
				}
			}
		}
		
	}

}
