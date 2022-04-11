package Floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindingRoute {
	static int N;
	static int[][] graph;
	static final int INF = 987654321;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		graph = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			
			for(int j = 0; j < N; j++) {
				if(Integer.parseInt(input[j]) == 0) {
					graph[i][j] = INF;
				} else {
					graph[i][j] = Integer.parseInt(input[j]);
				}
			}
		}
		
		floyd_warshall();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(graph[i][j] != INF) {
					System.out.print(1 + " ");
				} else {
					System.out.print(0 + " ");
				}
			}
			System.out.println();
		}
	}

	public static void floyd_warshall() {
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(graph[i][j] > graph[i][k] + graph[k][j]) {
						graph[i][j] =  graph[i][k] + graph[k][j];
					}
				}
			}
		}
	}

}
