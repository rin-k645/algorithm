package 프로그래머스;

import java.util.ArrayList;

public class DevelopingFunction {

	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		
		int[] answer = solution(progresses, speeds);

		for(int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}
	
    public static int[] solution(int[] progresses, int[] speeds) {
       int[] records = new int[progresses.length];
        
        for(int i = 0; i < progresses.length; i++) { //작업하기
        	int day = 0;
        	
        	while(progresses[i] < 100) {
        		progresses[i] += speeds[i];
        		day++;
        	}
        	
        	records[i] = day;
        }
        
        //배포
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] completed = new boolean[records.length];
        
        for(int i = 0; i < records.length; i++) {
        	int count = 1;
        	
        	if(completed[i]) {
        		continue;
        	}
        	
        	for(int j = i + 1; j < records.length; j++) {
        		if(records[i] >= records[j]) {
            		count++;
            		completed[j] = true;
            	} else {
            		break;
            	}
        	}
        	
        	list.add(count);	
        }
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }

}
