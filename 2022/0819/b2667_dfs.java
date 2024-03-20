import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class b2667_dfs {
	static int N;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static ArrayList<Integer> houses;
	static int houseCount = 0;
	
	static class House {
		int x;
		int y;
		
		public House(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		N = Integer.parseInt(input);
		
		graph = new int[N][N];
		visited = new boolean[N][N];
		houses = new ArrayList<>();
		
		
		for(int i = 0; i < N; i++) {
			String row = br.readLine();
			
			for(int j = 0; j < N; j++) {
				graph[i][j] = row.charAt(j) - '0';
			}
		}
		
		//구현
		int groupCount = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(graph[i][j] == 1 && !visited[i][j]) { //집이 있고 방문x
					houseCount = 1;
					dfs(i, j); //탐색 시작
					houses.add(houseCount); //아파트 수 저장
					groupCount++;
				}
			}
		}
		
		//출력
		System.out.println(groupCount);
		
		Collections.sort(houses);
		for(Integer i : houses) {
			System.out.println(i);
		}
	}

	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i = 0; i < 4; i++) { //상하좌우 탐색
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0 <= nx && nx < N && 0 <= ny && ny < N) {
				if(graph[nx][ny] == 1 && !visited[nx][ny]) {
					dfs(nx, ny);
					houseCount++;
				}
			}
		}
	}

}
