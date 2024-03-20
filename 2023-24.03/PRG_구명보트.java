package algorithm;

import java.util.*;

public class PRG_����Ʈ {

	public static void main(String[] args) {
//		int[] people = {70, 50, 80, 50};
		int[] people = {70, 80, 50};
		int limit = 100;
		
		System.out.println(solution(people, limit));
	}
	
	public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int left = 0, right = people.length - 1;
        int count = 0;
        
        while(left <= right) {
        	if(people[left] + people[right] <= limit) { //���� �ʰ�X
        		left++; //���� ����
        		right--;
        	} else { //���� �ʰ�
        		right--; //���ſ� ��� ���� ����
        	}
        	count++;
        }
        
        return count;
    }

}
