import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] size = br.readLine().split(" ");
		int N = Integer.parseInt(size[0]);
		int M = Integer.parseInt(size[1]);
		
		char[][] board = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			String row = br.readLine();
			
			for(int j = 0; j < M; j++) {
				board[i][j] = row.charAt(j);
			}
		}
		
		int result = 2500;
		for(int i = 0; i <= N - 8; i++) {
			for(int j = 0; j <= M - 8; j++) {
				//처음이 W일때
				int count_W = 0;
				char color = 'B';
				for(int a = i; a < i + 8; a++) {
					if(color == 'W') //다음 줄 색깔 기준
						color = 'B';
					else
						color = 'W';
					for(int b = j; b < j + 8; b++) {
						if(board[a][b] != color)
							count_W++;
						if(color == 'W') //다음 색깔 기준 바꿔주기
							color = 'B';
						else
							color = 'W';
					}
				}
				
				//처음이 B일때
				int count_B = 0;
				color = 'W';
				for(int a = i; a < i + 8; a++) {
					if(color == 'W') //다음 줄 색깔 기준
						color = 'B';
					else
						color = 'W';
					for(int b = j; b < j + 8; b++) {
						if(board[a][b] != color)
							count_B++;
						if(color == 'W') //다음 색깔 기준 바꿔주기
							color = 'B';
						else
							color = 'W';
					}
				}
				
				int min = 0;
				min = Math.min(count_W, count_B);
				result = Math.min(result, min);
			}
		}
		
		//출력
		System.out.println(result);
	}

}
