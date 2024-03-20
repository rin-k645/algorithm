package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2234 {
	static int N, M;
	static int[][] map; //���� ����
	static boolean[][] visited; //�湮 ����
	static int[] dx = {0, -1, 0, 1}; //��, ��, ��, ��
	static int[] dy = {-1, 0, 1, 0};
	
	static class Room {
		int x, y;
		
		public Room(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); //��
		M = Integer.parseInt(st.nextToken()); //��
		
		map = new int[M][N];
		
		for(int i = 0; i < M; i++) { //�� ���� �Է�
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//ó��
		visited = new boolean[M][N];
		int num_room = 0; //1. �� ���� �ִ� ���� ����
		int max_area1 = 0; //2. ���� ���� ���� ����
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					max_area1 = Math.max(max_area1, bfs(i, j));
					num_room++;
				}
			}
		}
		
		//3. �ϳ��� ���� �����Ͽ� ���� �� �ִ� ���� ���� ���� ũ��
		int max_area2 = 0;
		for(int i = 0; i < M; i++) { //��� ��ǥ��
			for(int j = 0; j < N; j++) {
				for(int d = 0; d < 4; d++) { //��濡 ���� Ž��
					visited = new boolean[M][N]; //�ʱ�ȭ
					
					if((map[i][j] & (1 << d)) == 1) { //���� ������
						map[i][j] -= (1 << d); //�� �����ϱ�
						max_area2 = Math.max(max_area2, bfs(i, j)); //�� ��ǥ���� bfs ������(= �� ���� �����ٸ� ���� �� �ִ� �� ���� ��ȯ)
						map[i][j] += (1 << d); //�� ���� ����
					}
				}
			}
		}
		
		//���
		System.out.println(num_room);
		System.out.println(max_area1);
		System.out.println(max_area2);
	}

	public static int bfs(int i, int j) {
		Queue<Room> queue = new LinkedList<>();
		int area = 1;
		
		queue.add(new Room(i, j));
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			Room room = queue.poll();
			
			for(int d = 0; d < 4; d++) { //4�� Ž��
				int nx = room.x + dx[d];
				int ny = room.y + dy[d];
				
				if(0 <= nx && nx < M && 0 <= ny && ny < N) { //���� �ȿ� �ְ�
					if((map[room.x][room.y] & (1 << d)) == 0 && !visited[nx][ny]) { //��X, �湮����X
						queue.add(new Room(nx, ny));
						visited[nx][ny] = true;
						area++;
					}
				}
			}
		}
		
		return area;
	}
}
