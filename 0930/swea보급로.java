import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class swea보급로 {
	static int N;
	static int[][] graph;
	static boolean[][] visited;
	static int[][] dist;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static class Dot implements Comparable<Dot> {
		int x, y, time;

		public Dot(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public int compareTo(Dot o) {
			return this.time - o.time;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); //테스트 케이스의 개수
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			graph = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String input = br.readLine();
				
				for(int j = 0; j < N; j++) {
					graph[i][j] = input.charAt(j) - '0';				
				}
			}
			
			//구현
			visited = new boolean[N][N];
			
			dist = new int[N][N];
			for(int d[] : dist) { //거리 무한으로 초기화
				Arrays.fill(d, Integer.MAX_VALUE);
			}
			
			dijkstra(); //다익스트라
			
			//출력
			System.out.println("#" +  t + " " + dist[N-1][N-1]);
		}
	}

	public static void dijkstra() {
		PriorityQueue<Dot> queue = new PriorityQueue<>();
		
		queue.add(new Dot(0, 0, graph[0][0])); //시작 좌표
		dist[0][0] = graph[0][0];
		
		while(!queue.isEmpty()) {
			Dot dot = queue.poll();
			
			if(dot.x == N - 1 && dot.y == N - 1) { //종료 조건
				return;
			}
			
			if(visited[dot.x][dot.y]) continue;
			
			visited[dot.x][dot.y] = true;
			
			for(int i = 0; i < 4; i++) {
				int nx = dot.x + dx[i];
				int ny = dot.y + dy[i];
				
				if(0 <= nx && nx < N && 0 <= ny && ny < N) {
					if(dist[dot.x][dot.y] + graph[nx][ny] < dist[nx][ny]) { //더 최소인 곳이 있으면
						dist[nx][ny] = dist[dot.x][dot.y] + graph[nx][ny];
						queue.add(new Dot(nx, ny, dist[nx][ny]));
					}
				}
			}
		}
	}
	
}
