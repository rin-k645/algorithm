import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] graph;
	static boolean[][] visited;
	//ㄱ, 」, ㄴ, 「
	static int[][] dx = {{0, 0, 1}, {0, 0, -1}, {0, -1, 0}, {0, 1, 0}};
	static int[][] dy = {{0, -1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, 1}};

	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//구현
		visited = new boolean[N][M];
		max = 0;
		
		dfs(0, 0, 0);
		
		//출력
		System.out.println(max);
		
	}
	
	public static void dfs(int x, int y, int sum) {
		if(x == N && y == M) {
			max = Math.max(max, sum);
			return;
		}
		
		if(y == M) {
			y = 0;
			x++;
		}
		
		for(int d = 0; d < 4; d++) {
			int n = getPower(x, y, d);
			
			if(n > 0) {
				markVisited(x, y, d, true);
				dfs(x, y + 1, sum + n);
				markVisited(x, y, d, false);
			}
		}
		
		dfs(x, y + 1, sum);
	}

	private static int getPower(int x, int y, int d) {
		int sum = 0;
		
		for(int i = 0; i < 3; i++) {
			int nx = x + dx[d][i];
			int ny = y + dy[d][i];
			
			if(0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny]) {
				int value = graph[nx][ny];
				if(i == 0) {
					value *= 2;
				}
				
				sum += value;
			} else {
				return 0;
			}
		}
		
		return sum;
	}

	public static void markVisited(int x, int y, int d, boolean b) {
		for(int i = 0; i < 3; i++) {
			int nx = x + dx[d][i];
			int ny = y + dy[d][i];
			
			visited[nx][ny] = b;
		}
	}

}