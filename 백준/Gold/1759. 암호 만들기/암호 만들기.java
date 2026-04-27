import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static char[] arr;
	static char[] result;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[C];
		result = new char[L];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);
		combination(0, 0);
		System.out.println(sb);
	}
	
	public static void combination(int start, int depth) {
		if(depth == L) {
			if(isPossible()) { //조건에 맞으면
				//출력
				for(int i = 0; i < L; i++) {
					sb.append(result[i]);
				}
				sb.append('\n');
			}
			return;
		}
		for(int i = start; i < C; i++) {
			result[depth] = arr[i];
			combination(i + 1, depth + 1);
		}
	}
	
	public static boolean isPossible() {
		int vowel = 0;
		int consonant = 0;
		
		for(int i = 0; i < L; i++) {
			if(result[i] == 'a' || result[i] == 'e' || result[i] == 'i' || result[i] == 'o' || result[i] == 'u') {
				vowel++;
			}else {
				consonant++;
			}
		}
		
		if(vowel >= 1 && consonant >= 2) {
			return true;
		}else {
			return false;
		}	
	}

}