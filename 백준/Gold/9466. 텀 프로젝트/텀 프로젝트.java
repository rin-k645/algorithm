import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static boolean[] visited;
	static boolean[] cycled;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			arr = new int[n + 1];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int i = 1; i < n + 1; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			//탐색하기
			visited = new boolean[n + 1];
			cycled = new boolean[n + 1];
			answer = n;
			
			for(int i = 1; i < n + 1; i++) {
				if(!visited[i]) {
//					System.out.println(i + "시작");
					dfs(i);
				}
			}
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int cur) {
		visited[cur] = true;
		
		int next = arr[cur];
		
		if(!visited[next]) {
//			System.out.println("다음: " + next);
			dfs(next);
		} else {
			if(!cycled[next]) {
				answer--;
				
				while(cur != next) {
//					System.out.println(next + " 방문");
					answer--;
					next = arr[next];
				}
			}
		}
		
//		System.out.println(cur);
		cycled[cur] = true;
	}

}