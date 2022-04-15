package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SangGoenTravle {
	static int N, M;
	static int[][] graph;
	static boolean[] visited;
	static int count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			graph = new int[N + 1][N + 1];
			visited = new boolean[N + 1];
			count = 0;
			
			for(int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph[a][b] = graph[b][a] = 1;
			}
			
			bfs();
			
			sb.append(count - 1).append('\n');
		}
		
		System.out.println(sb);
	}

	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(1);
		visited[1] = true;
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
			count++;
			
			for(int i = 1; i < N + 1; i++) {
				if(graph[v][i] == 1 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}

	}

}
