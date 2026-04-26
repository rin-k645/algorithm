import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int count = 0;
		for(int i = 0; i < N; i++) {
			Stack<Character> stack = new Stack<>();
			
			String input = br.readLine();
			
			boolean result = true;
			for(int j = 0; j < input.length(); j++) {
				if(!stack.contains(input.charAt(j))) {
					result = true;
				} else {
					if(stack.peek() == input.charAt(j))
						result = true;
					else {
						result = false;
						break;
					}
				}
				stack.push(input.charAt(j));
			}
			if(result == true)
				count++;
		}
		bw.write(count + "\n");
		bw.flush();
		bw.close();
	}

}
