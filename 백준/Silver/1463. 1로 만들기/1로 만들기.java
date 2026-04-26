import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		
		visited = new boolean[X + 1];
		int answer = bfs(X);
		
		System.out.println(answer);
	}

	public static int bfs(int x) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(x);
		visited[x] = true;
		
		int count = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int s = 0; s < size; s++) {
				int n = queue.poll();
				
				if(n == 1) {
					return count;
				}
				
				if(n % 3 == 0) { //3으로 나눠떨어지는 경우
					queue.add(n / 3);
					visited[n] = true;
				}
				
				if(n % 2 == 0) { //2로 나눠떨어지는 경우
					queue.add(n / 2);
					visited[n / 2] = true;
				}
				
				//1 빼는 경우
				queue.add(n - 1);
				visited[n - 1] = true;
			}
			count++;
		}
		return count;
	}
}