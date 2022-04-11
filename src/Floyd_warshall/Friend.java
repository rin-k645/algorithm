package Floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Friend {
	static int N;
	static int[][] graph;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());

		graph = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			char[] chs = input.toCharArray();
			
			for(int j = 0; j < N; j++) {
				if(chs[j] == 'Y') {
					graph[i][j] = 1;
				} else if(chs[j] == 'N') {
					graph[i][j] = 987654321;
				}
			}
		}
		
		floyd_warshall();
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			int friend = 0;
			
			for(int j = 0; j < N; j++) {
				if(i == j) {
					continue;
				} else if(graph[i][j] <= 2) {
					friend++;
				}
			}
			
			max = Math.max(max, friend);
		}
		
		System.out.println(max);
	}

	public static void floyd_warshall() {
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(i == j || j == k || i == k) {
						continue;
					} else if(graph[i][j] > graph[i][k] + graph[k][j]) {
						graph[i][j] =  graph[i][k] + graph[k][j];
					}
				}
			}
		}
	}

}
