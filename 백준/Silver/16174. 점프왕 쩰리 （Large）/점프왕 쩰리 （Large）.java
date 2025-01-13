import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] graph;
	static boolean[][] visited;
	static String answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		
		for(int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0 ; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//구현
		visited = new boolean[N][N];
		answer = "Hing";
		
		dfs(0, 0);
		System.out.println(answer);
		
	}

	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		if(x == N - 1 && y == N - 1) {
			answer = "HaruHaru";
			return;
		}
		
		int n = graph[x][y];
		
		//오른쪽 이동
		if(y + n < N && !visited[x][y + n]) {
			dfs(x, y + n);
		}
		
		//아래 이동
		if(x + n < N && !visited[x + n][y]) {
			dfs(x + n, y);
		}
	}

}