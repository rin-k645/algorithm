package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_여왕벌 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] size = new int[M * 2 + 1];
		
		for(int i = 0; i < M; i++) { //1로 초기화
			Arrays.fill(size, 1);
		}
		
		//구현
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			//가장자리 자라기
			int idx = 0;
			for(int j = 0; j <= 2; j++) {
				int n = Integer.parseInt(st.nextToken());
				
				for(int k = 0; k < n; k++) {
					size[idx++] += j;
				}
			}
		}
		
		//출력
		StringBuilder sb = new StringBuilder();
		
		for(int i = M - 1; i >= 0; i--) {
			sb.append(size[i] + " ");
			
			for(int j = M; j < 2 * M - 1; j++) { //위에것 그대로 내려옴
				sb.append(size[j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
