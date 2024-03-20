package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_�������� {
	static int N, M;
	static int[][] graph;
	static boolean[][] visited;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for(int j = 0; j < M; j++) {
				graph[i][j] = line.charAt(j) - '0';
			}
		}
		
		visited = new boolean[N][M];
		max = 0;
		
		dfs(0, 0); //0, 0���� ����
		
		System.out.println(max);
	}

	public static void dfs(int i, int j) {
		if(j == M) { //���� ���� ����
			j = 0; //0���� �ʱ�ȭ
			i++; //�� ����
		}
		
		if(i == N) { //�� �ڸ�
			//�� ��� �� ����
			max = Math.max(max, getSum());
			return;
		}
		
		visited[i][j] = true;
		dfs(i, j + 1);
		visited[i][j] = false;
		dfs(i, j + 1);
	}

	private static int getSum() { //�� ���
		int sum = 0;
		
		//���η� �ڸ���
		for(int i = 0; i < N; i++) {
			int tmp = 0;
			for(int j = 0; j < M; j++) {
				if(visited[i][j]) {
					tmp = 10 * tmp + graph[i][j];
				} else {
					sum += tmp;
					tmp = 0;
				}
			}
			sum += tmp;
		}
		
		//���η� �ڸ���
		for(int i = 0; i < M; i++) {
			int tmp = 0;
			for(int j = 0; j < N; j++) {
				if(!visited[j][i]) {
					tmp = 10 * tmp + graph[j][i];
				} else {
					sum += tmp;
					tmp = 0;
				}
			}
			sum += tmp;
		}
		
		return sum;
	}
	
}
