import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int money = Integer.parseInt(br.readLine());
		
		int[] stock = new int[14];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 14; i++) {
			stock[i] = Integer.parseInt(st.nextToken());
		}
		
		// 준현
		int junhyun = money;
		int count = 0;
		for(int i = 0; i < 14; i++) {
			int num = junhyun / stock[i];
			
			if(junhyun > 0 && num > 0) {
				count += num;
				junhyun -= (stock[i] * num);
			}
		}
		
		junhyun += stock[13] * count;
		
		// 성민
		int sungmin = money;
		count = 0;
		for(int i = 3; i < 14; i++) {
			if(stock[i - 3] > stock[i - 2] && stock[i - 2] > stock[i - 1]) {
				int num = sungmin / stock[i];
				
				if(sungmin > 0 && num > 0) {
					count += num;
					sungmin -= (stock[i] * num);
				}
			} else if(stock[i - 3] < stock[i - 2] && stock[i - 2] < stock[i - 1]) {
				if(count > 0) {
					sungmin += (stock[i] * count);
					count = 0;
				}
			}
		}
		
		sungmin += stock[13] * count;
		
		if(junhyun > sungmin) {
			System.out.println("BNP");
		} else if(junhyun < sungmin) {
			System.out.println("TIMING");
		} else {
			System.out.println("SAMESAME");
		}
	}

}
