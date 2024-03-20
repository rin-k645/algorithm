import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Dot {
		int r, c;

		public Dot(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//구현
		int num = 1; //섬 번호
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(graph[i][j] == 1 && !visited[i][j]) {
					bfs(i,j, num); //섬 영역 구해서 번호 붙이기
					num++;
				}
			}
		}
		
		print();/////////
		
		//섬들 사이 연결하기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				//
			}
		}
		
		//프림 알고리즘으로 MST 찾기
		
		
		//출력
		
	}

	private static void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void bfs(int r, int c, int num) {
		Queue<Dot> queue = new LinkedList<>();
		
		queue.add(new Dot(r, c));
		graph[r][c] = num;
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			Dot dot = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr =  dot.r + dr[i];
				int nc =  dot.c + dc[i];
				
				if(0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc]) {
					if(graph[nr][nc] == 1) {
						queue.add(new Dot(nr, nc));
						graph[nr][nc] = num;
						visited[nr][nc] = true;
					}
				}
			}
		}
	}
	
}
