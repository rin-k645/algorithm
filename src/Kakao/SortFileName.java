package Kakao;

import java.util.Arrays;
import java.util.Comparator;

public class SortFileName {

	public static void main(String[] args) {
		String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};

		String[] answer = solution(files);
		
		for(String s : answer) {
			System.out.println(s);
    	}
	}
	
    public static String[] solution(String[] files) {
    	
    	Arrays.sort(files, new Comparator<String>() {
			@Override
			public int compare(String f1, String f2) {
				String head1 = f1.split("[0-9]")[0].toLowerCase(); //�ص� ����
				String head2 = f2.split("[0-9]")[0].toLowerCase();
				
				String numTail1 = f1.substring(head1.length()); //����+���� ����
				String numTail2 = f2.substring(head2.length());
				
				if(head1.compareTo(head2) == 0) { //�ص尡 ������
					String num1 = "";
					String num2 = "";
					
					for (int i = 0; i < numTail1.length(); i++) { //���� ����
					    char ch = numTail1.charAt(i);
					    if (48 <= ch && ch <= 57) {
					    	num1 += ch;
					    } else {
					    	break;
					    }
					}
					
					for (int i = 0; i < numTail2.length(); i++) { 
					    char ch = numTail2.charAt(i);
					    if (48 <= ch && ch <= 57) {
					    	num2 += ch;
					    } else {
					    	break;
					    }
					}
					
					return (Integer.parseInt(num1) - Integer.parseInt(num2)); //���ڷ� ����
				} else {
					return head1.compareTo(head2); //�ص�� �����ϱ�
				}
			}
    	});
    	
        return files;
    }

}
