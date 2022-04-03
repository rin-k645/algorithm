// https://programmers.co.kr/learn/courses/30/lessons/77484

package 프로그래머스;

public class Lotto {

	public static void main(String[] args) {
//		int[] lottos = {44, 1, 0, 0, 31, 25};
//		int[] win_nums = {31, 10, 45, 1, 6, 19};
		
//		int[] lottos = {0, 0, 0, 0, 0, 0};
//		int[] win_nums = {38, 19, 20, 40, 15, 25};
		
		int[] lottos = {45, 4, 35, 20, 3, 9};
		int[] win_nums = {20, 9, 3, 45, 4, 35};
		
		int[] answer = solution(lottos, win_nums);
		
		System.out.println(answer[0] + " " + answer[1]);
	}
	
    public static int[] solution(int[] lottos, int[] win_nums) { 
    	int count = 0;
    	int zero = 0;
    	
    	for(int i = 0; i < lottos.length; i++) { //0을 제외하고 일치하는 번호 수 구하기
    		if(lottos[i] != 0) { //알아볼 수 있는 번호
    			for(int j = 0; j < win_nums.length; j++) {
        			if(lottos[i] == win_nums[j]) {
        				count++;
        				break;
        			}
        		}
    		} else { //알아볼 수 없는 번호
    			zero++;
    		}
    	}
    	
    	//맞을 수 있는 개수의 최대 최소 구하기
    	int best = count;
    	int worst = count;
    	
    	if(zero != 0) { //알아볼 수 없는 번호 있으면
    		best += zero; //그 수만큼 더해줌
    	}
    	
    	//순위 정하기
    	int highest = 0;
    	int lowest = 0;
    	
    	if(best <= 1) {
    		highest = 6;
    	} else {
    		highest = 7 - best;
    	}
    	
    	if(worst <= 1) {
    		lowest = 6;
    	} else {
    		lowest = 7 - worst;
    	}
    	
        int[] answer = new int[2];
        answer[0] = highest;
        answer[1] = lowest;
        
        return answer;
    }

}
