package Kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Tuple {

	public static void main(String[] args) {
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		int[] answer = solution(s);

		for(int i : answer) {
			System.out.print(i + " ");		
		}
	}
	
    public static int[] solution(String s) {
    	String sub1 = s.substring(2, s.length() - 2).replace("},{", "-");
    	String[] strs = sub1.split("-");
    	
    	HashMap<Integer, Integer> map = new HashMap<>(); //<원소, 등장 횟수> 쌍으로 저장
    	
    	for(String str : strs) {
    		String[] val = str.split(",");
    		
    		for(int i = 0 ; i < val.length ; i++) {
    			int n = Integer.parseInt(val[i]);
    			
    			if(!map.containsKey(n)) { //없는 숫자면
    				map.put(n, 1); //새로 추가
    			} else { //있으면
    				int count = map.get(n) + 1; //카운트 1 늘림
    				map.replace(n, count);
    			}
    		}
    	}
    	
    	//해시맵 내림차순 정렬
    	List<Entry<Integer, Integer>> list_entries = new ArrayList<Entry<Integer, Integer>>(map.entrySet());

    	Collections.sort(list_entries, new Comparator<Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
    		
    	});
    	
    	int[] answer = new int[map.size()];
    	
    	for(int i = 0; i < list_entries.size(); i++) { //많이 등장한 순으로 배열 저장
    		answer[i] = list_entries.get(i).getKey();
		}
        
        return answer;
    }

}
