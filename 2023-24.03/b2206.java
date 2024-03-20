package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2206 {
	static int N, M;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = {-1, -1, 0, 0}; //��, ��, ��, ��
	static int[] dy = {0, 0, -1, 1};
	
	static class Room {
		int x, y, dist;
		boolean isCrashed;
		
		public Room(int x, int y, int dist, boolean isCrashed) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.isCrashed = isCrashed;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); //��
		M = Integer.parseInt(st.nextToken()); //��
		
		map = new int[N + 1][M + 1]; //��
		
		for(int i = 1; i <= N; i++) { //�� ���� �Է�
			String line = br.readLine();
			for(int j = 1; j <= M; j++) {
				map[i][j] = line.charAt(j - 1) - '0';
			}
		}
		
		visited = new boolean[N + 1][M + 1][2]; //��, ��, �� �Ⱥν��� or �ν���
		int answer = bfs(1, 1); //(1, 1)���� ����
		
		System.out.println(answer);
	}

	public static int bfs(int i, int j) {
		Queue<Room> queue = new LinkedList<>();
		
		queue.add(new Room(i, j, 0, false)); 
		visited[i][j][0] = true;
		
		while(!queue.isEmpty()) {
			Room room = queue.poll();
			
			if(room.x == N && room.y == M) { //���������� ����
				return room.dist;
			}
			
			for(int d = 0; d < 4; d++) { //4�� Ž��
				int nx = room.x + dx[d];
				int ny = room.y + dy[d];
				
				if(1 <= nx && nx <= N && 1 <= ny && ny <= M) { //���� �ȿ� �ְ�
					if(map[nx][ny] == 0) { //���� �ƴ�
						if(!room.isCrashed && !visited[nx][ny][0]) { //�μ���X, �湮����X
							queue.add(new Room(nx, ny, room.dist +1, true));
							visited[nx][ny][0] = true;
						}else if(room.isCrashed && !visited[nx][ny][1]) { //�μ���O, �湮����X
							queue.add(new Room(nx, ny, room.dist +1, true));
							visited[nx][ny][1] = true;
						}
					} else if(map[nx][ny] == 1) { //���� ����
						if(!room.isCrashed) { //�μ���X, �湮����X
							queue.add(new Room(nx, ny, room.dist +1, true));
							visited[nx][ny][1] = true;
						}
					}
				}
			}
		}
		
		return -1; //���� �Ұ���
	}

}
