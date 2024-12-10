import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		int bCount = 0; //연속된 색 묶음
		int rCount = 0;
		
		char pre = '.';
		for(int i = 0; i < N; i++) {
			char ch = str.charAt(i);
			
			if(ch != pre) {
				if(ch == 'B') bCount++;
				else rCount++;
			}
			pre = ch;
		}
		
		System.out.println(Math.min(bCount, rCount) + 1); //최소 묶음 개수 + 전체 1번 칠하는 경우
	}

}