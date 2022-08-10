import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b17406 {
	static int N, M, K;
	static int[][] A;
	static boolean[] visited;
	static Operation[] ops;
	static Operation[] result;
	static int min = Integer.MAX_VALUE;
	
	static class Operation {
		int r;
		int c;
		int s;
		
		public Operation(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		A = new int[N + 1][M + 1];

		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 1; j <= M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ops = new Operation[K];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			ops[i] = new Operation(r, c, s);
		}
		
		//연산에 대해 순열
		visited = new boolean[K];
		result = new Operation[K];
		
		permutation(0);
		
		//출력
		System.out.println(min);
	}

	public static void permutation(int count) {
		if(count == K) {
			for(int i = 0; i < K; i++) {
				rotate(result[i].r, result[i].c, result[i].s);
//				print();
			}
			
			int a = Integer.MAX_VALUE;
			for(int i = 1; i <= N; i++) { //배열 A의 값 구하기
				int sum = 0;
				for(int j = 1; j <= M; j++) {
					sum += A[i][j];
				}
				a = Math.min(a, sum);
			}
			
			min = Math.min(min, a); //A값의 최솟값 갱신
			
			return;
		}
		
		for(int i = 0; i < K; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			result[count] = ops[i];
			permutation(count + 1);
			visited[i] = false;
		}
	}

//	public static void print() {
//		for(int i = 1; i <= N; i++) {
//			for(int j = 1; j <= M; j++) {
//				System.out.print(A[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}

	public static void rotate(int r, int c, int s) {
		int depth = (s * 2 + 1) / 2;
		
		for(int d = 0; d < depth; d++) {
			int tmp = A[r - s + d][c - s + d];
			
			for(int i = c - s + d; i < (c + s - d); i++) { // →
				A[r - s + d][i] = A[r - s + d][i + 1];
			}
			
			for(int i = r - s + d; i < (r + s - d); i++) { // ↓
				A[i][c + s - d] = A[i + 1][c + s - d]; 
			}
			
			for(int i = (c + s - d); i >= (c - s + d + 1); i--) { // ←
				A[r + s - d][i] = A[r + s - d][i - 1]; 
			}
			
			for(int i = (r + s - d); i >= (r - s + d + 1); i--) { // ↑
				A[i][c - s + d] = A[i - 1][c - s + d]; 
			}
			
			A[r - s + d + 1][c - s + d] = tmp;
		}

		
	}

}
