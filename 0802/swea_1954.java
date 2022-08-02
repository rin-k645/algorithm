import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1954 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
	
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
		
			int[][] arr = new int[N][N];
			
			int count = 1;
			int x = 0; //좌표 시작점
			int y = -1;
			int k = N; //패턴 내에서 지속 횟수
			
			//오른쪽(→), 아래(↓), 왼쪽(←), 위쪽(↑) 4가지 패턴이 반복됨
			for(int i = 0; i < N * 2 - 1; i++) { //(N * 2)-1 : 패턴 반복 수
				if(i % 2 == 1) { //짝수번째면 패턴 지속 횟수가 줄어듦
					k--;
				}
					
				for(int j = 0; j < k; j++) {
					if(i % 4 == 0) { //오른쪽(→)
						y++; //y좌표 중가
					} else if(i % 4 == 1) { //아래(↓)
						x++; //x좌표 증가
					} else if(i % 4 == 2) { //왼쪽(←)
						y--; //y좌표 감소
					} else { //위쪽(↑)
						x--; //y좌표 감소
					}
						
					arr[x][y] = count++;
				}
					
			}
			
			//출력
			System.out.println("#" + test_case);
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
