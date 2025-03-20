import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] T = new int[N];
		long max_time = 0;
		
		for(int i = 0; i < N; i++) {
			T[i] = Integer.parseInt(br.readLine());
			max_time = Math.max(max_time, T[i]);
		}
		
		long low = 1;
		long high = max_time * M;
		long answer = Long.MAX_VALUE;
		
		while(low <= high) {
			long mid = (low + high) / 2; // 시간
			
			// 해당 시간으로 몇 명 처리할 수 있는지 구하기
			long count = 0;
			for(int t : T) {
				count += mid / t;
				if(count >= M) break;
			}
			
			if(count >= M) {
				high = mid - 1;
				answer = mid;
			} else {
				low = mid + 1;
			}
		}
		
		System.out.println(answer);
	}

}
