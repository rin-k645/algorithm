package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class EfficientHacking {
	static int N;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int[] count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		graph = (ArrayList<Integer>[]) new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}


		for(int i = 0; i < M; i++) {
			String[] row = br.readLine().split(" ");
			int a = Integer.parseInt(row[0]);
			int b = Integer.parseInt(row[1]);
			
			graph[a].add(b);
		}
		
		count = new int[N + 1];
		
		int max = 0;
		for(int i = 1; i < N + 1; i++) {
			visited = new boolean[N + 1];
			dfs(i); //각 컴퓨터가 해킹할 수 있는 컴퓨터 수
			
		}
		
		for(int i = 1; i < N + 1; i++) {
			max = Math.max(max, count[i]);
		}
		
		for(int i = 1; i < N + 1; i++) { //max 값 오름차순 출력
			if(max == count[i]) {
				System.out.print(i + " ");
			}
		}
		
	}

	public static void dfs(int v) {
		visited[v] = true;
		
		for(int i : graph[v]) {
			if(!visited[i]) {
				count[i]++;
				dfs(i);
			}
		}
	}

}
