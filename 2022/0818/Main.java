import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static char[][] graph;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[] alphabet;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		graph = new char[R + 1][C + 1];
		
		for(int i = 1; i <= R; i++) {
			String row = br.readLine();
			
			for(int j = 1; j <= C; j++) {
				graph[i][j] = row.charAt(j - 1);
			}
		}
		
		alphabet = new boolean[26];
		max = 0;
		
		dfs(1, 1, 1);
		
		System.out.println(max);
	}

	public static void dfs(int x, int y, int count) {	
		alphabet[graph[x][y] - 'A'] = true; //알파벳 중복 안되게 처리
		
		for(int i = 0; i < 4; i++) { //상하좌우 탐색
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(1 <= nx && nx <= R && 1 <= ny && ny <= C) { //좌표 범위 안에 있고
				if(!alphabet[graph[nx][ny] - 'A']) { //지금까지 지나온 알파벳과 다르면
					dfs(nx, ny, count + 1); //탐색
				}
			}
		}
		
		//탐색 끝남
		alphabet[graph[x][y] - 'A'] = false;
		max = Math.max(max, count);
	}

}
