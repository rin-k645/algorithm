package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_��ġ�°ǽȾ� {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); //�迭�� ����
		int K = Integer.parseInt(st.nextToken()); //������ ���� ������ ����
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//����
		int[] count = new int[1000001]; //���Һ� ���� ����
		int right = 0;
		int max = 0; //����: ���� ���� �κ� ������ ����
		
		for(int left = 0; left < N; left++) { //������ �ϳ��� �ű�
			while(right < N && count[arr[right]] < K) { //K�� �̸��϶����� ���������� �ű�
				count[arr[right]]++;
				right++;
			}
			
			max = Math.max(max, right - left); //�ִ� ����
			count[arr[left]]--; //���� ������ �� ���ֱ�
		}
		
		System.out.println(max);
	}

}