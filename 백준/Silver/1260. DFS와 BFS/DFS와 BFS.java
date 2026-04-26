import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		graph = new int[N + 1][N + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from][to] = graph[to][from] = 1;
		}
		
		visited = new boolean[N + 1];
		dfs(V);
		
		System.out.println();
		
		visited = new boolean[N + 1];
		bfs(V);
	}

	public static void dfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");
		
		for(int i = 1; i < N + 1; i++) {
			if(graph[v][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(v);
		visited[v] = true;
		System.out.print(v + " ");
		
		while(!queue.isEmpty()) {
			int p = queue.poll();
			
			for(int i = 1; i < N + 1; i++) {
				if(graph[p][i] == 1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
					System.out.print(i + " ");
				}
			}
		}
	}

}