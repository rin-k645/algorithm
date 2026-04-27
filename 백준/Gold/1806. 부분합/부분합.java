import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); //배열의 길이
		int S = Integer.parseInt(st.nextToken()); //구해야 하는 부분합
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//구현
//		int right = 0;
//		int sum = 0; //부분합 저장
//		int min = 100001; //정답: 부분합의 최소 길이
//		
//		for(int left = 0; left < N; left++) { //왼쪽 포인터 하나씩 옮기기
//			while(right < N && sum < S) { //S미만일때까지 오른쪽으로 옮기기
//				sum += arr[right];
//				right++;
//			}
//			
//			if(sum >= S) { //부분합이 S이상이면 갱신
//				min = Math.min(min, right - left);
//			}
//			
//			sum -= arr[left]; //왼쪽 포인터의 값 빼주기
//		}
		
		int left = 0;
		int sum = 0;
		int min = 100001;
		
		for(int right = 0; right < N; right++) {
//			System.out.println("right: " + right);
			sum += arr[right];
			while(left <= right && sum >= S) {
				min = Math.min(min, right + 1 - left);
				sum -= arr[left];
				left++;
//				System.out.println("left: " + left);
			}
		}
		
		//출력
		if(min == 100001) { //합을 만드는 것이 불가능
			System.out.println(0);
		} else { //가능
			System.out.println(min);
		}
	}

}