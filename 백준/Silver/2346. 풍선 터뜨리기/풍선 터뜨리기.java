import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		Deque<int[]> deque = new ArrayDeque<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		int value = arr[0];
		int idx = 1;
		sb.append(idx + " ");
		
		for(int i = 1; i < N; i++) {
			deque.add(new int[]{i + 1, arr[i]});
		}
		
		while(!deque.isEmpty()) {
			if(value > 0) {
				for(int i = 1; i < value; i++) {
					deque.addLast(deque.pollFirst());
				}
				int[] p = deque.pollFirst();
				idx = p[0];
				value = p[1];
			} else {
				for(int i = 1; i < Math.abs(value); i++) {
					deque.addFirst(deque.pollLast());
				}
				int[] p = deque.pollLast();
				idx = p[0];
				value = p[1];
			}
			
			sb.append(idx + " ");
		}
		
		// 출력
		System.out.println(sb);
	}

}