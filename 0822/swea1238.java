import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea1238 {
	static int N;
	static ArrayList<Integer>[] graph;
	static int[] count;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			graph = new ArrayList[101];
			for (int i = 1; i <= 100; i++) {
				graph[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				graph[from].add(to);
			}
			
			//구현
			count = new int[101];
			answer = 0;
			
			bfs(start);
			
			//출력
			System.out.println("#" + t + " " + answer);
		}
	}
	
	public static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(v);
		
		while(!queue.isEmpty()) {
			v = queue.poll();
			
			for(int n : graph[v]) {
				if(count[n] == 0) {
					queue.offer(n);
					count[n] = count[v] + 1;
				}
			}
			
		}
		
		int max = 0;
		for (int i = 1; i <= 100; i++) {
			if(count[i] >= max) {
				max = count[i];
				answer = i;
			}
		}
	}

}
