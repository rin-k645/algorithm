package algorithm;

import java.util.*;
import java.io.*;

public class BOJ_�̸�Ƽ�� {
	static boolean[][] visited;
	
	static class Point {
		int num; //���� ����
		int copy; //������ ����
		
		Point(int num, int copy) {
			this.num = num;
			this.copy = copy;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int S = Integer.parseInt(br.readLine());
		
		visited = new boolean[S + 1][S + 1]; //���� ����, ������ ����
		
		System.out.println(bfs(1, S));
	}

	public static int bfs(int i, int S) {
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(new Point(1, 1)); //ó���� ����
		visited[1][1] = true;
		
		int count = 1; //�ð�
		while(!queue.isEmpty()) {
			int size = queue.size(); //���� �ð� �� ť ������
			
			count++;
			for(int s = 0; s < size; s++) {
				Point point = queue.poll();
				int num = point.num;
				int copy = point.copy;
				int next = 0; //���� Ž���� �̸�Ƽ���� ��
				
				//�����ϴ� ���
				if(!visited[num][num]) {
					queue.add(new Point(num, num));
					visited[num][num] = true;
				}
				
				//�ٿ��ֱ��ϴ� ���
				next = num + copy;
				
				if(next <= S && !visited[next][copy]) {
					if(next == S) return count; //ã��!
					
					queue.add(new Point(next, copy));
					visited[next][copy] = true;
				}
				
				//�����ϴ� ���
				next = num - 1;
				
				if(1 < next && !visited[next][copy]) {
					if(next == S) return count; //ã��!
					
					queue.add(new Point(next, copy));
					visited[next][copy] = true;
				}
			}
		}
		return count;
	}

}
