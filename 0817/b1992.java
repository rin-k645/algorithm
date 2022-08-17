import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[][] video;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		video = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String row = br.readLine();
			for(int j = 0; j < N; j++) {
				video[i][j] = row.charAt(j) - '0';
			}
		}
		
		//압축 수행
		compress(0, 0, N);
		
		//출력
		System.out.println(sb);
	}
	
	public static void compress(int x, int y, int N) {
		int num = video[x][y]; //배열의 가장 첫 값
		boolean flag = true;
		
		for(int i = x; i < x + N; i++) {
			for(int j = y; j < y + N; j++) {
				if(video[i][j] != num) {
					flag = false;
					break;
				}
			}
		}
		
		//종료 조건
		if(flag == true) { //영상이 모두 같은 숫자로만 되어있으면, 출력하고 리턴
			sb.append(num);
			return;
		}
		
		//재귀
		if(flag == false) {
			sb.append("(");
			compress(x, y, N / 2); //왼쪽 위
			compress(x, y + N / 2, N / 2); //오른쪽 위
			compress(x + N / 2, y, N / 2); //왼쪽 아래
			compress(x + N / 2, y + N / 2, N / 2); //오른쪽 아래
			sb.append(")");
		}
		
	}

}
