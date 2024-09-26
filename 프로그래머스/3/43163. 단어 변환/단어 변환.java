import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        queue.add(begin);
        
        int answer = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int s = 0; s < size; s++) {
                String str = queue.poll();
            
                if(str.equals(target)) return answer;
                
                for(int i = 0; i < words.length; i++) {
                    if(!visited[i] && check(str, words[i])) {
                        queue.add(words[i]);
                        visited[i] = true;
                    }
                }
            }
            answer++;
        }
        
        return 0;
    }
    
    private boolean check(String s1, String s2) {
        int count = 0;
        
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) count++;
        }
        
        return count == 1 ? true : false;
    }
}