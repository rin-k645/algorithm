import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] point = new int[N][2];
		
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			point[i][0] = Integer.parseInt(st.nextToken());
			point[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N][K + 1]; // n번까지 k개 건너뛰었을 때 최소 거리
		int INF = 1_000_000_000; // Integer.MAX_VALUE 이면 오버플로 남
		
		for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], INF);
        }
		
        dp[0][0] = 0; // 시작 지점
		
        // 계산
        for(int cur = 1; cur < N; cur++) { // 현재 지점
            for(int k = 0; k <= Math.min(cur, K); k++) { // 지금까지 건너 뛴 횟수
                for(int skip = 0; skip <= k; skip++) { // 이번에 건너뛰는 지점의 수
                    int prev = cur - skip - 1; // 이전 좌표 인덱스
                    if(prev < 0) continue; // 배열 인덱스 벗어남

                    // 현재와 이전 좌표 간 거리
                    int dist = Math.abs(point[prev][0] - point[cur][0]) + Math.abs(point[prev][1] - point[cur][1]);
                    // 최소 갱신
                    dp[cur][k] = Math.min(dp[cur][k], dp[prev][k - skip] + dist);
                }
            }
        }
		
        // 최대 k개까지 건너뛰었을 때 최소 거리
		int answer = Integer.MAX_VALUE;
		for(int i = 0; i <= K; i++) {
			answer = Math.min(answer, dp[N - 1][i]);
        }

		System.out.println(answer);
	}

}
