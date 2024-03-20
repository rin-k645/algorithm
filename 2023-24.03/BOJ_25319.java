package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25319 {
	static int N, M, S;
	static char[][] graph;
	static boolean[][] visited;
	static String id;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static char[] order = {'U', 'D', 'L', 'R'}; //��ɾ�
	static char[] result;
	
	static int answer_C, answer_L;
	static String answer_str;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); //���� ����
		M = Integer.parseInt(st.nextToken()); //���� ����
		S = Integer.parseInt(st.nextToken()); //���̵��� ����
		
		graph = new char[N][M]; //�׷���
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for(int j = 0; j < M; j++) {
				graph[i][j] = line.charAt(j);
			}
		}
		
		id = br.readLine(); //���̵�
				
		//Ž��
		visited = new boolean[N][M];
		result = new char[1000000];
		
		answer_C = 0;
		answer_L = 0;
		answer_str = "";
		
		visited[0][0] = true;
		dfs(0, 0, 0, 0, 0);
		
		//���
		System.out.println(answer_C + " " + answer_L);
		System.out.println(answer_str);
	}

	public static void dfs(int x, int y, int idx, int power, int l) { //��, ��, �ֿ��� �ϴ� ������ ���̵� �ε���, ��ȭ Ƚ��, ��ɾ� ���ڿ� ����
		//�ֿ��� �ϴ� ���ڸ� �ݱ�
		if(graph[x][y] == id.charAt(idx)) {
			System.out.println(graph[x][y] + " == " + id.charAt(idx));
			System.out.println(x + " " + y + " " + idx + " " + power + " " + l + " �ݱ�");
			result[l] = 'P'; //�ൿ �߰�
			l++;
			
			if(idx == id.length() - 1) { //�ֿ� �������� ���̵�� ��ġ
				System.out.println("��ȭ");
				power++; //��ȭ
				idx = 0; //�ֿ� ������ ����ȭ
			} else {
				idx++; //���̵� �ε��� ����
			}
		}
		
		//���� ����
		if(x == N - 1 && y == M - 1 && idx == 0) {
			//��ȭ�� �� �ִ� �ִ밪 ����
			System.out.println("�Ŀ�: " + power);
			
			for(int i = 0; i < l; i++) {
				System.out.print(result[i]);
			}
			System.out.println();
			
			if(power >= answer_C) {
				answer_C = power;
				answer_L = l;
				
				StringBuilder sb  = new StringBuilder();
				for(int i = 0; i < l; i++) {
					sb.append(result[i]);
				}
				
				answer_str = sb.toString();
			}
			
			System.out.println("-------------------");
			
			return;
		}
		
		//��� Ž��
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(0 <= nx && nx < N && 0 <= ny && ny < M) {
				if(!visited[nx][ny]) {
					result[l] = order[d]; //�ൿ �߰�
					
					visited[nx][ny] = true;
					System.out.println(nx + " " + ny + " " + idx + " " + power + " " + (l + 1) + " Ž��");
					dfs(nx, ny, idx, power, l + 1); //Ž��
					visited[nx][ny] = false;
				}
			}
			
		}
	}

}
