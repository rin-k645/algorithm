package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_�ּҺ�뱸�ϱ�2 {
	static List<Node>[] graph;
	static int[] dist;
	static boolean[] visited;
	static int[] route; //��� ����
	
	static class Node {
		int to, cost;
		
		Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); //������ ����
		int m = Integer.parseInt(br.readLine()); //������ ����
		
		graph = new ArrayList[n + 1];
		for(int i = 1; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) { //���� ���� ����
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[from].add(new Node(to, cost));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		//���ͽ�Ʈ��
		dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE); //��� �������� �ʱ�ȭ
		
		visited = new boolean[n + 1];
		route = new int[n + 1];
		
		
		dijkstra(start);
		
		//��� ���ϱ�
		Stack<Integer> stack = new Stack<>();
		stack.add(end);
		
		int count = 1;
		int idx = end;
		
		while(idx != start) {
			idx = route[idx];
			count++;
			stack.add(idx);
		}
		
		//���
		System.out.println(dist[end]); //�ּ� ���
		System.out.println(count); //�ּ� ��� ��ο� ���ԵǾ� �ִ� ���� ����
		//�ּ� ����� ���� ���
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
	
	public static void dijkstra(int start) {
		Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost); //�ּ���
		
		queue.add(new Node(start, 0)); //������ ����
		dist[start] = 0;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int now = node.to;
			
			if(visited[now]) continue;
			visited[now] = true;
			
			for(Node next : graph[now]) { //���� ��ο���
				if(dist[next.to] > dist[now] + next.cost) { //�ּ� ��� ����
					dist[next.to] = dist[now] + next.cost;
					queue.add(new Node(next.to, dist[next.to]));
					route[next.to] = now; //���� ���ÿ� ���� ���� ����
				}
			}
		}
	}

}
