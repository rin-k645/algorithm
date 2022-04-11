//백준 1753번 : https://www.acmicpc.net/problem/1753

package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class ShortPath {
	static int INF = 987654321;
	static ArrayList<Node>[] list;
	static boolean[] visited;
	static int[] dist;
	
	static class Node implements Comparable<Node> {
		int v;
		int w;
		
		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[V + 1];
		for(int i = 0; i < V + 1; i++) {
			list[i] = new ArrayList<>();
		}
		
		visited = new boolean[V + 1];
		dist = new int[V + 1];
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[u].add(new Node(v, w));
		}
		
		dijkstra(K);
		
		//출력
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i < V + 1; i++) {
			if(dist[i] == INF) {
				sb.append("INF\n");
			} else {
				sb.append(dist[i] + "\n");
			}
		}
		
		System.out.println(sb);
	}

	public static void dijkstra(int start) {
		Queue<Node> queue = new PriorityQueue<>();
		Arrays.fill(dist, INF); //무한대로 초기화
		
		queue.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int v = node.v;
			
			if(visited[v]) continue;
			
			visited[v] = true;
			
			for(Node next : list[v]) {
				if(dist[next.v] > dist[v] + next.w) {
					dist[next.v] = dist[v] + next.w;
					queue.add(new Node(next.v, dist[next.v]));
				}
			}
		}
	}

}
