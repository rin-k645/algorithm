import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b13023 {
	static int N;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		graph = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		//구현
		int answer = 0;
		for(int i = 0; i < M; i++) {
			visited = new boolean[N];
			visited[i] = true;
			
			if(dfs(i, 0)) {
				answer = 1;
				break;
			}
		}
		
		//출력
		System.out.println(answer);
	}

	public static boolean dfs(int idx, int depth) {
		if(depth == 4) {
			return true;
		}
		
		for(int i = 0; i < graph[idx].size(); i++) {
			if(visited[graph[idx].get(i)]) continue;
			
			visited[graph[idx].get(i)] = true;
			
			if(dfs(graph[idx].get(i), depth +  1)) {
				return true;
			}
			
			visited[graph[idx].get(i)] = false;
		}
		
		return false;
	}

}
