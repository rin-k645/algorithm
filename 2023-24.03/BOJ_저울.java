package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_���� {
	static ArrayList<Integer>[] graph1; //��������Ʈ: ���� ����(A > B)
    static ArrayList<Integer>[] graph2; //�ݴ�� ����(B < A)
    static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		graph1 = new ArrayList[N + 1];
        for(int i = 1; i < N + 1; i++) {
            graph1[i] = new ArrayList<>();
        }
        
        graph2 = new ArrayList[N + 1];
        for(int i = 1; i < N + 1; i++) {
            graph2[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; i++) { //���� �� ���� ����
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	graph1[a].add(b); //A > B
            graph2[b].add(a); //B < A
        }
        
        //����
        int[] answer = new int[N + 1];
        
        for(int i = 1; i < N + 1; i++) {
        	visited = new boolean[N + 1];
        	int sum = bfs(graph1, i); //i���� ���� ���� ����(i����)
        	
        	visited = new boolean[N + 1];
        	sum += bfs(graph2, i); //i���� ū ���� ����(i����)
        	
        	answer[i] = N - sum - 1; //�� ����� �� �� ���� ������ ����
        }
        
        //���
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < N + 1; i++) {
        	sb.append(answer[i] + "\n");
        }
        System.out.println(sb);
	}
	
	public static int bfs(ArrayList<Integer>[] graph, int v) {
        Queue<Integer> queue = new LinkedList<>();
         
        queue.add(v);
        visited[v] = true;
         
        int count = 0; //�� ���� ���� ����
        while(!queue.isEmpty()) {
            int p = queue.poll();
             
            for(int i : graph[p]) {
                if(!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
         
        return count;
    }

}
