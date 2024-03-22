import java.io.*;
import java.util.*;

public class Main {
	static int R, C;
	static char[][] graph;
	static int[] dx = {0, 1, 1, 1, 0, 0, 0, -1, -1, -1};
	static int[] dy = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1};
	static int[] jongsu;
	static Set<Integer> crazySet;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		graph = new char[R][C];
		
		crazySet = new HashSet<>();
		
		for(int i = 0; i < R; i++) {
			char[] chs = br.readLine().toCharArray();
			
			for(int j = 0; j < C; j++) {
				graph[i][j] = chs[j];
				
				if(graph[i][j] == 'I') {
					jongsu = new int[] {i, j};
				} else if(graph[i][j] == 'R') {
					crazySet.add(i * C + j);
				}
			}
		}
		
		String str = br.readLine();
		
		int[] order = new int[str.length()];
		for(int i = 0; i < str.length(); i++) {
			order[i] = str.charAt(i) - '0';
		}
		
		//구현
		boolean stopped = false;
		int X = 0;
		
		for(int i = 0; i < order.length; i++) {
			if(!moveJongsu(order[i])) {
				stopped = true;
				X = i + 1;
				break;
			}
			
			if(!moveCrazy()) {
				stopped = true;
				X = i + 1;
				break;
			}
//			System.out.println("========");
		}
		
		//출력
		if(stopped) {
			System.out.println("kraj " + X);
		} else {
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					System.out.print(graph[i][j]);
				}
				System.out.println();
			}
		}
		
	}

	public static boolean moveJongsu(int dir) {
		int nx = jongsu[0] + dx[dir];
		int ny = jongsu[1] + dy[dir];
		
		if(graph[nx][ny] == 'R') {
			return false;
		}
		
		graph[jongsu[0]][jongsu[1]] = '.';
		graph[nx][ny] = 'I';
		jongsu = new int[] {nx, ny};
		
		return true;
	}
	
	public static boolean moveCrazy() {
		Map<Integer, Integer> nextMap = new HashMap<>();
				
		for(int ardu : crazySet) {
			int x = ardu / C;
			int y = ardu % C;
			int minDist = Integer.MAX_VALUE;
			int minDir = 1;
			
			int nx = 0, ny = 0;
			for(int dir = 1; dir <= 9; dir++) {
				int nxTmp = x + dx[dir];
				int nyTmp = y + dy[dir];
				
				int dist = Math.abs(jongsu[0] - nxTmp) + Math.abs(jongsu[1] - nyTmp);
				
//				System.out.print(dist + " ");
				
				if(dist < minDist) {
					minDist = dist;
					minDir = dir;
					nx = x + dx[minDir];
					ny = y + dy[minDir];
				}
			}
//			System.out.println();
//			System.out.println(ardu + ": " + minDir);
			
			if(nx == jongsu[0] && ny == jongsu[1]) { //종수와 충돌
				return false;
			}
			
			//미친 아두이노 위치 옮기기
			graph[x][y] = '.';
			
			int next = nx * C + ny;
			nextMap.put(next, nextMap.getOrDefault(next, 0) + 1);
		}
		
		//같은 칸에 있는 경우 충돌
		List<Integer> list = new ArrayList<>(nextMap.keySet());
		
		for(int ardu : list) {
			if(nextMap.get(ardu) >= 2) {
				nextMap.remove(ardu);
				graph[ardu / C][ardu % C] = '.';
//				System.out.println(ardu + " 충돌");
			}
		}
		
		//충돌 안한거 이동하기
		crazySet = new HashSet<>();
		
		for(int ardu : nextMap.keySet()) {
			graph[ardu / C][ardu % C] = 'R';
			crazySet.add(ardu);
			
		}
		
//		for(int i = 0; i < R; i++) {
//			for(int j = 0; j < C; j++) {
//				System.out.print(graph[i][j]);
//			}
//			System.out.println();
//		}
		
		return true;
	}

}