import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); //접시의 수
		int d = Integer.parseInt(st.nextToken()); //초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken()); //쿠폰 번호
		
		int[] belt = new int[N + k - 1];
		
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			belt[i] = n;
		}
		
		for(int i = N; i < N + k - 1; i++) { //뒤에 k - 1 만큼 추가
			belt[i] = belt[i - N];
		}
		
		int[] kind = new int[d + 1]; //초밥 종류 먹었는지 체크
		
		for(int i = 0; i < k; i++) { //초기 세팅 : 0~k-1 접시에 담기
			kind[belt[i]]++;
		}
		
		int count = 0;
		for(int n : kind) {
			if(n != 0) {
				count++;
			}
		}
		
		int max = 0;
		if(kind[c] == 0) { //쿠폰 초밥이 벨트위에 없음
			max = count + 1; //새로운 종류 제공
		} else {
			max = count;
		}

		for(int i = k; i < N + k - 1; i++) {
			//앞쪽 빼기
			kind[belt[i - k]]--;
			if(kind[belt[i - k]] == 0) {
				count--;
			}
			
			//뒤쪽 추가하기
			if(kind[belt[i]] == 0) {
				count++;
			}
			kind[belt[i]]++;
			
			if(kind[c] == 0) { //쿠폰 초밥이 벨트위에 없음
				max= Math.max(max, count + 1);
			} else {
				max= Math.max(max, count);
			}
		}
		
		//출력
		System.out.println(max);
	}

}
