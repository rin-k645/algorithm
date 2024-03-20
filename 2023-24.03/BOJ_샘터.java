package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_���� {
	static int[] dx = {-1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N]; //���� ��ġ ����
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(bfs(arr, K));
	}

	public static long bfs(int[] arr, int k) {
		Queue<Integer> queue = new LinkedList<>(); //Ž���� ���� ť
		HashSet<Integer> visited = new HashSet<>(); //���� �ִ��� ����
		
		for(int water : arr) { //���� ��ġ�� ť�� ����
			queue.add(water);
			visited.add(water);
		}
		
		int house = 0; //���� ���� ����
		long sum = 0; //���൵ ��
		int dist = 1; //�Ÿ�
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int s = 0; s < size; s++) { //�Ÿ����� ��� Ž��
				int x = queue.poll();
				
				for(int d = 0; d < 2; d++) {
					int nx = x + dx[d];
					
					if(!visited.contains(nx)) { //���� ����
						queue.add(nx);
						visited.add(nx);
						house++;
						sum += dist;
						
						if(house == k) return sum; //k�� ��ŭ �� ����
					}
				}
			}
			dist++; //�Ÿ� ����
		}
		return sum;
	}

}
