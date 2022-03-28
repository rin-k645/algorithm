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
		
		Arrays.sort(tree); //�̺� Ž���� ���� ����
		
		int answer = 0;
		int low = 0; //H �ּ�
		int high = tree[tree.length - 1]; //H �ִ�(���� ū ����)
		
		while(low <= high) {
			int mid = (low + high) / 2;
			
			long sum = 0;
			for(int i = 0; i < N; i++) {
				if(tree[i] > mid) { //�����ϰ� ������
					sum += (tree[i] - mid); //��� ����
				}
			}
			
			if(sum < M) { //M���� �� ���� ���� ��������
        		high = mid - 1; //H ���̱�
        	} else { //M���� �� ���� ���� ��������
        		low = mid + 1; //H �ø���
        		answer = mid;
        	}
		}
		
		System.out.println(answer);
	}

}
