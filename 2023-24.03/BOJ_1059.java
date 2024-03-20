package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_1059 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		int[] S = new int[L];
		
		StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
		for(int i = 0; i < L; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		int n = Integer.parseInt(br.readLine());
		
		//처리
		Arrays.sort(S); //1. 정렬
		
		int min = 0; //A의 최솟값
		int max = 1001; //B의 최솟값
		for(int i = 0; i < S.length; i++) {
			if(S[i] <= n) {
				min = Math.max(min, S[i]);
			}
			
			if(S[i] > n) {
				max = Math.min(max, S[i]);
			}
		}
		
		min++;
		max--;
		
		int count = 0;
		for(int i = min; i <= n; i++) {
			for(int j = n; j <= max; j++) {
				if(i < j) {
					count++;
				}
			}
		}
		
		//출력
		System.out.println(count);
		
	}

}
