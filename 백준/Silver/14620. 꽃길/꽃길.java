import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] graph;
	static int min;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0, 0};
	static int[] dy = {0, 0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		graph = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][N];
		min = Integer.MAX_VALUE;
		
		dfs(0, 0);
		
		System.out.println(min);
	}

	
	public static void visit(int x, int y, boolean isChecked) {
		if(isChecked) {
			for(int d = 0; d < 5; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				visited[nx][ny] = true;
			}
		} else {
			for(int d = 0; d < 5; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				visited[nx][ny] = false;
			}
		}
	}

	public static void dfs(int sum, int depth) {
		if(sum >= min) return;
		
		if(depth == 3) {
			min = Math.min(min, sum);
			return;
		}
		
		for(int i = 1; i < N - 1; i++) {
			for(int j = 1; j < N - 1; j++) {
				if(isPossible(i, j)) {
					visit(i, j, true);
					dfs(sum + getSum(i, j), depth + 1);
					visit(i, j, false);
				}
			}
		}
	}


	public static int getSum(int x, int y) {
		int sum = 0;
		
		for(int d = 0; d < 5; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			sum += graph[nx][ny];
		}
		
		return sum;
	}


	public static boolean isPossible(int x, int y) {
		for(int d = 0; d < 5; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(visited[nx][ny]) return false;
		}
		return true;
	}
}
