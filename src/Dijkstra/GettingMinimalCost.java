package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class GettingMinimalCost {
	public static final int INF = 987654321;
	public static ArrayList<Node>[] list;
	public static int[] dist;
	public static boolean[] visited;
	
	static class Node implements Comparable<Node>{
		int to;
		int cost;
		public Node(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N + 1];
		for(int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}
		
		dist = new int[N + 1];
		visited = new boolean[N + 1];
		
		StringTokenizer st;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		dijkstra(A);
		
		System.out.println(dist[B]);
	}

	public static void dijkstra(int start) {
		Queue<Node> q = new PriorityQueue<>();
		Arrays.fill(dist, INF);
		
		q.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int to = node.to;
			
			if(visited[to])	continue;
			visited[to] = true;
			
			for(Node next : list[to]) {
				if(dist[next.to] > dist[to] + next.cost) {
					dist[next.to] = dist[to] + next.cost;
					q.add(new Node(next.to, dist[next.to]));
				}
			}
		}
	}

}
