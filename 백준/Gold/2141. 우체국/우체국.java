import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		long sum = 0;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			sum += arr[i][1];
		}
		
		Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
		
		long mid = (sum + 1) / 2;
		
		int answer = 0;
		long total = 0;
		for(int[] a : arr) {
			total += a[1];
			
			if(total >= mid) {
				answer = a[0];
				break;
			}
		}
		
		System.out.println(answer);
	}

}