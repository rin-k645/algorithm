package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_���ѱ� {
	static int N;
	static Room[][] graph;
	static boolean[][] isOn; //���� �����ִ���
	static boolean[][] visited; //����ġ Ű�� �湮 ����
	static boolean[][] canMove; //�̵��� �� �ִ� ��
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	
	static class Room {
		List<Point> list; //����� ����ġ ��ǥ ����Ʈ
		
		Room(List<Point> list) {
			this.list = list;
		}
	}
	
	static class Point { //��ǥ
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new Room[N + 1][N + 1];
		for(int i = 1; i <= N; i++) { //����Ʈ �ʱ�ȭ
			for(int j = 1; j <= N; j++) {
				graph[i][j] = new Room(new ArrayList<>());
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[x][y].list.add(new Point(a, b)); //�濡 �ִ� ����ġ ����
		}
		
		isOn = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];
		canMove = new boolean[N + 1][N + 1];
		
		bfs(1, 1); //��������� Ž�� ����
		
		int count = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(isOn[i][j]) {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}

	public static void bfs(int i, int j) {
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(new Point(i, j));
		isOn[i][j] = true;
		visited[i][j] = true;
		canMove[i][j] = true;
		
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			
			for(Point p : graph[point.x][point.y].list) { //����� �� ��
				if(!isOn[p.x][p.y]) { //�� ���� ������
					isOn[p.x][p.y] = true; //�ѱ�
				}
				
				//���ۿ� �������� ���߿� �� �� �ִ� ���� �湮���ֱ�
				if(canMove[p.x][p.y] && !visited[p.x][p.y]) { //�̵� ����, �湮x
					queue.add(new Point(p.x, p.y));
					visited[p.x][p.y] = true;
				}
			}
			
			for(int d = 0; d < 4; d++) {//������� �̵� 
				int nx = point.x + dx[d];
				int ny = point.y + dy[d];
				
				if(1 <= nx && nx <= N && 1 <= ny && ny <= N) { //���� ��
					canMove[nx][ny] = true; //������ �� �ִ� �� ǥ��
					
					if(isOn[nx][ny] && !visited[nx][ny]) { //���� ����, �湮x
						queue.add(new Point(nx, ny));
						visited[nx][ny] = true;
					}
				}
			}
		}
	}

}
