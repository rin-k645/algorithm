package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_�˰���2 {
	static int N, M;
	static char[][] graph;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int count = 0;
	
	static class Point {
		int x, y, hit;
		
		Point(int x, int y, int hit) {
			this.x = x;
			this.y = y;
			this.hit = hit;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); //���� ũ��
		N = Integer.parseInt(st.nextToken()); //���� ũ��
		
		graph = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for(int j = 0; j < M; j++) {
				graph[i][j] = line.charAt(j);
			}
		}
		
		visited = new boolean[N][M];
		
		System.out.println(bfs(0, 0));
		System.out.println("ȣ�� ī��Ʈ: " + count);
	}

	public static int bfs(int i, int j) {
		Queue<Point> queue = new PriorityQueue<>((o1, o2) -> o1.hit - o2.hit);
		
		queue.add(new Point(i, j, 0));
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			
			if(point.x == N - 1 && point.y == M - 1) {
				return point.hit;
			}
			
			for(int d = 0; d < 4; d++) {
				int nx = point.x + dx[d];
				int ny = point.y + dy[d];
				
				if(0 > nx || nx >= N || 0 > ny || ny >= M) continue; //�̷� ��
				
				if(graph[nx][ny] == '0' && !visited[nx][ny]) { //�� ��
					queue.add(new Point(nx, ny, point.hit));
					visited[nx][ny] = true;
					System.out.println(nx + " " + ny + ", hit : " + point.hit +  " Ž��");
					count++;
				} else if(graph[nx][ny] == '1' && !visited[nx][ny]) { //��
					queue.add(new Point(nx, ny, point.hit + 1));
					visited[nx][ny] = true;
					System.out.println(nx + " " + ny + ", hit : " + (point.hit+1) +  " Ž��");
					count++;			
				}
			}
		}
		
		return 0;
	}

}
