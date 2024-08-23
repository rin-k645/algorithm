import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		//남성
		PriorityQueue<Integer> man_positive = new PriorityQueue<>();
		PriorityQueue<Integer> man_negative = new PriorityQueue<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			int height = Integer.parseInt(st.nextToken());
			
			if(height > 0) {
				man_positive.add(height);
			} else {
				man_negative.add(height * -1);
			}
		}
		
		//여성
		PriorityQueue<Integer> woman_positive = new PriorityQueue<>();
		PriorityQueue<Integer> woman_negative = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			int height = Integer.parseInt(st.nextToken());
			
			if(height > 0) {
				woman_positive.add(height);
			} else {
				woman_negative.add(height * -1);
			}
		}
		
		//구현
		int count = 0;
		
		//남자 음수, 여자 양수
		while(!man_negative.isEmpty() && !woman_positive.isEmpty()) {
			if(man_negative.peek() > woman_positive.peek()) {
				count++;
				woman_positive.poll();
			}
			man_negative.poll();
		}
		
		//남자 양수, 여자 음수
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