import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b7576 {
	static int M, N;
	static int[][] graph;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int day = 0;
	
	static class Tomato {
		int x;
		int y;
		int day;
		
		public Tomato(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer sb = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(sb.nextToken());
		N = Integer.parseInt(sb.nextToken());
		
		graph = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			sb = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(sb.nextToken());
			}
		}
		
		bfs();
		
		//출력
		int answer = day;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(graph[i][j] == 0) { //안익은 토마토 있으면
					answer =  -1;
				}
			}
		}
		
		System.out.println(answer);
	}
	
	public static void bfs() {
		Queue<Tomato> queue = new LinkedList<Tomato>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(graph[i][j] == 1) { //토마토 있으면 
					queue.add(new Tomato(i, j, 0)); //큐에 넣기
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Tomato tomato = queue.poll();
			day = tomato.day;
			
			for(int i = 0; i < 4; i++) {
				int nx = tomato.x + dx[i];
				int ny = tomato.y + dy[i];
				
				if(0 <= nx && nx < N && 0 <= ny && ny < M) {
					if(graph[nx][ny] == 0) { //안익었으면
						graph[nx][ny] = 1; //익히기
						queue.add(new Tomato(nx, ny, day + 1));
					}
				}
			}
		}
		
	}

}
