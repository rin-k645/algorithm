package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_FruitFeast {
	static int T, A, B;
	static boolean[][] visited;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		T = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		visited = new boolean[2][T + 1]; //0 : ¹° ¾È¸ÔÀ½, 1 : ¹° ¸ÔÀ½
		max = 0; //Á¤´ä : ÃÖ´ñ°ª
		
		bfs();
		
		System.out.println(max);
	}

	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {A, 0}); //¿À·»Áö ¸ÔÀ½
		queue.add(new int[] {B, 0}); //·¹¸ó ¸ÔÀ½
		visited[0][A] = true;
		visited[0][B] = true;
		
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			int fullness = p[0]; //Æ÷¸¸°¨
			int drink = p[1]; //¹° ¸¶¼Ì´ÂÁö
			
			max = Math.max(max, fullness);
			
			//¿À·»Áö
			int nextOrange = fullness + A;
			
			if(nextOrange <= T && !visited[drink][nextOrange]) {
				queue.add(new int[] {nextOrange, drink});
				visited[drink][nextOrange] = true;
			}
				
			//·¹¸ó
			int nextRemon = fullness + B;
			
			if(nextRemon <= T && !visited[drink][nextRemon]) {
				queue.add(new int[] {nextRemon, drink});
				visited[drink][nextRemon] = true;
			}	
			
			//¹°
			if(drink == 0) {
				int nextWater = fullness / 2;
				
				if(!visited[1][nextWater] && !visited[0][nextWater]) {
					queue.add(new int[] {nextWater, 1});
					visited[1][nextWater] = true;
				}
			}
		}
		
	}

}
