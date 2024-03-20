package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_������� {
	static int N, M;
	static int[][] graph;
	static boolean[][] visited;
	//��, ��, ��, ��
	//[][0]�� �θ޶��� �߽�
	static int[][] dx = {{0, 0, 1}, {0, 0, -1}, {0, -1, 0}, {0, 1, 0}};
	static int[][] dy = {{0, -1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, 1}};

	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); //�� ũ��
		M = Integer.parseInt(st.nextToken()); //�� ũ��
		
		graph = new int[N][M]; //���� ����� ũ��
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//����
		visited = new boolean[N][M]; //�湮üũ
		max = 0; //���� : �ִ�
		
		dfs(0, 0, 0); //0, 0���� Ž�� ����
		
		//���
		System.out.println(max);
		
	}
	
	public static void dfs(int x, int y, int sum) { //��, ��, ������ ��  
		if(x == N && y == M) { //Ž�� ����
			max = Math.max(max, sum); //�ִ� ����
			return;
		}
		
		if(y == M) { //���� ������ ������
			y = 0; //�ʱ�ȭ
			x++; //�� ��ǥ �ø���
		}
		
		for(int d = 0; d < 4; d++) { //4���� ������� Ž��
			int n = getPower(x, y, d); //�ش� ��, ��, ������� ���� �� �ִ� ���� ���ϱ�
			
			if(n > 0) { //�����ϸ�
				markVisited(x, y, d, true); //�湮 üũ
				dfs(x, y + 1, sum + n); //Ž��
				markVisited(x, y, d, false); //�湮 ����
			}
		}
		
		dfs(x, y + 1, sum); //�ش� ��ǥ���� ���� �ʰ� Ž��
	}

	private static int getPower(int x, int y, int d) {
		int sum = 0; //������ ��
		
		for(int i = 0; i < 3; i++) { //3ĭ ã��
			int nx = x + dx[d][i];
			int ny = y + dy[d][i];
			
			//���� �ȿ� ���, �湮x
			if(0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny]) {
				int value = graph[nx][ny];
				if(i == 0) { //�߽� ĭ
					value *= 2;
				}
				
				sum += value;
			} else { //���� �� ����
				return 0; //����
			}
		}
		
		return sum;
	}

	public static void markVisited(int x, int y, int d, boolean b) {
		for(int i = 0; i < 3; i++) {
			int nx = x + dx[d][i];
			int ny = y + dy[d][i];
			
			visited[nx][ny] = b;
		}
	}

}
