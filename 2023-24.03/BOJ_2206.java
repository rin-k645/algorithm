package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_2206 {
	static int N, M;
	static int[][] graph;
	static boolean[][][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static class Point {
		int x;
		int y;
		int count;
		boolean hit;
		
		public Point(int x, int y, int count, boolean hit) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.hit = hit;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1][2]; //0 : �� �Ⱥμ�, 1: �� �μ�
		
		for(int i = 1; i <= N; i++) {
			String row = br.readLine();
			
			for(int j = 1; j <= M; j++) {
				graph[i][j] = row.charAt(j - 1) - '0';
			}
		}
		
		int answer = bfs(1, 1);
		
		System.out.println(answer);
	}
	
	public static int bfs(int i, int j) {
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(new Point(i, j, 1, false));
		visited[i][j][0] = true;
		
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			
			if(point.x == N && point.y == M) { // ���� ����
				return point.count;
			}
			
			for(int d = 0; d < 4; d++) {
				int nx = point.x + dx[d];
				int ny = point.y + dy[d];
				
				if(1 <= nx && nx <= N && 1 <= ny && ny <= M) {
					if(graph[nx][ny] == 0) { //�� �ƴ�
						if(!point.hit && !visited[nx][ny][0]) { //�μ��� ����
							queue.add(new Point(nx, ny, point.count + 1, false));
							visited[nx][ny][0] = true;
						} else if(point.hit && !visited[nx][ny][1]) { //�μ��� ����
							queue.add(new Point(nx, ny, point.count + 1, true));
							visited[nx][ny][1] = true;
						}
					}else if(graph[nx][ny] == 1 && !point.hit) { //�� ����, �μ��� ����
						queue.add(new Point(nx, ny, point.count + 1, true)); //�� �μ���
						visited[nx][ny][1] = true;
					}
				}
			}
		}
		
		return -1;
	}

}
