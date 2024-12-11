import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = N - 1;
		int answer = 0;
		
		while(left < right) {
			int sum = arr[left] + arr[right];
			
			if(sum == M) answer++;
			
			if(sum <= M) left++;
			else right--;
		}
		
		System.out.println(answer);
	}

}