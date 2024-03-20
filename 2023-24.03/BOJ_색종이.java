package algorithm;

import java.io.*;

public class BOJ_������ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] paper = new int[6];
		
		for(int i = 0; i < 6; i++) {
			paper[i] = Integer.parseInt(br.readLine());
		}
		
		int answer = paper[5]; //���� 6cm ���� 
		
		while(paper[4] > 0) { //���� 5cm ���� 
			paper[4]--;
			
			int one = 36 - 25; //11�� ����
			if(paper[0] > 0) { //���� 1cm ���� 
				paper[0] = paper[0] > one ? paper[0] - one : 0; //11���� ����
			}
			
			answer++;
		}
		
		while(paper[3] > 0) { //���� 4cm ���� 
			paper[3]--;
			
			int two = 5; //2cm 5�� ����
			int one = 36 - 16 - 4 * Math.min(two, paper[1]); //1cm �� �� ������
			
			if(paper[1] > 0) { //���� 2cm ���� 
				paper[1] = paper[1] > two ? paper[1] - two : 0; //5���� ����
			}
			
			if(paper[0] > 0) { //���� 1cm ���� 
				paper[0] = paper[0] > one ? paper[0] - one : 0; //one���� ����
			}
			
			answer++;
		}
		
		while(paper[2] > 0) { //���� 3cm ���� 
			int three = 4; //3cm 4�� ����
			int one = 36 - 9 * Math.min(three, paper[2]); //1cm �� �� ������
			int two = 0;
			
			if(paper[2] >= three) {
				paper[2] -= three; //4���� ����
			} else if(paper[2] == 3) { //3cm 3�� ����
				paper[2] = 0;
				
				two = 1; //2cm 1�� ����
				if(paper[1] > 0) { //���� 2cm ���� 
					paper[1] = paper[1] > two ? paper[1] - two : 0; //1���� ����
				}
				
				one -= 4 * Math.min(two, paper[1]);
			} else if(paper[2] == 2) { //3cm 2�� ����
				paper[2] = 0;
				
				two = 3; //2cm 3�� ����
				if(paper[1] > 0) { //���� 2cm ���� 
					paper[1] = paper[1] > two ? paper[1] - two : 0; //3���� ����
				}
				
				one -= 4 * Math.min(two, paper[1]);
			} else if(paper[2] == 1) { //3cm 1�� ����
				paper[2] = 0;
				
				two = 5; //2cm 5�� ����
				if(paper[1] > 0) { //���� 2cm ���� 
					paper[1] = paper[1] > two ? paper[1] - two : 0; //5���� ����
				}
				
				one -= 4 * Math.min(two, paper[1]);
			}
			
			if(paper[0] > 0) { //���� 1cm ���� 
				paper[0] = paper[0] > one ? paper[0] - one : 0; //one���� ����
			}
			
			answer++;
		}
		
		while(paper[1] > 0) { //���� 2cm ���� 
			int two = 9; //2cm 9�� ����
			int one = 36 - 4 * Math.min(two, paper[1]);
			
			paper[1] = paper[1] > two ? paper[1] - two : 0; //9���� ����
			
			if(paper[0] > 0) { //���� 1cm ���� 
				paper[0] = paper[0] > one ? paper[0] - one : 0; //one���� ����
			}
			
			answer++;
		}
		
		while(paper[0] > 0) { //���� 1cm ���� 
			int one = 36; //1cm 36�� ����
			paper[0] = paper[0] > one ? paper[0] - one : 0; //36���� ����
			answer++;
		}
		
		System.out.println(answer);
	}

}
