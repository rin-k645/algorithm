import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] graph, graph_copy;
	static List<Dot> blankList;
	static Dot[] result; //벽 세우기 조합 결과
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int max;
	
	static class Dot {
		int x, y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		blankList = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			
				if(graph[i][j] == 0) { //빈 칸 위치 저장
					blankList.add(new Dot(i, j));
				}
			}
		}
		
		//구현
		max = 0;
		result = new Dot[3];
		combination(0, 0); //조합
		
		//출력
		System.out.println(max);
	}

	public static void combination(int start, int depth) {
		if(depth == 3) {
			graph_copy = deepCopy(graph); //복사본 만들기
			
			for(Dot wall : result) {//벽 세우기
				graph_copy[wall.x][wall.y] = 1;
			}
			
			visited = new boolean[N][M];
			bfs(); //바이러스 퍼뜨리기
			
			//안전 영역 크기 구하고 최대값 갱신
			max = Math.max(max, getSafeArea());
			
			return;
		}
		
		//조합 만들기
		for(int i = start; i < blankList.size(); i++) {
			result[depth] = blankList.get(i);
			combination(i + 1, depth + 1);
		}
	}

	public static void bfs() {
		Queue<Dot> queue = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(graph_copy[i][j] == 2) { //바이러스 큐에 넣기
					queue.add(new Dot(i, j));
					visited[i][j] = true;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Dot dot = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = dot.x + dx[i];
				int ny = dot.y + dy[i];
				
				if(0 <= nx && nx < N && 0 <= ny && ny < M) { //범위 안에 있고
					if(!visited[nx][ny] && graph_copy[nx][ny] != 1) { //방문X, 벽이 아니면
						graph_copy[nx][ny] = 2; //바이러스 퍼뜨리기
						queue.add(new Dot(nx, ny));
						visited[nx][ny] = true;
					}
				}
			}
		}
	}

	public static int[][] deepCopy(int[][] graph) {
		int[][] tmp = new int[graph.length][graph[0].length];
		for(int i = 0; i < graph.length; i++) {
			for(int j = 0; j < graph[i].length; j++) {
				tmp[i][j] = graph[i][j];
			}
		}
		return tmp;
	}

	public static int getSafeArea() {
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(graph_copy[i][j] == 0) {
					count++;
				}
			}
		}
		
		return count;
	}
}
