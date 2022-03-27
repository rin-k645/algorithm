package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PuttingStars10 {
	public static char[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		
		makingStar(0, 0, N, false);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

	public static void makingStar(int x, int y, int N, boolean blank) {
		if(blank) { //공백
			for(int i = x; i < x + N; i++) {
				for(int j = y; j < y + N; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
		
		if(N == 1) { //종료조건
			arr[x][y] = '*';
			return;
		}
		
		int count = 0;
		for(int i = x; i < x + N; i += (N / 3)) {
			for(int j = y; j < y + N; j += (N / 3)) {
				count++;
				
				if(count == 5) { //공백
					makingStar(i, j, N / 3, true);
				} else {
					makingStar(i, j, N / 3, false);
				}
			}
		}
		
	}

}
