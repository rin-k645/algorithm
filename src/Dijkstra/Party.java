package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Party {
	public static final int INF = 987654321;
	public static ArrayList<Node>[] list;
	public static int[][] dist;
	public static boolean[][] visited;
	
	static class Node implements Comparable<Node>{
		int to;
		int cost;
		
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		for(int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}
		
		dist = new int[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];
		
		for(int[] a : dist) {
			Arrays.fill(a, INF);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			
			list[A].add(new Node(B, T));
		}
		
		for(int i = 1; i < N + 1; i++) {
			dijkstra(i);
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 1; i < N + 1; i++) {
			max = Math.max(max, dist[i][X] + dist[X][i]);
		}
		
		System.out.println(max);
	}

	public static void dijkstra(int start) {
		Queue<Node> q = new PriorityQueue<>();
		
		q.add(new Node(start, 0));
		dist[start][start] = 0;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int to = node.to;
			
			if(visited[start][to]) continue;
			visited[start][to] = true;
			
			for(Node next : list[to]) {
				if(dist[start][next.to] > dist[start][to] + next.cost) {
					dist[start][next.to] = dist[start][to] + next.cost;
					q.add(new Node(next.to, dist[start][next.to]));
				}
			}
		}
	}

}