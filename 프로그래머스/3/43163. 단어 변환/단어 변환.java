class Solution {
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        dfs(begin, target, words, 0);
        return answer;
    }
    
    public static void dfs(String begin, String target, String[] words, int count) {
		if(begin.equals(target)) { //종료 조건
			answer = count;
			return;
		}
		
		for(int i = 0; i < words.length; i++) {
			if(!visited[i]) { //방문하지 않은 단어면
				int same = 0;
				for(int j = 0; j < begin.length(); j++) { //몇 글자 같은지 구하기
					if(begin.charAt(j) == words[i].charAt(j)) {
						same++;
					}
				}
				
				if(same == begin.length() -1) { //한 글자 빼고 같으면
					visited[i] = true; //방문했다하고
					dfs(words[i], target, words, count + 1); //그 단어 기준으로 탐색
					visited[i] = false; //탐색 끝나면 원래대로 되돌리기
				}
			}
		}
	}
}