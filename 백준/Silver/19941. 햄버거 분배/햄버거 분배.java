import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		char[] table = br.readLine().toCharArray();
		boolean[] taken = new boolean[N];
		
		int count = 0;
		for(int i = 0; i < N; i++) {
			if(table[i] == 'H') continue;
			
			for(int j = i - K; j <= i + K; j++) {
				if(j < 0 || N <= j) continue;
				
				if(table[j] == 'H' && !taken[j]) {
					count++;
					taken[j] = true;
					break;
				}
			}
		}
		
		System.out.println(count);
	}

}