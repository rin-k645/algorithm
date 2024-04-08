import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		boolean flag = false;
		int answer = Integer.MAX_VALUE;
		for(int i = 0; i < N - 3; i++) {
			for(int j = i + 3; j < N; j++) {
				int elsa = arr[i] + arr[j];
				
				int left = i + 1;
				int right = j - 1;
				while(left < right) {
					int anna = arr[left] + arr[right];
					
					int diff = elsa - anna;					
					answer = Math.min(answer, Math.abs(diff));
					
					if(diff == 0) {
						flag = true;
						break;
					} else if(elsa > anna) {
						left++;
					} else {
						right--;
					}
				}
				
				if(flag) break;
			}
		}
		
		System.out.println(answer);
	}

}