import java.util.Scanner;

public class Main {
	static int[] hats;
	static boolean[] visited;
	static int[] result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		hats = new int[9];
		
		for(int i = 0; i < 9; i++) {
			hats[i] = sc.nextInt();
		}
		
		visited = new boolean[9];
		result = new int[7];
		
		combination(0, 0);

	}

	public static void combination(int start, int depth) {
		if(depth == 7) {
			int sum = 0;
			
			for(int n : result) {
				sum += n;
			}
			
			if(sum == 100) {
				for(int n : result) {
					System.out.println(n);
				}
			}
			
			return;
		}
		
		for(int i = start; i < 9; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			result[depth] = hats[i];
			combination(i + 1, depth + 1);
			visited[i] = false;
		}
	}
}
