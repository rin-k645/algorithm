package 프로그래머스;

import java.util.Arrays;

public class PhoneNumberList {

	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		boolean answer = solution(phone_book);
		System.out.println(answer);
	}
	
    public static boolean solution(String[] phone_book) {
    	Arrays.sort(phone_book);
    	
    	for(int i = 0; i < phone_book.length - 1; i++) {
    		if(phone_book[i + 1].startsWith(phone_book[i])) {
    			return false;
    		}
    	}
    	
    	return true;
    }

}
