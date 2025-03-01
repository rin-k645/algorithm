import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 1; i <= N; i++) {
			list.add(i);
		}
		
		int t = 1;
		int idx = 0;
		while(list.size() > 1) {
			long t3 = (long) Math.pow(t, 3);
			idx = (int)((idx + t3 - 1) % list.size());
			list.remove(idx);
			t++;
		}
		
		System.out.println(list.get(0));
	}

}