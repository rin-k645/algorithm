package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_���ִ������ض� {
	static int N, M, T;
	static int[][] graph;
	static boolean[][][] visited;
	static int[] dx = {-1, 1, 0, 0}; //��,��,��,��
	static int[] dy = {0, 0, -1, 1};
	
	static class Point {
		int x, y; //��, �� ��ǥ
		boolean gram; //�׶� �ִ���
		
		Point(int x, int y, boolean gram) {
			this.x = x;
			this.y = y;
			this.gram = gram;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); //��
		M = Integer.parseInt(st.nextToken()); //��
		T = Integer.parseInt(st.nextToken()); //���� �ð�
		
		graph = new int[N][M]; //��
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][M][2]; //0 : �׶�x�� �湮, 1 : �׶����� �湮
		
		String answer = bfs(0, 0); //0, 0���� Ž�� ����
		
		System.out.println(answer);
	}

	private static String bfs(int i, int j) {
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(new Point(i, j, false));
		visited[i][j][0] = true;
		
		int count = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int s = 0; s < size; s++) {
				Point point = queue.poll();
				
				//���� ����
				if(point.x == N - 1 && point.y == M - 1) {
					return Integer.toString(count);
				}
				
				if(count > T) {
					return "Fail";
				}
				
				//��� Ž��
				for(int d = 0; d < 4; d++) {
					int nx = point.x + dx[d];
					int ny = point.y + dy[d];
					
					if(0 <= nx && nx < N && 0 <= ny && ny < M) {
						if(graph[nx][ny] == 0) {
							//�����
							if(!point.gram && !visited[nx][ny][0]) { //�׶� ����
								queue.add(new Point(nx, ny, point.gram));
								visited[nx][ny][0] = true;
							} else if(point.gram && !visited[nx][ny][1]) { //�׶� ����
								queue.add(new Point(nx, ny, point.gram));
								visited[nx][ny][1] = true;
							}
						} else if(graph[nx][ny] == 1 && point.gram) {
							//�������� �׶� ����
							if(!visited[nx][ny][1]) {
								queue.add(new Point(nx, ny, point.gram));
								visited[nx][ny][1] = true;
							}
						} else if(graph[nx][ny] == 2) {
							//�׶� �ֿ�
							if(!visited[nx][ny][1]) { 
								queue.add(new Point(nx, ny, true));
								visited[nx][ny][1] = true;
							}
						}
					}
				}
			}
			count++;
		}
		
		return "Fail";
	}

}
