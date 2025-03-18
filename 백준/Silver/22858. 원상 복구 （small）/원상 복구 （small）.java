import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] S, D;

	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		S = new int[N + 1];
		D = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			D[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < K; i++) {
			suffle();
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.print(S[i] + " ");
		}
	}

	public static void suffle() {
		int[] tmp = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			tmp[D[i]] = S[i];
		}
		
		S = tmp;
	}

}
