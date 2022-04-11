//백준 1074번 : https://www.acmicpc.net/problem/1074

package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Z {
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int r = Integer.parseInt(input[1]);
		int c = Integer.parseInt(input[2]);
		
		int size = (int) Math.pow(2, N);
		
		z(size, r, c);
		
		System.out.println(count);
	}

	public static void z(int size, int r, int c) {
		if(size == 1) {
			return;
		} else if(r < size / 2 && c < size / 2) { //1사분면에 있을시
			z(size / 2, r, c);
		} else if(r < size / 2 && c >= size / 2) { //2사분면에 있을시
			count += size * size / 4;
			z(size / 2, r, c - size/2);
		} else if(r >= size / 2 && c < size / 2) { //3사분면에 있을시
			count += (size * size / 4) * 2;
			z(size / 2, r - size / 2, c);
		} else if(r >= size / 2 && c >= size / 2) { //4사분면에 있을시
			count += (size * size / 4) * 3;
			z(size / 2, r - size / 2, c - size/2);
		}
	}

}
