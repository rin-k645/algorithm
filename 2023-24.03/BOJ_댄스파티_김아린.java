package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_����Ƽ_��Ƹ� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		//����
		PriorityQueue<Integer> man_positive = new PriorityQueue<>(); //ū ��� ��ȣ ����
		PriorityQueue<Integer> man_negative = new PriorityQueue<>(); //���� ��� ��ȣ ����
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			int height = Integer.parseInt(st.nextToken());
			
			if(height > 0) {
				man_positive.add(height);
			} else {
				man_negative.add(height * -1); //����� �ٲ���
			}
		}
		
		//����          
		PriorityQueue<Integer> woman_positive = new PriorityQueue<>(); //ū ��� ��ȣ ����
		PriorityQueue<Integer> woman_negative = new PriorityQueue<>(); //���� ��� ��ȣ ����
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			int height = Integer.parseInt(st.nextToken());
			
			if(height > 0) {
				woman_positive.add(height);
			} else {
				woman_negative.add(height * -1); //����� �ٲ���
			}
		}
		
		//����
		int count = 0;
		
		//���� ��� ��ȣ ����, ū ��� ��ȣ ����
		while(!man_negative.isEmpty() && !woman_positive.isEmpty()) {
			if(man_negative.peek() > woman_positive.peek()) {
				count++;
				woman_positive.poll();
			}
			man_negative.poll();
		}
		
		//ū ��� ��ȣ ����, ���� ��� ��ȣ ����
		while(!man_positive.isEmpty() && !woman_negative.isEmpty()) {
			if(man_positive.peek() < woman_negative.peek()) {
				count++;
				man_positive.poll();
			}
			woman_negative.poll();
		}
		
		System.out.println(count);
	}

}
