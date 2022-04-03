// https://programmers.co.kr/learn/courses/30/lessons/77484

package ���α׷��ӽ�;

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
    	
    	for(int i = 0; i < lottos.length; i++) { //0�� �����ϰ� ��ġ�ϴ� ��ȣ �� ���ϱ�
    		if(lottos[i] != 0) { //�˾ƺ� �� �ִ� ��ȣ
    			for(int j = 0; j < win_nums.length; j++) {
        			if(lottos[i] == win_nums[j]) {
        				count++;
        				break;
        			}
        		}
    		} else { //�˾ƺ� �� ���� ��ȣ
    			zero++;
    		}
    	}
    	
    	//���� �� �ִ� ������ �ִ� �ּ� ���ϱ�
    	int best = count;
    	int worst = count;
    	
    	if(zero != 0) { //�˾ƺ� �� ���� ��ȣ ������
    		best += zero; //�� ����ŭ ������
    	}
    	
    	//���� ���ϱ�
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
