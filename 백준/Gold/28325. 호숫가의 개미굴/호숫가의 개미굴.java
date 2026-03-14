import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] arr = new long[N + 1];
		long sum = 0;
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			sum += arr[i];
		}
		
		// 구현
		long answer = 0;
		if(sum == 0) {
			answer = (N + 1) / 2;
		} else {
			answer += sum;
			
			// 시작 구간
			int start = 0;
	        int i = 0;
	        while(i < N && arr[i] == 0) {
	        	start++;
	            i++;
	        }
	        
	        // 끝
	        int end = 0;
	        i = N - 1;
	        while(i >= 0 && arr[i] == 0) {
	        	end++;
	            i--;
	        }
	        
	        // 중간
	        int count = 0;
	        for(i = start; i < N - end; i++) {
	            if(arr[i] == 0) {
	            	count++;
	            } else {
	                answer += (count + 1) / 2;
	                count = 0;
	            }

	        }
	        
	        // 끝 ~ 시작
	        answer += (start + end + 1) / 2;
		}
		
		// 출력
        System.out.println(answer);
	}

}
