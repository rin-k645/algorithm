package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfPaper {
	static int[] count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][N];

		for(int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		count = new int[3];
		
		paper(arr, 0, 0, N);
		
		System.out.println(count[0]);
		System.out.println(count[1]);
		System.out.println(count[2]);
	}

	public static void paper(int[][] arr, int x, int y, int n) {
		int num = arr[x][y];
		boolean isSame = true;
		
		for(int i = x; i < x + n; i++) {
			for(int j = y; j < y + n; j++) {
				if(arr[i][j] != num) {
					isSame = false;
					break;
				}
			}
		}
		
		if(isSame) {
			if(num == -1) {
				count[0]++;
			} else if(num == 0) {
				count[1]++;
			} else if(num == 1) {
				count[2]++;
			}
			
			return;
		} else {
			paper(arr, x, y, n / 3);
			paper(arr, x, y + n / 3, n / 3);
			paper(arr, x, y + n / 3 * 2, n / 3);
			paper(arr, x + n / 3, y, n / 3);
			paper(arr, x + n / 3, y + n / 3, n / 3);
			paper(arr, x + n / 3, y + n / 3 * 2, n / 3);
			paper(arr, x + n / 3 * 2, y, n / 3);
			paper(arr, x + n / 3 * 2, y + n / 3, n / 3);
			paper(arr, x + n / 3 * 2, y + n / 3 * 2, n / 3);
		}
		
	}

}
