import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] arr = br.readLine().toCharArray();
		
		//구현
		HashMap<Character, Character> map = new HashMap<>(); //다음에 올 단어 저장
		map.put('w', 'o');
		map.put('o', 'l');
		map.put('l', 'f');
		map.put('f', 'w');
		
		int answer = 1;
		int wCount = 0;
		int count = 0;
		char pre = 'w';
		for(int i = 0; i < arr.length; i++) {
			char cur = arr[i];
			
			if(cur == pre) { //이전 문자와 같음
				if(cur == 'w') wCount++;
				count++;
			} else { //이전 문자와 다름
				if(count == wCount && map.get(pre) == cur) { //w 개수와 같고, 와야 할 문자가 옴
					//카운트 1로 초기화
					if(cur == 'w') wCount = 1;
					count = 1;
				} else {
					answer = 0;
					break;
				}
			}
			pre = cur;
		}
		
		if(count != wCount || arr[arr.length - 1] != 'f') { //개수 다름 or 끝에가 f로 끝나지 않음
			answer = 0;
		}
		
		System.out.println(answer);
	}

}