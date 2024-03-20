package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_좋다2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		//구현
		Arrays.sort(arr); //정렬
		
		int count = 0;
		for(int i = 0; i < N; i++) {
			int target = arr[i];
			int left = 0;
			int right = N - 1;
			
			while(left < right) {
				if(left == i) {
					left++;
				} else if(right == i) {
					right--;
				}
				
				if(left == right) continue;
				
				int sum = arr[left] + arr[right];
				
				if(sum == target) {
					count++;
					break;
				} else if(sum > target) {
					right--;
				} else {
					left++;
				}
			}
		}
		
		System.out.println(count);
	}

}
