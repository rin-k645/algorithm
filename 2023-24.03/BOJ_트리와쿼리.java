package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_Ʈ�������� {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); //Ʈ���� ������ ��
		int R = Integer.parseInt(st.nextToken()); //��Ʈ�� ��ȣ
		int Q = Integer.parseInt(st.nextToken()); //������ ��
		
		graph = new ArrayList[N + 1]; //Ʈ��
		for(int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N - 1; i++) { //���� ����
			st = new StringTokenizer(br.readLine(), " ");
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			graph[U].add(V);
			graph[V].add(U);
		}
		
		//����
		dp = new int[N + 1];
		
		for(int i = 1; i < N + 1; i++) { //�ڱ��ڽ� ����
			dp[i] = 1;
		}
		
		visited = new boolean[N + 1];
		
		dfs(R); //��Ʈ�� Ž�� ����
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < Q; i++) {
			int q = Integer.parseInt(br.readLine());
			sb.append(dp[q] + " \n");
		}
		System.out.println(sb);
	}

	public static int dfs(int v) {
		visited[v] = true; //�湮 üũ
		
		for(int i : graph[v]) { //������ ���
			if(!visited[i]) {
				dp[v] += dfs(i); //Ž��
			}
		}
		
		return dp[v];
	}

}
