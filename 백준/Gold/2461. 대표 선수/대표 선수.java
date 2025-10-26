import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 학급 수
		int M = Integer.parseInt(st.nextToken()); // 각 학급의 학생 수
		
		int[][] arr = new int[N][M]; // 능력치
		int[] pointer = new int[N]; // 포인터 위치 기록
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr[i]); // 오름차순 정렬
		}
		
		// 구현
		int answer = 1_000_000_000; // 최대와 최소 차이
		
		int j = 0;
		int idx = 0;
		while(j < M) {
			int min = 1_000_000_000;
			int max = 0;
			
			for(int i = 0; i < N; i++) {
				if(min > arr[i][pointer[i]]) {
					min = arr[i][pointer[i]];
					idx = i;
				}
				max = Math.max(max, arr[i][pointer[i]]);
			}
			
			answer = Math.min(answer, max - min);
			j = ++pointer[idx];
		}
		
		// 출력
		System.out.println(answer);
	}

}
