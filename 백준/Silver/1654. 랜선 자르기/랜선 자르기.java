import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input1 = br.readLine().split(" ");
		int K = Integer.parseInt(input1[0]);
		int N = Integer.parseInt(input1[1]);

		int[] arr = new int[K];
		
		for(int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//계산
		Arrays.sort(arr); //이분 탐색을 위한 정렬
				
		long result = binarySearch(arr, N);
				
		//출력
		System.out.println(result);
	}

	private static long binarySearch(int[] arr, int target) {
		long left = 1; //자를 수 있는 최소 길이
		long right = arr[arr.length - 1]; //최대 길이
		long result = 0;
		
		while(left <= right) {
			long mid = (left + right) / 2; //기준
			int make = 0;
			
			//랜선 자르기
			for(int i = 0; i < arr.length; i++) {
	        	make += arr[i] / mid;
	        }

			//이분 탐색
	        if(make < target) { //목표 수보다 적으면
	            right = mid - 1;
	        } else if(make >= target) { //많거나 같으면
	        	result = mid;
	            left = mid + 1;
	        }

		}
		return result;
	}

}