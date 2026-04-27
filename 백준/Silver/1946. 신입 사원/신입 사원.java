import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] grades = new int[N][2];
			
			for(int j = 0; j < N; j++) {
				String[] input = br.readLine().split(" ");
				
				grades[j][0] = Integer.parseInt(input[0]);
				grades[j][1] = Integer.parseInt(input[1]);
			}
			
			//계산
			Arrays.sort(grades, new Comparator<int[]>() {
				@Override
				public int compare(int[] a, int[] b) {
					return a[0] - b[0]; //2차원 배열의 첫번째 값 기준으로 오름차순 정렬
				}
			});
			
			int count = 1; //첫번째는 무조건 선발
			
			int standard = grades[0][1];
			for(int j = 1; j < N; j++) {
				if(grades[j][1] < standard) { //기준보다 순위 낮으면 합격
					count++;
					standard = grades[j][1]; //기준 갱신
				}
			}
			
			//출력
			sb.append(count + "\n");
		}
		
		System.out.println(sb);
	}

}