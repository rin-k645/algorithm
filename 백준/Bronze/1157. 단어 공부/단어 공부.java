import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] vocab = br.readLine().toCharArray();
		
		int[] alphabet = new int[26];
		
		for(char ch : vocab) {
			if(ch >= 97) {
				alphabet[(int)ch - 97]++;
			} else {
				alphabet[(int)ch - 65]++;
			}
		}
		
		int idx = 0;
		int max = 0;
		boolean isMultiful = false;
		for(int i = 0; i < 26; i++) {
			if(alphabet[i] >= max) {
				if(alphabet[i] == max) {
					isMultiful = true;
				} else {
					idx = i;
					max = alphabet[i];
					isMultiful = false;
				}
			}
		}
		
		char answer = isMultiful ? '?' : (char)(idx + 65);
		System.out.println(answer);
	}

}