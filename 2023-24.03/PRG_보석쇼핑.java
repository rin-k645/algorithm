package algorithm;

import java.util.*;

public class PRG_∫∏ºÆºÓ«Œ {

	public static void main(String[] args) {
		int[] answer = solution(new String[] {"ZZZ", "YYY", "NNNN", "YYY", "BBB"});
		System.out.println(answer[0] + ", " + answer[1]);
	}
	
	public static int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<>();
        for(String gem : gems) {
            set.add(gem);
        }
        
        int left = 0, right = 0;
        int target = set.size();
        int min = 100000;
        int[] answer = new int[2];
        
        HashMap<String, Integer> map = new HashMap<>();
        
        while(true) {
        	if(right == gems.length) {
                break;
            }
        	
            if(map.size() >= target) {
            	if(map.get(gems[left]) > 1) {
            		map.put(gems[left], map.getOrDefault(gems[left], 0) - 1);
                    left++;
            	}
            } else if (map.size() < target) {
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                right++;
            }
            
            if (map.size() == target && right - left < min) {
                min = right - left;
                answer[0] = left + 1;
                answer[1] = right;
            }
        }
        
        return answer;
    }

}
