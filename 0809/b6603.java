import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b6603 {
	static int k;
	static int[] S;
	static boolean[] visited;
	static int[] result;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] row = br.readLine().split(" ");
			
			if(Integer.parseInt(row[0]) == 0)
				break;
			
			k = Integer.parseInt(row[0]);
			S = new int[k];
			
			for(int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(row[i + 1]);
			}
			
			visited = new boolean[k];
			result = new int[6];
			
			combination(0, 0);
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	public static void combination(int start, int depth) {
		if(depth == 6) {
			print(result);
			return;
		}
		for(int i = start; i < k; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			result[depth] = S[i];
			combination(i + 1, depth + 1);
			visited[i] = false;
		}
	}
	
	public static void print(int[] result) {
		for(int i = 0; i < 6; i++) {
			sb.append(result[i]).append(" ");
		}
		sb.append("\n");	
	}

}
