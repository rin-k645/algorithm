import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] train = new int[N + 1]; // 좌석 상태를 비트로 저장
		
		for(int m = 0; m < M; m++) {
			// 입력
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken());
			
			// 명령 처리
			if(command == 1) {
				int x = Integer.parseInt(st.nextToken());
				train[i] |= (1 << (x - 1)); // x번째 비트를 1로 변경
			} else if(command == 2) {
				int x = Integer.parseInt(st.nextToken());
				train[i] &= ~(1 << (x - 1)); // x번째 비트를 0으로 변경
			} else if(command == 3) {
				train[i] &= ~(1 << 19); //20번째 자리 하차
				train[i] <<= 1; // 한칸씩 뒤로 이동
			} else if(command == 4) {
				train[i] &= ~1; //1번째 자리 하차
				train[i] >>= 1; // 한칸씩 앞으로 이동
			}
		}
		
		HashSet<Integer> set = new HashSet<>();
		for(int i = 1; i <= N; i++) {
			set.add(train[i]);
		}
		
		System.out.println(set.size());
	}

}