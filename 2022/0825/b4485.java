import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b4485 {
	static int N;
	static int[][] graph;
	static boolean[][] visited;
	static int[][] dist;
	static int[] dx = {-1, 1, 0, 0}; //상하좌우
	static int[] dy = {0, 0, -1, 1};
	
	static class Dot implements Comparable<Dot> {
		int x, y, cost;

		public Dot(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Dot o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = 1;
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			
			if(N == 0) break; //테스트 케이스 종료
			
			graph = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for(int j = 0; j < N; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
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
			System.out.println("Problem " + tc + ": " + dist[N-1][N-1]);
			
			tc++;
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
			
			for(int i = 0; i < 4; i++) { //상하좌우 탐색
				int nx = dot.x + dx[i];
				int ny = dot.y + dy[i];
				
				if(0 <= nx && nx < N && 0 <= ny && ny < N) { //그래프 안에 있고
					if(dist[dot.x][dot.y] + graph[nx][ny] < dist[nx][ny]) { //더 최소인 곳이 있으면
						dist[nx][ny] = dist[dot.x][dot.y] + graph[nx][ny];
						queue.add(new Dot(nx, ny, dist[nx][ny]));
					}
				}
			}
		}
	}

}
