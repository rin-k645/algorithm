package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoSolutions {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		String[] input = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(arr); //이분 탐색을 위한 정렬
		
		int left = 0; //왼쪽 인덱스
		int right = N - 1; //오른쪽 인덱스
		
		int max = 2000000000;
		int solution1 = arr[left];
		int solution2 = arr[right];
		
		while(left < right) {
			int sum = arr[left] + arr[right];
			
			if(Math.abs(sum) < max) { //0에 가까운 용액이면 선택
				solution1 = arr[left];
				solution2 = arr[right];
				max = Math.abs(sum);
			}
			
			if(sum > 0) { //arr[right]의 절댓값이 더 크면
				right--; //오른쪽 인덱스 줄이기
			} else { //작으면
				left++; //왼쪽 인덱스 늘리기
			}
		}
		
		System.out.println(solution1 + " " + solution2);
	}

}
