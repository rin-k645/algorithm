import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r, c;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
	
		int size = (int) Math.pow(2, N);
		
		z(0, 0, size);
		
		System.out.println(count);
	}

	public static void z(int i, int j, int size) {
		if(size == 1) { //종료조건
			return;
		}
		
		if(r < i + size / 2 && c < j + size / 2) { //1사분면에 위치
			z(i, j, size / 2);
		}else if(r < i + size / 2 && j + size / 2 <= c) { //2사분면에 위치
			count += size * size / 4;
			z(i, j + size / 2, size / 2);
		}else if(i + size / 2 <= r && c < j + size / 2) { //3사분면에 위치
			count += size * size / 4 * 2;
			z(i + size / 2, j, size / 2);
		}else { //4사분면에 위치
			count += size * size / 4 * 3;
			z(i + size / 2, j + size / 2, size / 2);
		}	
	}

}