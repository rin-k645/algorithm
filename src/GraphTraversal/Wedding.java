package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Wedding {
	static int n;
	static int[][] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		graph = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = graph[b][a] = 1;
		}
		
		visited[1] = true;
		dfs(1, 0);
		
		int count = 0;
		for(int i = 2; i < n + 1; i++) {
			if(visited[i]) {
				count++;
			}
		}
		
		System.out.println(count);
	}

	public static void dfs(int pos, int depth) {
		if(depth == 2) {
			return;
		}
		
		for(int i = 0; i < n + 1; i++) {
			if(graph[pos][i] == 1) {
				visited[i] = true;
				dfs(i, depth + 1);
			}
		}
	}

}
