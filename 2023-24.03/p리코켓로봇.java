package algorithm;

import java.util.*;

class p리코켓로봇 {
	
	public static void main(String[] args) {
//		String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
		String[] board = {".D.R", "....", ".G..", "...D"};
		System.out.println(solution(board));
	}
	
    static char[][] graph;
    static int N, M;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static class Dot {
        int x, y, dist;
        
        public Dot(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    public static int solution(String[] board) {
        N = board.length; 
        M = board[0].length();
        graph = new char[N][M];
        
        int startX = 0, startY = 0;
        
        for(int i = 0; i < N; i++) {
            String str = board[i];
            
            for(int j = 0; j < M; j++) {
                graph[i][j] = str.charAt(j);
                if(graph[i][j] == 'R') {
                    startX = i;
                    startY = j;
                }
            }
        }
        
        // for(int i = 0; i < N; i++) {
        //     for(int j = 0; j < M; j++) {
        //         System.out.print(graph[i][j]);
        //     }
        //     System.out.println();
        // }
        
        visited = new boolean[N][M];
        
        return bfs(startX, startY);
    }
    
    public static int bfs(int startX, int startY) {
        Queue<Dot> queue = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        
        queue.add(new Dot(startX, startY, 0));
        visited[startX][startY] = true;
        
        boolean flag = false;
        while(!queue.isEmpty()) {
            Dot dot = queue.poll();
            
            for(int d = 0; d < 4; d++) {
                int nx = dot.x + dx[d];
                int ny = dot.y + dy[d];
                
//                System.out.println(nx + ", " + ny);
                
                while((0 <= nx && nx < N && 0 <= ny && ny < M) && (graph[nx][ny] != 'D')) {
                    nx += dx[d];
                    ny += dy[d];
                }
                
                if(graph[nx - dx[d]][ny - dy[d]] == 'G') {
                    min = Math.min(min, dot.dist + 1);
                    flag = true;
                    break;
                }
                
                if(!visited[nx - dx[d]][ny - dy[d]]) {
                    queue.add(new Dot(nx - dx[d], ny - dy[d], dot.dist + 1));
                    visited[nx - dx[d]][ny - dy[d]] = true;
//                    System.out.println((nx - dx[d]) + ", " + (ny - dy[d]) + "큐에 들어감");
                }
            }
            
        }
        
        if(flag) {
        	return min;
        } else {
        	return -1;
        }
    }
}
