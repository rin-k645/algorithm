import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b15662 {
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		arr = new int[T + 1][8];
		
		for(int i = 1; i <= T; i++) {
			String line = br.readLine();
			
			for(int j = 0; j < 8; j++) {
				arr[i][j] = line.charAt(j) - '0'; // N극은 0, S극은 1
			}
		}
		
		//구현
		int K = Integer.parseInt(br.readLine()); //회전 횟수
		
		for(int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken()); //회전시킨 톱니바퀴 번호
			int D = Integer.parseInt(st.nextToken()); //방향 : 시계 1, 반시계 -1
			
			int dir[] = new int[T + 1]; //톱니 바퀴 방향
			dir[N] = D;
			
			//톱니 바퀴 방향 정하기
			for(int i = N; i <= T - 1; i++) { //N~T번
				if(dir[i] == 0) { //회전 안하는 톱니면
					dir[i + 1] = 0; //다음 톱니도 회전X
				}else {
					if(arr[i][2] == arr[i + 1][6]) { //톱니 극이 같음
						dir[i + 1] = 0; //다음 톱니는 회전x
					}else { //톱니 극이 다름
						if(dir[i] == 1) { //시계라면
							dir[i + 1] = -1; //다음 톱니는 반시계로
						}else if(dir[i] == -1) { //반시계라면
							dir[i + 1] = 1; //다음 톱니는 시계로
						}
					}
				}
			}
			
			for(int i = N; i >= 2; i--) { //N~1번
				if(dir[i] == 0) { //회전 안하는 톱니면
					dir[i - 1] = 0; //이전 톱니도 회전X
				}else {
					if(arr[i][6] == arr[i - 1][2]) { //톱니 극이 같음
						dir[i - 1] = 0; //이전 톱니는 회전x
					}else { //톱니 극이 다름
						if(dir[i] == 1) { //시계라면
							dir[i - 1] = -1; //이전 톱니는 반시계로
						}else if(dir[i] == -1) { //반시계라면
							dir[i - 1] = 1; //이전 톱니는 시계로
						}
					}
				}
			}
			
			//방향대로 회전시키기
			for(int i = 1; i <= T; i++) {
				if(dir[i] == 1) { //시계 방향
					clockwise(i);
				}else if(dir[i] == -1) { //반시계 방향
					counterClockwise(i);
				}
			}
		}
		
		//출력
		int count = 0;
		for(int i = 1; i <= T; i++) {
			if(arr[i][0] == 1) {
				count++;
			}
		}
		
		System.out.println(count);

	}

	public static void clockwise(int n) {
		int tmp = arr[n][7];
		
		for(int i = 7; i >= 1; i--) {
			arr[n][i] = arr[n][i - 1];
		}
		arr[n][0] = tmp;
	}
	
	public static void counterClockwise(int n) {
		int tmp = arr[n][0];
		
		for(int i = 0; i <= 6; i++) {
			arr[n][i] = arr[n][i + 1];
		}
		arr[n][7] = tmp;
	}

}
