package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_�ҹ���ĥ���� {
	static char[][] graph;
	static int[] result;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		graph = new char[5][5];
		
		for(int i = 0; i < 5; i++) {
			char[] chs = br.readLine().toCharArray();
			
			for(int j = 0; j < 5; j++) {
				graph[i][j] = chs[j];
			}
		}
		
		result = new int[7]; //���� ��� ����
		answer = 0;
		
		combination(0, 0, 0);
		
		System.out.println(answer);
	}

	public static void combination(int start, int depth, int y) {
		if(y > 3) return; //����ġ�� : �ӵ����� 3�� �ʰ�
		
		if(depth == 7) { //7�� �� ����
			if(isPossible()) answer++; //�������ִ��� Ȯ��
			return;
		}
		
		for(int i = start; i < 25; i++) {
			result[depth] = i;
			
			int newY = y;
			if(graph[i / 5][i % 5] == 'Y') newY = y + 1;
			
			combination(i + 1, depth + 1, newY);
		}
	}

	public static boolean isPossible() { //BFS�� Ž��
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[7];
		
		queue.add(result[0]);
		visited[0] = true;
		
		int count = 1; //�������ִ� �л� ��
		while(!queue.isEmpty()) {
			int num = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = num / 5 + dx[i];
				int ny = num % 5 + dy[i];
				
				if(0 > nx || nx >= 5 || 0 > ny || ny >= 5) continue;
				
				int next = nx * 5 + ny;
				
				for(int j = 0; j < 7; j++) {
					if(!visited[j] && result[j] == next) { //�湮X, ĥ�����Ŀ� ����
						queue.add(result[j]);
						visited[j] = true;
						count++;
					}
				}
			}
		}
		
		if(count == 7) return true;
		return false;
	}

}
