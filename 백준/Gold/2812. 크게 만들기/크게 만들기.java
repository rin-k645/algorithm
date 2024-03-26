import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
	
		String str = br.readLine();
		
		int[] arr = new int[str.length()];
		for(int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i) - '0';
		}
		
		Stack<Integer> stack = new Stack<>();
		
		int count = 0;

		for(int n : arr) {
			while(!stack.isEmpty() && stack.peek() < n && count < K) {
				stack.pop();
				count++;
			}
			
			stack.add(n);
			
//			for(int i : stack) {
//				System.out.print(i);
//			}
//			System.out.println();
		}
		
//		System.out.println(count);
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			if(count < K) {
				stack.pop();
				count++;
			} else {
				sb.append(stack.pop());
			}
		}
		
		System.out.println(sb.reverse());
	}

}