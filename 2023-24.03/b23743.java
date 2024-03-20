package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b23743 {
	static int N, M;
	static Edge[] edgeList;
	static int[] parents;
	
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	static void make() {
		parents = new int[N + 1];
		
		for(int i = 0; i < N + 1; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		
		return parents[a] = find(parents[a]);
		
	}
	
	static boolean union(int a , int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); //���� ����
		M = Integer.parseInt(st.nextToken()); //��ġ�� �� �ִ� ������ ����
		
		edgeList = new Edge[M + N]; //���� �迭
		
		//���� ����
		for(int i = 0; i < M; i ++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
		
			edgeList[i] = new Edge(a, b, c);
		}
		
		//Ż�ⱸ ��ġ
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i ++) {
			int t = Integer.parseInt(st.nextToken());
			edgeList[M + i - 1] = new Edge(0, i, t); //Ż�ⱸ�� 0
		}
		
		//ó��
		make(); //�θ� ��� �����
		Arrays.sort(edgeList); //�ð� ���� �� �������� ����
		
		//ũ�罺Į �˰���
		int result = 0;
		int count = 0;
		for(Edge edge : edgeList) { //���� ������ ����
			if(union(edge.from, edge.to)) { //����Ŭ�� �������� ������ ���� ����
				result += edge.weight; //��� ����
				if(++count == N) break; //���� ���� - 1 ��ŭ ���������� ���� : N + 1(Ż�ⱸ ����) - 1
			}
		}
		
		//���
		System.out.println(result);
	}

}
