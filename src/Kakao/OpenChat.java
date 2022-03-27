package Kakao;

import java.util.ArrayList;
import java.util.HashMap;

public class OpenChat {

	public static void main(String[] args) {		
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		
		String[] result = solution(record);
		
		for(String str : result) {
			System.out.println(str);
		}
	}
	
    public static String[] solution(String[] record) {
        HashMap<String, String> userMap = new HashMap<>();
        ArrayList<String[]> stateRecord = new ArrayList<>();
        
        for(String i : record) {
        	String[] str1 = i.split(" "); //ÆÄ½Ì
        	
        	String state = str1[0];
        	String uid = str1[1];
        	
        	if(state.contains("Enter")) {
        		String nickname = str1[2];
        		
        		userMap.put(uid, nickname);
        		
        		String[] str2 = new String[2];
        		str2[0] = state;
        		str2[1] = uid;
        		
        		stateRecord.add(str2);
        		
        	} else if(state.contains("Leave")) {
        		String[] str2 = new String[2];
        		str2[0] = state;
        		str2[1] = uid;
        		
        		stateRecord.add(str2);
        	
        		
        	} else if(state.contains("Change")) {
        		String nickname = str1[2];
        		
        		userMap.put(uid, nickname);
        	}
        }
        
        String[] answer = new String[stateRecord.size()];
        
        for(int i = 0; i < answer.length; i++) {
        	String[] str3 = stateRecord.get(i);
        	
        	String state = str3[0];
        	String uid = str3[1];
        	
        	if(state.contains("Enter")) {
        		answer[i] = userMap.get(uid) + "´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.";
        	} else if(state.contains("Leave")) {
        		answer[i] = userMap.get(uid) + "´ÔÀÌ ³ª°¬½À´Ï´Ù.";
        	}
        }
        
        return answer;
    }

}
