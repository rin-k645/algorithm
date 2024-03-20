package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ����Ż�� {
	static int N, M;
	static char[][] board;
	static boolean[][][][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Point {
		int bx, by, rx, ry; // �Ķ� ��� ��ǥ, ���� ��� ��ǥ
		
		Point() {};

		Point(int bx, int by, int rx, int ry) {
			this.bx = bx;
			this.by = by;
			this.rx = rx;
			this.ry = ry;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new char[N][M];

		Point start = new Point(); // ������ ���� ��ġ

		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();

			// ������ ������ ��ġ ����
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 'R') {
					start.rx = i;
					start.ry = j;
				} else if (board[i][j] == 'B') {
					start.bx = i;
					start.by = j;
				}
			}
		}

		// ó��, ���
		visited = new boolean[N][M][N][M]; // �Ķ�, ����

		System.out.println(bfs(start));
	}

	public static int bfs(Point start) {
		Queue<Point> queue = new LinkedList<>();

		queue.add(start);
		visited[start.bx][start.by][start.rx][start.ry] = true;

		int count = 0;
		while (!queue.isEmpty()) {
			count++;
			
			if (count > 10) { // 10ȸ ������ ����
				return 0;
			}
			
			int size = queue.size();
			for(int s = 0; s < size; s++) {
				Point point = queue.poll();
				
				for (int d = 0; d < 4; d++) {
					int nbx = point.bx;
					int nby = point.by;
					int nrx = point.rx;
					int nry = point.ry;

					// �Ķ� �̵�
					boolean isFail = false; // ���� ����
					boolean isRed = false; // ������ ��������
					while (board[nbx][nby] != '#') { // ���� ��� ������
						nbx += dx[d];
						nby += dy[d];

						if (board[nbx][nby] == 'O') { // ���ۿ� ����
							isFail = true;
							break;
						} else if (nbx == nrx && nby == nry) { // ���� �������� ����
							isRed = true;
						}
					}
					nbx -= dx[d];
					nby -= dy[d];

					//�Ķ��� ���ۿ� �������� �ϴ� �ѱ�(���� Ž������ ã�� ���� �ְ�, ������ �ڿ��� ���� ��ã���� �ߴܵ�)
					if (isFail) {
						continue;
					}

					if (isRed) { //������ �������� �־����Ƿ� ��ĭ �ڷ�
						nbx -= dx[d];
						nby -= dy[d];
					}

					// ���� �̵�
					while (board[nrx][nry] != '#') { // �� ��� ������
						nrx += dx[d];
						nry += dy[d];

						// ����
						if (board[nrx][nry] == 'O') { // ���� ������ ����
							return 1;
						}
					}
					nrx -= dx[d];
					nry -= dy[d];
					
					if (nrx == nbx && nry == nby) { // �Ķ� ������ �ڷ� �̷�
						nrx -= dx[d];
						nry -= dy[d];
					}
					

					if (!visited[nbx][nby][nrx][nry]) { // �湮���� ������ �̵�
						queue.add(new Point(nbx, nby, nrx, nry));
						visited[nbx][nby][nrx][nry] = true;
					}
				}
			}
		}
		return 0;
	}

}
