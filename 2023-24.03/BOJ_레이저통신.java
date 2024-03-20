package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_레이저통신 {
	static char[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		graph = new char[H][W];
		List<int[]> cLocation = new LinkedList<>();
		
		for(int i = 0; i < H; i++) {
			String line = br.readLine();
			
			for(int j = 0; j < W; j++) {
				graph[i][j] = line.charAt(j);
				
				if(graph[i][j] == 'C') {
					cLocation.add(new int[] {i, j});
				}
			}
		}
		
		//구현
		
		
	}

}
