package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MockTest {
	static int[] student1 = {1, 2, 3, 4, 5};
	static int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
	static int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

	public static void main(String[] args) throws IOException {
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int[] answers = new int[num];
		
		String[] input = br.readLine().split(",");
		for(int i = 0; i < num; i++) {
			answers[i] = Integer.parseInt(input[i]);
		}
		
		//처리
		int[] answer = solution(answers);
		
		//출력
		for(int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}

	}
	
	public static int[] solution(int[] answers) {
		int count[] = new int[3];
		
		for(int i = 0; i < answers.length; i++) {
			if(student1[i % student1.length] == answers[i]) {
				count[0]++;
			}
			if(student2[i % student2.length] == answers[i]) {
				count[1]++;
			}
			if(student3[i % student3.length] == answers[i]) {
				count[2]++;
			}
		}
		
		int max = Math.max(Math.max(count[0], count[1]),count[2]);
		
		ArrayList<Integer> temp = new ArrayList<>();
		for(int i = 0; i < count.length; i++) {
			if(count[i] == max) {
				temp.add(i + 1);
			}
		}
		
        int[] answer = new int[temp.size()];
        for(int i =0; i < answer.length; i++) {
        	answer[i] = temp.get(i);
        }
        
        return answer;
    }

}
