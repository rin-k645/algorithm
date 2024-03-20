package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_��ü�� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2]; //0: ��ǥ, 1: ��� �� 
		long sum = 0; //��� ����
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			sum += arr[i][1];
		}
		
		Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]); //���� ��ǥ �������� ����
		
		long mid = (sum + 1) / 2; //�߾Ӱ� ����(�ø��� ��)
		
		int answer = 0; //���� : ��ü�� ��ġ
		long total = 0; //���ݱ��� �� ��
		for(int[] a : arr) {
			total += a[1];
			
			if(total >= mid) { //�߾Ӱ� �̻� ã��
				answer = a[0];
				break;
			}
		}
		
		System.out.println(answer);
	}

}
