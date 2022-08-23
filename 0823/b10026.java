import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b10026 {
	static int N;
	static char[][] graph;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());

		graph = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for(int j = 0; j < N; j++) {
				graph[i][j] = line.charAt(j);
			}
		}
		
		//적록색약이 아닌 사람
		visited = new boolean[N][N];
		
		int count1 = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(graph[i][j] == 'R' && !visited[i][j]) { //빨강이고, 방문x
					bfs(i, j, 'R', false); //탐색 시작
					count1++;
				}else if(graph[i][j] == 'G' && !visited[i][j]) { //초록이고, 방문x
					bfs(i, j, 'G', false); //탐색 시작
					count1++;
				}else if(graph[i][j] == 'B' && !visited[i][j]) { //파랑이고, 방문x
					bfs(i, j, 'B', false); //탐색 시작
					count1++;
				}
			}
		}
		
		//적록색약인 사람
		visited = new boolean[N][N]; //초기화
		
		int count2 = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if((graph[i][j] == 'R' || graph[i][j] == 'G') && !visited[i][j]) { //빨강 또는 초록이고, 방문x
					bfs(i, j, 'R', true); //탐색 시작 - 적록색약이 적용
					count2++;
				}else if(graph[i][j] == 'B' && !visited[i][j]) { //파랑이고, 방문x
					bfs(i, j, 'B', false); //탐색 시작
					count2++;
				}
			}
		}
		
		//출력
		System.out.println(count1 + " " + count2);
	}

	public static void bfs(int x, int y, char color, boolean blind) {
		Queue<Point> queue = new LinkedList<Point>();
		
		queue.add(new Point(x, y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			
			for(int i = 0; i < 4; i++) { //상하좌우 탐색
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];
				
				if(0 <= nx && nx < N && 0 <= ny && ny < N) {
					if(!blind) { //적록색약인 색깔X
						if(graph[nx][ny] == color && !visited[nx][ny]) {
							queue.add(new Point(nx, ny));
							visited[nx][ny] = true;
						}
					}else { //적록색약인 색깔
						if((graph[nx][ny] == 'R' || graph[nx][ny] == 'G') && !visited[nx][ny]) {
							queue.add(new Point(nx, ny));
							visited[nx][ny] = true;
						}
					}
				}
			}
		}
		
	}

}
