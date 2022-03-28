package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CuttingTree {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input1 = br.readLine().split(" ");
		int N = Integer.parseInt(input1[0]);
		int M = Integer.parseInt(input1[1]);
		
		int[] tree = new int[N];
		
		String[] input2 = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(input2[i]);
		}
		
		Arrays.sort(tree); //이분 탐색을 위한 정렬
		
		int answer = 0;
		int low = 0; //H 최소
		int high = tree[tree.length - 1]; //H 최대(가장 큰 나무)
		
		while(low <= high) {
			int mid = (low + high) / 2;
			
			long sum = 0;
			for(int i = 0; i < N; i++) {
				if(tree[i] > mid) { //절단하고 남으면
					sum += (tree[i] - mid); //들고 가기
				}
			}
			
			if(sum < M) { //M보다 더 적은 나무 가져가면
        		high = mid - 1; //H 줄이기
        	} else { //M보다 더 많은 나무 가져가면
        		low = mid + 1; //H 늘리기
        		answer = mid;
        	}
		}
		
		System.out.println(answer);
	}

}
