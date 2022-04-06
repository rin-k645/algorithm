package Floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Floyd_warshall {
	static int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n + 1][n + 1];
		
		for(int i = 1; i < n + 1; i++) { //배열 초기화
			for(int j = 1; j < n + 1; j++) {
				if(i == j) {
					arr[i][j] = 0;
					continue;
				}
				arr[i][j] = INF;
			}
		}
		
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr[a][b] = Math.min(arr[a][b], c);
		}
		
		for(int k = 1; k < n + 1; k++) { //플로이드-와샬
			for(int i = 1; i < n + 1; i++) {
				for(int j = 1; j < n + 1; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
		
		for(int i = 1; i < n + 1; i++) { //출력
			for(int j = 1; j < n + 1; j++) {
				if(arr[i][j] == INF) {
					arr[i][j] = 0;
				}
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
