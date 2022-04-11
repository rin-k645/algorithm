package Floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheSixDegreesOfKevinBacon {
	static int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input1 = br.readLine().split(" ");
		
		int N = Integer.parseInt(input1[0]);
		int M = Integer.parseInt(input1[1]);
		
		int[][] dist = new int[N + 1][N + 1];
		for(int i = 1; i < N + 1; i++) { // 플로이드 와샬 초기 거리 테이블 초기화
			for(int j = 1; j < N + 1; j++) {
				if(i == j) {
					dist[i][j] = 0;
					continue;
				}
				dist[i][j] = INF;
			}
		}
		
		
		for(int i = 0; i < M; i++) {
			String[] input2 = br.readLine().split(" ");
			int p1 = Integer.parseInt(input2[0]);
			int p2 = Integer.parseInt(input2[1]);
			
			dist[p1][p2] = dist[p2][p1] = 1;
		}
		
		for (int k = 1; k < N + 1; k++) { //플로이드 와샬 알고리즘
			for(int i = 1; i < N + 1; i++) {
				for(int j = 1; j < N + 1; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		int min = INF;
		int index = -1;
		for(int i = 1; i < N + 1; i++) {
			int sum = 0;
			
			for(int j = 1; j < N + 1; j++) {
				sum += dist[i][j];
			}
			
			if(sum < min) {
				min = sum;
				index = i;
			}
		}
		
		System.out.println(index);
	}

}
