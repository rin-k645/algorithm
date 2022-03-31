package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WeightLimits {
	static List<Island>[] list;
	static boolean[] visited;
	static boolean possible;
	
	static class Island {
		int destination;
		int weight;
		
		public Island(int destination, int weight) {
			this.destination = destination;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input1 = br.readLine().split(" ");
		int N = Integer.parseInt(input1[0]);
		int M = Integer.parseInt(input1[1]);
		
		list = new ArrayList[N + 1];
		
		for(int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}
		
		int low = 0; //�߷��� �ּ�
		int high = 0; //�߷��� �ִ�(�ʱ�ȭ)
		for(int i =0; i < M; i++) {
			String[] input2 = br.readLine().split(" ");
			int A = Integer.parseInt(input2[0]);
			int B = Integer.parseInt(input2[1]);
			int C = Integer.parseInt(input2[2]);
			
			list[A].add(new Island(B, C));
			list[B].add(new Island(A, C));
			
			high = Math.max(high, C); //�߷� �ִ� ���ϱ�
		}
		
		String[] input3 = br.readLine().split(" ");
		int factory1 = Integer.parseInt(input3[0]);
		int factory2 = Integer.parseInt(input3[1]);
		
		int answer = 0;
		while(low <= high) {
			int mid = (low + high) / 2;
			possible = false;
			visited = new boolean[N + 1];
			
			dfs(factory1, factory2, mid);
			
			if(possible) { //�ű� �� ������
				low = mid + 1; //�߷� �ø���
				answer = mid;
			} else { //�Ұ����ϸ�
				high = mid - 1; //�߷� ������
			}
		}
		
		System.out.println(answer);
	}

	public static void dfs(int pos, int target, int weight) {
		if(pos == target) { //�ش� �߷����� �ű�� ����
			possible = true;
			return;
		}
		
		visited[pos] = true;
		for(Island island : list[pos]) {
			if(!visited[island.destination] && weight <= island.weight) { //�湮x, ����� ������ �߷��̸�
				dfs(island.destination, target, weight); //��� Ž��
			}
		}
	}

}
