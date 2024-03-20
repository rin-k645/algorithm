package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_PuyoPuyo {
	static final int H = 12;
	static final int W = 6;
	static char[][] graph;
	static boolean[][] visited;
	static int dx[] = {1, -1, 0, 0}; //�����¿�
    static int dy[] = {0, 0, 1, -1};
    static Queue<Point> queue2; //���ӵ� ��� ��� ť
    
    static class Point { //��ǥ
		int x, y; //��, ��
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		graph = new char[H][W]; //�ʵ�
		
		for(int i = 0; i < H; i++) {
			String line = br.readLine();
			
			for(int j = 0; j < W; j++) {
				graph[i][j] = line.charAt(j);
			}
		}
		
		//����
		int answer = 0; //���
		
		while(true) {
			visited = new boolean[H][W];
			
			//���� �׷� ���ÿ� ��Ʈ����
			boolean isBroken = false;
			
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(!visited[i][j] && graph[i][j] != '.') { //������ ���
						//����� ���� �� �ѿ� ã�Ƽ�
						queue2 = new LinkedList<>();
						bfs(i, j, graph[i][j]);
						
						//4���̻��̸� ���ֱ�
						if(queue2.size() >= 4) {
							remove();
							isBroken = true;
						}
					}
				}
			}
			
			//�ϳ��� ������ �ʴ´ٸ� �ߴ�
			if(!isBroken) {
				break;
			}
			
			//������
			down();
			
			answer++;
		}
		
		//���
		System.out.println(answer);
	}

	public static void bfs(int i, int j, char color) {
		Queue<Point> queue1 = new LinkedList<>();
		
		queue1.add(new Point(i, j));
		queue2.add(new Point(i, j));
		visited[i][j] = true;
		
		while(!queue1.isEmpty()) {
			Point point = queue1.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = point.x + dx[d];
				int ny = point.y + dy[d];
				
				if(0 <= nx && nx < H && 0 <= ny && ny < W) {
					if(!visited[nx][ny] && graph[nx][ny] == color) {
						queue1.add(new Point(nx, ny));
						queue2.add(new Point(nx, ny));
						visited[nx][ny] = true;
					}
				}
			}
		}
	}
	
	public static void remove() {
		for(Point point : queue2) {
			graph[point.x][point.y] = '.';
		}
	}
	
	public static void down() {
		for(int i = 0; i < W; i++) { //�����ٸ��� Ȯ��
			for(int j = H - 2; j >= 0; j--) {
				if(graph[j][i] != '.') { //���ڸ�
					int idx = j;
					
					while(true) { //���ڸ��������� or �ٴڱ��� ������
						idx++;
						if(idx == H || graph[idx][i] != '.') {
							char tmp = graph[j][i];
							graph[j][i] = graph[idx - 1][i];
							graph[idx - 1][i] = tmp;
							
							break;
						}
					}
				}
			}
		}
	}

}
