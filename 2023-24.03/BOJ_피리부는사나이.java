package algorithm;

import java.util.*;
import java.io.*;

public class BOJ_�Ǹ��δ»糪�� {
	static int N, M;
	static char[][] graph;
	static int[][] visited;
	static int[] dx = {-1, 1, 0, 0}; //U, D, L, R
	static int[] dy = {0, 0, -1, 1};
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(),  " ");

		N = Integer.parseInt(st.nextToken()); //���� ��
		M = Integer.parseInt(st.nextToken()); //���� ��
		
		graph = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			char[] chArr = br.readLine().toCharArray();
			
			for(int j = 0; j < M; j++) {
				graph[i][j] = chArr[j];
			}
		}
		
		//Ž��
		visited = new int[N][M]; //�湮 ǥ�� : 0(�湮X), 1�̻�(�湮O)
		count = 0; //���� : SAFE ZONE�� �ּ� ����
		int idx = 0; //Ž�� �ε���
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(visited[i][j] == 0) { //�湮�� �� ������
					dfs(i, j, ++idx); //Ž��
				}
			}
		}
		
		//���
		System.out.println(count);
	}

	public static void dfs(int x, int y, int idx) {
		visited[x][y] = idx;
		
		int nx = x; //���� �̵� ��
		int ny = y; //���� �̵� ��
		
		switch(graph[x][y]) {
			case 'U' :
				nx += dx[0];
				ny += dy[0];
				break;
			case 'D' :
				nx += dx[1];
				ny += dy[1];
				break;
			case 'L' :
				nx += dx[2];
				ny += dy[2];
				break;
			case 'R' :
				nx += dx[3];
				ny += dy[3];
				break;
		}
		
		if(0 <= nx && nx < N && 0 <= ny && ny < M) {
			if(visited[nx][ny] == 0) { //�湮�� �� ����
				dfs(nx, ny, idx);
			} else { //�湮�� �� ����
				if(visited[nx][ny] == idx) { //����Ŭ ���� �ϼ�
					count++;
					return;
				}
				//������ �ε����� �ٸ�(=������ ���� ����Ŭ)
				//���
			}
		}
	}

}
