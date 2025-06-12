import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 큐 내림차순 정렬
		PriorityQueue<Integer> positive = new PriorityQueue<>((o1, o2) -> o2 - o1);
		PriorityQueue<Integer> negative = new PriorityQueue<>((o1, o2) -> o2 - o1);
		int max = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int dist = Integer.parseInt(st.nextToken());
			
			if(dist > 0) {
				positive.add(dist);
				max = Math.max(max, dist);
			} else {
				negative.add(Math.abs(dist));
				max = Math.max(max, Math.abs(dist));
			}
		}
		
		int answer = 0;
		int count = 0;
		while(!positive.isEmpty()) {
			int p = positive.poll();
			
			if(count % M == 0) {
				answer += p * 2;
			}
			count++;
		}
		
		count = 0;
		while(!negative.isEmpty()) {
			int p = negative.poll();
			
			if(count % M == 0) {
				answer += p * 2;
			}
			count++;
		}
		
		answer -= max;
		
		System.out.println(answer);
		
		
	}

}
