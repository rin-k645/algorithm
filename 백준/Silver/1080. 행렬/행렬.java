import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] size = br.readLine().split(" ");
		
		int N = Integer.parseInt(size[0]);
		int M = Integer.parseInt(size[1]);
		
		int [][]A = new int[N][M];
		int [][]B = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			
			for(int j = 0; j < M; j++) {
				A[i][j] = input.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			
			for(int j = 0; j < M; j++) {
				B[i][j] = input.charAt(j) - '0';
			}
		}
		
		int count = 0;
		for(int i = 0; i <= N - 3; i++) {
			for(int j = 0; j <= M - 3; j++) {
				if(A[i][j] != B[i][j]) {
					count++;
				
					for(int p = i; p < i + 3; p++) {
						for(int q = j; q < j + 3; q++) {
							if(A[p][q] == 0)
								A[p][q] = 1;
							else
								A[p][q] = 0;
						}
					}
				}
			}
		}
		
		Boolean result = true;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(A[i][j] != B[i][j]) {
					result = false;
					break;
				}
			}
		}
		
		if(result == false)
			System.out.println("-1");
		else
			System.out.println(count);
		
	}

}
