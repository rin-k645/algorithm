import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int H, W;
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
	
		H = Integer.parseInt(st.nextToken()); //세로
		W = Integer.parseInt(st.nextToken()); //가로
		
		graph = new int[H][W];
		
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j < W; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//구현
		int time = 0;
		int remain = H * W;
		while(true) {
			if(check()) { //다 녹았으면 종료
				break;
			}
			
			//-1인 부분 다시 0으로 복구하기
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(graph[i][j] == -1) {
						graph[i][j] = 0;
					}
				}
			}
			
			visited = new boolean[H][W];
			bfs(); //공기 부분 구별하기
			
			//녹이기 전 남아있는 치즈 조각 구하기
			remain = countPiece();
			
			//공기에 닫는 부분 구해서 녹이기
			melt();
			
			time++;
		}
		
		//출력
		System.out.println(time);
		System.out.println(remain);
	}

	public static boolean check() {
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(graph[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}

	public static void bfs() {
		Queue<Dot> queue = new LinkedList<>();
		
		queue.add(new Dot(0, 0));
		graph[0][0] = -1;
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			Dot dot = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = dot.r + dr[i];
				int nc = dot.c + dc[i];
				
				if(0 <= nr && nr < H && 0 <= nc && nc < W && !visited[nr][nc]) {
					if(graph[nr][nc] == 0) { //치즈가 아니면
						queue.add(new Dot(nr, nc));
						graph[nr][nc] = -1; //공기 부분이다
						visited[nr][nc] = true;
					}
				}
			}
		}
		
	}
	
	public static void melt() {
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(graph[i][j] == 1) { //치즈 조각 발견
					//상하좌우 탐색
					for(int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						
						if(0 <= nr && nr < H && 0 <= nc && nc < W) {
							if(graph[nr][nc] == -1) { //공기에 노출되면
								graph[i][j] = 0; //녹이기
								break;
							}
						}
					}
				}
			}
		}
		
	}
	
	public static int countPiece() {
		int count = 0;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(graph[i][j] == 1) {
					count++;
				}
			}
		}
		return count;
	}

}
