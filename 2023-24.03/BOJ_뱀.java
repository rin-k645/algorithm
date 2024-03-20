package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_�� {
	static int N;
	static boolean[][] graph;
	static Deque<Point> snake;
	static int[] dx =  {0, 1, 0, -1}; //�����»�
	static int[] dy =  {1, 0, -1, 0};
	
	static class Point {
		int x, y, dir;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		graph = new boolean[N][N];
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph[x - 1][y - 1] = true;
		}
		
		int L = Integer.parseInt(br.readLine());
		
		HashMap<Integer, Character> orderMap = new HashMap<>(); //��ɾ� ����
		
		for(int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int X = Integer.parseInt(st.nextToken());
			char C = st.nextToken().charAt(0);
			
			orderMap.put(X, C);
		}

		snake = new LinkedList<>(); //���� ��
		snake.add(new Point(0, 0)); //���� ���������� ����
		int dir = 0; //���� 
		
		int answer = 0; //�ð�
		while(true) {
			answer++;
			
			//����ĭ�� ��ġ
			Point point = snake.peek();
			int nx = point.x + dx[dir];
			int ny = point.y + dy[dir];
			
			if(isHit(nx, ny)) break;
			
			snake.addFirst(new Point(nx, ny));
			
			if(graph[nx][ny]) { //�������
				graph[nx][ny] = false; //��� ������
			} else { //������
				snake.pollLast(); //����ĭ �����
			}
			
			//���� ��ȯ
			if(orderMap.containsKey(answer)) {
				char order = orderMap.get(answer);
				
				if(order == 'L') { //����
					if(dir == 0) {
						dir = 3;
					} else {
						dir--;
					}
				} else { //������
					if(dir == 3) {
						dir = 0;
					} else {
						dir++;
					}
				}
			}
		}

		System.out.println(answer);
	}
	
	public static boolean isHit(int nx, int ny) {
		if(0 > nx || nx >= N || 0 > ny || ny >= N) {
			return true;
		}
		
		for(Point p : snake) {
			if(nx == p.x && ny == p.y)  {
				return true;
			}
		}
		
		return false;
	}

}
