import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static class Cabbage {
		int x;
		int y;
		
		public Cabbage(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());

		for(int i = 0; i < T; i++) {
			String[] input = br.readLine().split(" ");
			M = Integer.parseInt(input[0]);
			N = Integer.parseInt(input[1]);
			int K = Integer.parseInt(input[2]);
			
			graph = new int[N][M];
			visited = new boolean[N][M];
			
			for(int j = 0; j < K; j++) {
				String[] vertex = br.readLine().split(" ");
				int X = Integer.parseInt(vertex[0]);
				int Y = Integer.parseInt(vertex[1]);
				
				graph[Y][X] = 1;
			}
			
			int count = 0;
			for(int a = 0; a < N; a++) {
				for(int b = 0; b < M; b++) {
					if(graph[a][b] == 1 && !visited[a][b]) { //배추가 있고 방문x
						bfs(a, b);
						count++;
					}
				}
			}

			
			bw.write(count + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void bfs(int a, int b) {
		Queue<Cabbage> queue = new LinkedList<Cabbage>();
		
		queue.add(new Cabbage(a, b));
		
		while(!queue.isEmpty()) {
			Cabbage cabbage = queue.poll();
			visited[cabbage.x][cabbage.y] = true;
			
			for(int i = 0; i < 4; i++) { //상하좌우 탐색
				int nx = cabbage.x + dx[i];
				int ny = cabbage.y + dy[i];
				
				if(0 <= nx && nx < N && 0 <= ny && ny < M) { //좌표범위 안에 있고
					if(graph[nx][ny] == 1 && !visited[nx][ny]) {
						queue.add(new Cabbage(nx, ny));
						visited[nx][ny] = true;
					}
				}
			}
		}
	}

}