import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();
		String K = br.readLine();
		
		String str = S.replaceAll("[0-9]", "");
		
		int answer = 0;
		answer = (str.contains(K)) ? 1 : 0;
		System.out.println(answer);
	}

}