package Kakao;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class NewsClustering {

	public static void main(String[] args) {
		String str1 = "aa1+aa2";
		String str2 = "AAAA12";
		
		
		int result = solution(str1, str2);
		
		System.out.println(result);
	}

    public static int solution(String str1, String str2) {
    	ArrayList<String> s1 = new ArrayList<>();
    	ArrayList<String> s2 = new ArrayList<>();
    	ArrayList<String> intersection = new ArrayList<>();
    	ArrayList<String> union = new ArrayList<>();
    	
    	for(int i  = 0; i < str1.length() - 1; i++) { // str1 다중집합 만들기
    		String temp1 = str1.substring(i, i + 2);
    		
    		if(Pattern.matches("^[a-zA-Z]*$", temp1)) {
    			String temp2 = temp1.toUpperCase();
    			s1.add(temp2);
    		}
    	}
    	
    	for(int i  = 0; i < str2.length() - 1; i++) { // str2 다중집합 만들기
    		String temp1 = str2.substring(i, i + 2);
    		
    		if(Pattern.matches("^[a-zA-Z]*$", temp1)) {
    			String temp2 = temp1.toUpperCase();
    			s2.add(temp2);
    		}
    	}
    	
    	//교집합, 합집합 구하기
    	for(String str : s1) {
    		if(s2.remove(str)) {
    			intersection.add(str);
    		}
    		union.add(str);
    	}
    	
    	for(String str : s2) {
    		union.add(str);
    	}
    	
    	//계산하기
    	int A = intersection.size();
    	int B = union.size();
    	
    	double J = 0;
    	if(A == 0 && B ==0) {
    		J = 1;
    	} else {
    		J = (double)A / (double)B;
    	}
    	
        int answer = (int) (J * 65536);
        
        return answer;
    }
}
