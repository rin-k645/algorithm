package algorithm;

import java.io.*;

public class BOJ_¿°»öÃ¼ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			String str = br.readLine();
			
			boolean result = str.matches("^(A|B|C|D|E|F)?A+F+C+(A|B|C|D|E|F)?$");
			
			sb.append(result ? "Infected!": "Good").append("\n");
		}
		System.out.println(sb);
	}

}
