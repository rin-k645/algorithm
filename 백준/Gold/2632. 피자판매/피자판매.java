import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] A = new int[n];
		int[] B = new int[m];
		
		int sumA = 0;
		for(int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(br.readLine());
			sumA += A[i];
		}
		
		int sumB = 0;
		for(int i = 0; i < m; i++) {
			B[i] = Integer.parseInt(br.readLine());
			sumB += B[i];
		}
		
		//구현
		HashMap<Integer, Integer> Amap = new HashMap<>();
		HashMap<Integer, Integer> Bmap = new HashMap<>();
		
		Amap.put(0, 1);
		Bmap.put(0, 1);
		
		Amap.put(sumA, 1);
		Bmap.put(sumB, 1);
		
		for(int i = 0; i < n; i++) {
			int sum = 0;
			for(int j = i; j < i + n - 1; j++) {
				sum += A[j % n];
				Amap.put(sum, Amap.getOrDefault(sum, 0) + 1);
			}
		}
		
		for(int i = 0; i < m; i++) {
			int sum = 0;
			for(int j = i; j < i + m - 1; j++) {
				sum += B[j % m];
				Bmap.put(sum, Bmap.getOrDefault(sum, 0) + 1);
			}
		}
		
		//경우의 수 계산
		int answer = 0;
		
		for(int i = 0; i <= N; i++) {
			answer += Amap.getOrDefault(i, 0) * Bmap.getOrDefault(N - i, 0);
		}
		
		//출력
		System.out.println(answer);
	}

}