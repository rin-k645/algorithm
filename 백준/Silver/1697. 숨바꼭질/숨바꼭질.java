import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		visited = new boolean[1000001];
		
		System.out.println(bfs(N, K));
	}

	public static int bfs(int n, int k) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(n);
		visited[n] = true;
		
		int count = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i = 0; i < size; i++) {
				int X = queue.poll();
				
				if(X == k) {
					return count;
				}
				
				for(int j = 0; j < 3; j++) {
					int next = 0;
					
					if(j == 0) {
						next = X + 1;
					}else if(j == 1) {
						next = X - 1;
					}else {
						next = 2 * X;
					}
					
					if(0 <= next && next <= 100000) {
						if(!visited[next]) {
							queue.offer(next);
							visited[next] = true;
						}
					}
				}
			}
			count++;
		}
		return count;
	}
}