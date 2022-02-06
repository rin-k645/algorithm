package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FindPrimeNumber {
	static boolean[] visited;
	static char[] result;
	static int count = 0;
	static ArrayList<Integer> nums = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String numbers = br.readLine();
		
		int answer = solution(numbers);
		
		System.out.println(answer);
	}
	
	public static int solution(String numbers) {
		char[] chs = numbers.toCharArray(); //���� �迭�� ��ȯ
		
		for(int i = 1; i <= chs.length; i++) {
			result = new char[i];
			visited = new boolean[chs.length];
			
			permutation(chs, i, 0); //����
		}
		
		for(int num : nums) { //�Ҽ� �Ǻ�
			if(isPrimeNumber(num)) {
				count++;
			}	
		}
		
		int answer = count;
        return answer;
    }
	
	public static void permutation(char[] chs, int length, int depth) {
		if(depth == length) {
			int num = Integer.parseInt(String.valueOf(result)); //char �迭 int ��ȯ
			
			if(!nums.contains(num)) { //���� �ߺ� Ȯ��
				nums.add(num);
			}
			
			return;
		}
		
		for(int i = 0; i < chs.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[depth] = chs[i];
				permutation(chs, length, depth + 1);
				visited[i] = false;
			}
		}

	}

	public static boolean isPrimeNumber(int num) {
		if(num < 2) {
			return false;
		}
		if(num == 2) {
			return true;
		}
				
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
