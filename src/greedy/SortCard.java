package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SortCard {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		
		for(int i = 0; i < N; i++) {
			pq.add(Long.parseLong(br.readLine()));
		}
		
		long answer = 0;
		while(pq.size() > 1) {
			long n1 = pq.poll();
			long n2 = pq.poll();
			
			answer = answer + n1 + n2;
			pq.add(n1 + n2);
		}
		
		System.out.println(answer);
	}

}
