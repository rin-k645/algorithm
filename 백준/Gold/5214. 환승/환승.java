import java.io.*;
import java.util.*;

public class Main {
	static List<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new List[N + 1 + M];
		
		for(int i = 0; i < N + 1 + M; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j < K; j++) {
				int num = Integer.parseInt(st.nextToken());
				graph[N + 1 + i].add(num);
				graph[num].add(N + 1 + i);
			}
		}
		
		System.out.println(bfs(1, N, M));
	}

	private static int bfs(int start, int n, int m) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[n + 1 + m];
		
		queue.add(start);
		visited[start] = true;
		
		if(start == n) return 1;
		
		int count = 1;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int s = 0; s < size; s++) {
				int cur = queue.poll();
				
				if(cur == n) return (count + 1) / 2;
				
				for(int next : graph[cur]) {
					if(!visited[next]) {
						queue.add(next);
						visited[next] = true;
					}
				}
			}
			count++;
		}
		
		return -1;
	}

}