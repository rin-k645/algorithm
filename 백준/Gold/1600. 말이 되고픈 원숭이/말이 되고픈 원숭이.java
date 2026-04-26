import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int K, W, H;
	static int[][] graph;
	static int[] dx1 = {-1, 1, 0, 0};
	static int[] dy1 = {0, 0, -1, 1};
	static int[] dx2 = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dy2 = {-2, -1, 1, 2, -2, -1, 1, 2};
	static int[][] visited;
	
	static class Dot{
		int x, y, count;

		public Dot(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Dot [x=" + x + ", y=" + y + ", count=" + count + "]";
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		graph = new int[H][W];
		
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < W; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//구현
		visited = new int[H][W];
		for(int i = 0; i < H; i++) {
			Arrays.fill(visited[i], K+1);
		}
		
		int answer = bfs();
		
		//출력
		System.out.println(answer);
	}

	public static int bfs() {
		Queue<Dot> queue = new LinkedList<>();
		
		queue.add(new Dot(0, 0, 0));
		visited[0][0] = 0;
		
		int count = 0;
		while(!queue.isEmpty()) {
//			System.out.println(queue);
			int size = queue.size();
			
			for(int s = 0; s < size; s++) {
				Dot dot = queue.poll();
				
				if(dot.x == H - 1 && dot.y == W - 1) {
					return count;
				}
				
				for(int i = 0; i < 4; i++) { //인접한 칸으로 움직이는 경우
					int nx = dot.x + dx1[i];
					int ny = dot.y + dy1[i];
					
					if(0 <= nx && nx < H && 0 <= ny && ny < W) {
						if(visited[nx][ny] > dot.count && graph[nx][ny] != 1) {
							queue.add(new Dot(nx, ny, dot.count));
							visited[nx][ny] = dot.count;
						}
					}
					
				}
				
				if(dot.count < K) {
					for(int i = 0; i < 8; i++) { //말처럼 움직이는 경우
						int nx = dot.x + dx2[i];
						int ny = dot.y + dy2[i];
						if(0 <= nx && nx < H && 0 <= ny && ny < W) {
//							System.out.println(dot.x+","+dot.y+"/"+nx+","+ny+"v:"+visited[nx][ny]);
							
							if(visited[nx][ny] > dot.count + 1 && graph[nx][ny] != 1) {
//								System.out.println("add"+dot.x+","+dot.y+"/"+nx+","+ny);
								queue.add(new Dot(nx, ny, dot.count + 1));
								visited[nx][ny] = dot.count + 1;
							}
						}
					}
				}
			}
			
			count++;
		}
		return -1;
	}
	
	

}