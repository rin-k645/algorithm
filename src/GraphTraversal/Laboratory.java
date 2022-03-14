package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Laboratory {
	static int N;
	static int M;
	static int[][] graph;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static class Virus {
		int x;
		int y;
		
		public Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		graph = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String[] row = br.readLine().split(" ");
			
			for(int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(row[j]);
			}
		}
		
		//안전 영역 개수 구하기
				int count2 = 0;
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						if(graph[i][j] == 0) {
							count2++;
						}
					}
				}
				
				System.out.println(count2);
		
		bfs();
		
		//안전 영역 개수 구하기
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(graph[i][j] == 0) {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}

	public static void bfs() {
		Queue<Virus> queue = new LinkedList<Virus>();
		
		for(int i = 0; i < N; i++) { //바이러스 있으면 큐에 넣기
			for(int j = 0; j < M; j++) {
				if(graph[i][j] == 2)
					queue.add(new Virus(i, j));
			}
		}
		
		while(!queue.isEmpty()) {
			Virus virus = queue.poll();
			
			if(graph[virus.x][virus.y] == 1) { //벽에 막힘
				break;
			}
			
			for(int i = 0; i < 4; i++) { //상하좌우 탐색
				int nx = virus.x + dx[i];
				int ny = virus.y + dy[i];
				
				if(0 <= nx && nx < N && 0 <= ny && ny < M) { //좌표 범위 안에 있고
					if(graph[nx][ny] == 0) { //안전 영역이면
						graph[nx][ny] = 2; //감염시키고
						queue.add(new Virus(nx, ny)); //큐에 넣음
					}
				}
			}
		}
	}

}
