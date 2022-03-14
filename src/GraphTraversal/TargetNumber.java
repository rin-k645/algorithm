package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TargetNumber {
	static int count = 0;
	static char[] sign;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(", ");
		
		int[] numbers = new int[input.length];
		for(int i= 0; i < input.length; i++) {
			numbers[i] = Integer.parseInt(input[i]);
		}
		
		int target = Integer.parseInt(br.readLine());
		
		int answer = solution(numbers, target);
		
		System.out.println(answer);

	}
	
	 public static int solution(int[] numbers, int target) {
		 	sign = new char[numbers.length];
		 	
	        permutation(numbers, numbers.length, target, 0);
	        
	        return count;
	 }
	 
	 public static void permutation(int[] numbers, int length, int target, int depth) {
			if(depth == length) {
				int sum = calculate(sign, numbers);
				
				System.out.println("= " + sum);
				
				if(sum == target) {
					count++;
				}
				
				return;
			}
			
			for(int i = 0; i < 2; i++) {
				if(i == 0) { //+ 선택
					sign[depth] = '+';
				}
				
				if(i == 1) { //- 선택
					sign[depth] = '-';
				}
				
				permutation(numbers, length, target, depth + 1);
			}	
		}

	public static int calculate(char[] sign, int[] numbers) {
		int sum = 0;
		
		for(int i = 0; i < sign.length; i++) {
			if(sign[i] == '+') {
				sum += numbers[i];
				System.out.print("+" + numbers[i] + " ");
			}
			
			if(sign[i] == '-') {
				sum -= numbers[i];
				System.out.print("-" + numbers[i] + " ");
			}
		}
		
		return sum;
	}

}
