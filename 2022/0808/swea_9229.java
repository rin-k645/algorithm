import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
		
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			//구현
			Arrays.sort(arr);
			
			int max = 0;
			for(int i = 0; i < N; i++) {
				int sum = 0;
				for(int j = i + 1; j < N; j++) {
					sum = arr[i] + arr[j];
					if(sum <= M) {
						max = Math.max(max, sum);
					}
				}
			}
			
			//출력
			System.out.print("#" + tc + " ");
			if(max != 0) {
				System.out.println(max);
			} else {
				System.out.println(-1);
			}
		
		}
	}

}
