import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] index = new int[8001];
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		
		//평균
		int average = (int) Math.round((double)sum / N);
		
		//중앙값
		int median = arr[N / 2];
		
		//최빈값
		for (int i = 0; i < arr.length; i++) {
            index[arr[i] + 4000]++;      
        }
		
		int max = Integer.MIN_VALUE;
		int mode = 0;
		boolean flag = false;
        for (int i = 0; i < index.length; i++){
            if(max < index[i]){
                max = index[i];
                mode = i - 4000;
                flag = true;
            }
            else if(max == index[i] && flag == true) {
                 mode = i - 4000;
                 flag = false;
            }
        }      
		
		//범위
		int range = arr[N - 1] - arr[0];
		
		//출력
		System.out.println(average);
		System.out.println(median);
		System.out.println(mode);
		System.out.println(range);
		
	}

}