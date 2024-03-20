package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_�����̺��̱� {
	static int[][] graph;
	static List<int[]> list;
	static int[] paper;
//	static boolean[][] visited;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		graph = new int[10][10];
		list = new ArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 10; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				
				if(graph[i][j] == 1) {
					list.add(new int[] {i, j});
				}
			}
		}
		
//		visited = new boolean[10][10];
		paper = new int[6]; //����� ������ ����
		min = Integer.MAX_VALUE; //���� : �ּ� ����
		
		dfs(0, 0); //list�� �ε���
		
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	public static void dfs(int idx, int depth) {
		if(idx == list.size()) { //1���� ĭ �� ����
			min = Math.min(min, depth); //�ּڰ� ����
			return;
		}
		
		if (min <= depth) return; //����ġ��
		
		int x = list.get(idx)[0];
		int y = list.get(idx)[1];
		
		if(graph[x][y] == 0) { //�̹� �湮��
			dfs(idx + 1, depth); //���� �Ⱥ��̰� Ž��
			return;
		}
		
		for(int size = 5; size >= 1; size--) { //������5���� 1���� ���캸��
			if(paper[size] < 5 && possible(x, y, size)) { //�ش� ������ 5�� �̸� ����, ���� �� ����
				//���̱�
				check(x, y, size, 0);
				paper[size]++;
				dfs(idx + 1, depth + 1);
				//�Ⱥ��̱�
				paper[size]--;
				check(x, y, size, 1);
			}
		}
		
	}

	public static boolean possible(int x, int y, int size) {
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(i >= 10 || j >= 10) { //���� �Ѿ
					return false;
				}
				
				if(graph[i][j] == 0) { //������
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void check(int x, int y, int size, int mark) { //üũ�ϱ�
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				graph[i][j] = mark;
			}
		}
	}

}
