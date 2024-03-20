package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_ȿ��������ŷ {
	static int N;
	static LinkedList<Integer>[] graph;
	static boolean[] visited;
	static int[] count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new LinkedList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			graph[i] = new LinkedList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
		}
		
		count = new int[N + 1];
		
		int max = 0;
		for(int i = 1; i < N + 1; i++) {
			visited = new boolean[N + 1];
//			System.out.println("i: " + i);
			bfs(i); //�� ��ǻ�Ͱ� ��ŷ�� �� �ִ� ��ǻ�� ��
//			System.out.println();
		}
		
		for(int i = 1; i < N + 1; i++) { //�� ���� ��ŷ�� �� �ִ� ��ǻ�� �ִ�
			max = Math.max(max, count[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < N + 1; i++) { //max �� �������� ���
			if(max == count[i]) {
				sb.append(i + " ");
			}
		}
		
		System.out.print(sb);
	}
	
	public static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(v);
		visited[v] = true;
		
		while(!queue.isEmpty()) {
			int p = queue.poll();
			
			for(int i : graph[p]) {
				if(!visited[i]) {
//					System.out.println(v + " " + i);
					count[i]++; //B�� ��ŷ�ϸ�, A�� ��ŷ�� �� �ִ�
					queue.add(i);
					visited[i] = true;
				}
			}
		}
		
	}

}