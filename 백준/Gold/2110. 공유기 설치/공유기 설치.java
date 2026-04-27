import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input1 = br.readLine().split(" ");
		int N = Integer.parseInt(input1[0]);
		int C = Integer.parseInt(input1[1]);

		int[] x = new int[N];
		
		for(int i = 0; i < N; i++) {
			x[i] = Integer.parseInt(br.readLine());
		}
		
		//계산
		Arrays.sort(x); //이분 탐색을 위한 정렬
		
		int result = binarySearch(x, C);
		
		//출력
		System.out.println(result);
	}
	
	public static int binarySearch(int[] arr, int c){ 
		int left = 1; //가능한 최소 간격
		int right = arr[arr.length - 1] - arr[0]; //가능한 최대 간격
		int d = 0; //공유기 간 간격
		int result = 0;
		
		while (left <= right){
	        int mid = (left + right) / 2; //기준
	        int start = arr[0]; //설치 기준점
	        int count = 1; //공유기 수
	        
	        //간격 기준으로 공유기 설치
	        for(int i = 1; i < arr.length; i++) {
	        	d = arr[i] - start; //인접한 집 사이의 간격
	        	
	        	if(mid <= d) { //기준이 실제 거리보다 가까울시 
	        		count++; //공유기 설치
	        		start = arr[i]; //설치 기준점 갱신
	        	}
	        }
	        
	        //이분 탐색
	        if(count < c) { //공유기가 주어진 수보다 적으면
	            right = mid - 1; //간격 줄이기
	        } else if(count >= c) { //많거나 같으면
	        	result = mid;
	            left = mid + 1; //간격 넒히기
	        }
	    }
		return result;
	}

}