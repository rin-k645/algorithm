package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_좋다 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		//구현
		int count = 0;
		for(int i = 0; i < N; i++) {
			int target = arr[i];
			
			HashSet<Integer> set = new HashSet<>();
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				
				int diff = target - arr[j];
				
				if(set.contains(arr[j])) {
					count++;
					break;
				}
				
				set.add(diff);
			}
		}
		
		System.out.println(count);
	}

}
