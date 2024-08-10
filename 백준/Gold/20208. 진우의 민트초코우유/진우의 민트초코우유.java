import java.io.*;
import java.util.*;

public class Main {
	static int N, H;
	static int[][] graph;
	static int[] house;
	static List<int[]> milkList;
	static int max;
//	static boolean[][] visited;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		graph = new int[N][N];
		
		house = new int[2];
		milkList = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				
				if(graph[i][j] == 1) {
					house[0] = i;
					house[1] = j;
				} else if(graph[i][j] == 2) {
					milkList.add(new int[] {i, j});
				}
			}
		}
		
		max = 0;
//		visited = new boolean[N][N];
		visited = new boolean[milkList.size()];
		
		dfs(house[0], house[1], M, 0);
		
		System.out.println(max);
	}

	public static void dfs(int x, int y, int hp, int count) {
		if(Math.abs(x - house[0]) + Math.abs(y - house[1]) <= hp) {
			max = Math.max(max, count);
		}
		
//		for(int[] milk : milkList) {
//			int nx = milk[0];
//			int ny = milk[1];
//			
//			if(!visited[nx][ny]) {
//				visited[nx][ny] = true;
//				
//				int dist = Math.abs(x - nx) + Math.abs(y - ny);
//				if(dist <= hp) {
//					dfs(nx, ny, hp - dist + H, count + 1);
//				}
//				visited[nx][ny] = false;
//			}
//		}
		
		for(int i = 0; i < milkList.size(); i++) {
			int nx = milkList.get(i)[0];
			int ny = milkList.get(i)[1];
			
			if(!visited[i]) {
				int dist = Math.abs(x - nx) + Math.abs(y - ny);
				if(dist <= hp) {
					visited[i] = true;
					dfs(nx, ny, hp - dist + H, count + 1);
					visited[i] = false;
				}
			}
		}
	}

}