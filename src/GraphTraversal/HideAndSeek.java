package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class HideAndSeek {
	static int[] graph;
	static boolean[] visited;
	static int[] dx = {-1, 1, 2};
	
	static class Subin {
		int x;
		int count;
		
		public Subin(int x, int count) {
			this.x = x;
			this.count = count;
		}
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		graph = new int[100001];
		visited = new boolean[100001];
		
		int count = bfs(N, K);
		
		System.out.println(count);
	}


	public static int bfs(int x, int k) {
		Queue<Subin> queue = new LinkedList<Subin>();
		
		queue.add(new Subin(x, 0));
		visited[x] = true;
		
		while(!queue.isEmpty()) {
			Subin subin = queue.poll();
			
			if(subin.x == k) { //종료 조건
				return subin.count;
			}
			
			for(int i = 0; i < 3; i++) { //앞, 뒤, 순간이동으로 탐색
				int nx = 0;
				if(dx[i] == 2) {
					nx = subin.x * dx[i];
				} else {
					nx = subin.x + dx[i];
				}
				
				if(0 <= nx && nx <= 100000 && !visited[nx]) { //좌표 범위 안에 있고 방문x
					queue.add(new Subin(nx, subin.count + 1)); //큐에 넣음
					visited[nx] = true;
				}
			}
		}
		
		return 0;
	}

}
