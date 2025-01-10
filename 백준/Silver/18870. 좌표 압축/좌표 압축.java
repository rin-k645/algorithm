import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(st.nextToken());
			arr[i][0] = i; //인덱스
			arr[i][1] = x; //좌표
		}
		
		Arrays.sort(arr, (o1, o2) -> o1[1] - o2[1]); //좌표 오름차순 정렬
		
		
		int[][] answer = new int[N][2];
		
		int count = -1; //앞에 몇 개 있는지
		int pre = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			int idx = arr[i][0];
			int value = arr[i][1];
			
			if(value != pre) count++;
			
			answer[i][0] = idx;
			answer[i][1] = count;
			
			pre = value;
		}
		
		Arrays.sort(answer, (o1, o2) -> o1[0] - o2[0]); //인덱스 오름차순 정렬
		
		StringBuilder sb = new StringBuilder();
		for(int[] a : answer) {
			int c = a[1];
			sb.append(c + " ");
		}
		
		System.out.println(sb);
	}

}