import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1244 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //스위치 개수
		int[] arr = new int[N + 1]; //스위치 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine()); //학생 수
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int gender = Integer.parseInt(st.nextToken()); //학생의 성별
			int num = Integer.parseInt(st.nextToken()); //학생이 받은 수
			
			//구현
			if(gender == 1) { //남학생인 경우
				int k = 1; //배수 카운트
				for(int j = num; j < N + 1; j = num * k) {
					arr[j] = (arr[j] == 0) ? 1 : 0; //스위치 조작
					k++;
				}
			} else { //여학생인 경우
				int k = 1; //대칭 얼마나 떨어져 있는지 카운트
				while(1 <= num - k && num + k <= N) {
					if(arr[num - k] != arr[num + k]) { //좌우 대칭 아님
						k--;
						break;
					} else { //좌우 대칭
						k++;
					}
				}
				
				if(1 > num - k || num + k > N) { //중간에 안멈춘 경우
					k--;
				}
				for(int j = num - k; j <= num + k; j++) {
					arr[j] = (arr[j] == 0) ? 1 : 0; //스위치 조작
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < N + 1; i++) {
			if(i > 1 && i % 20 == 1) {
				sb.append("\n");
			}
			sb.append(arr[i] + " ");
		}
		
		System.out.println(sb);

	}

}
