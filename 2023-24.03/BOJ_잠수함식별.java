package algorithm;

import java.io.*;

public class BOJ_����Խĺ� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		boolean result = str.matches("^(100+1+|01)+$");
		
		System.out.println(result ? "SUBMARINE": "NOISE");
	}

}
