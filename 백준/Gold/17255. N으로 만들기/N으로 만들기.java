import java.io.*;
import java.util.*;

public class Main {
	static int count;
	static HashSet<String> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String N = br.readLine();
		
		set = new HashSet<>();
		
		recursive(N, "");
		
		System.out.println(set.size());
	}
	
	public static void recursive(String num, String pro) { //정수, 과정 저장 
		if(num.length() == 1) {
			if(!set.contains(pro)) {
				count++;
				set.add(pro);
			}
			return;
		}
		
		String frontRemoved = num.substring(1, num.length());
		String backRemoved = num.substring(0, num.length() - 1);
		
		recursive(frontRemoved, pro.concat(frontRemoved));
		recursive(backRemoved, pro.concat(backRemoved));
	}

}