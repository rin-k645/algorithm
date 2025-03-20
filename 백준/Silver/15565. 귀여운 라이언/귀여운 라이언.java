import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int right = 0;
		int count = 0;
		int min = 1_000_001;
		
		for(int left = 0; left < N; left++) {
			while(right < N && count < K) {
				if(arr[right] == 1) count++;
				right++;
			}
			
			if(count == K) {
				min = Math.min(min, right - left);
			}
			
			if(arr[left] == 1) count--;
		}
		
		int answer = (min == 1_000_001) ? -1 : min;
		System.out.println(answer);
	}

}
