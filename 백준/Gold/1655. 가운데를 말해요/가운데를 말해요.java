import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(i == 0) {
				maxHeap.add(num);
			} else if(i == 1) {
				if(num < maxHeap.peek()) {
					minHeap.add(maxHeap.poll());
					maxHeap.add(num);
				} else {
					minHeap.add(num);
				}
			} else {
				if(num <= minHeap.peek()) {
					maxHeap.add(num);
				} else {
					minHeap.add(num);
				}
				
				if(minHeap.size() > maxHeap.size()) {
					maxHeap.add(minHeap.poll());
				} else if(minHeap.size() + 1 < maxHeap.size()) {
					minHeap.add(maxHeap.poll());
				}
			}
			
			sb.append(maxHeap.peek()).append("\n");
		}
		
		System.out.println(sb);
	}

}