package algorithm;

import java.util.*;
import java.io.*;

public class BOJ_�����̾Ʈ���Ƿκ� {
	static int N;
	static int[] belt;
	static boolean[] hasRobot;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		belt = new int[2 * N]; //�����̾� ��Ʈ
		hasRobot = new boolean[N]; //�κ��� �ִ���
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 2 * N; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 1;
		while(true) {
			//1. �� ĭ ȸ��
			rotateBelt();
			//2. �� ĭ �̵��� �� �ִٸ� �̵�
			moveRobot();
			//3. �κ� �ø���
			putRobot();
			
			if(check() >= K) break;
			
			answer++;
		}
		
		System.out.println(answer);
	}

	public static int check() {
		int count = 0;
		for(int n : belt) {
			if(n == 0) count++;
		}
		
		return count;
	}
	
	public static void rotateBelt() {
		//��Ʈ ȸ��
		int tmp_belt = belt[2 * N - 1];
		
		for(int i = 2 * N - 1; i > 0; i--) {
			belt[i] = belt[i - 1];
		}
		belt[0] = tmp_belt;

		//�κ� ȸ��
		for(int i = N - 1; i > 0; i--) {
			hasRobot[i] = hasRobot[i - 1];
		}
		hasRobot[0] = false;
	}
	
	public static void moveRobot() {
		hasRobot[N - 1] = false; //�κ� ������
		
		for(int i = N - 2; i >= 0; i--) {
			if(hasRobot[i]) {
				if(!hasRobot[i + 1] && belt[i + 1] >= 1) { //�̵��Ϸ��� ĭ�� �κ��� ������, �������� 1 �̻� ��������
					belt[i + 1]--; //������ ����
					hasRobot[i + 1] = true; //�κ� �̵�
					hasRobot[i] = false;
				}
			}
		}
	}
	
	public static void putRobot() {
		if(belt[0] > 0) {
			belt[0]--; //������ ����
			hasRobot[0] = true;
		}
	}

}
