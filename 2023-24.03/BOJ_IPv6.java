package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_IPv6 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		if(input.contains("::")) { // ::�� ����
			input = input.replace("::", ":group:"); // ::�� ġȯ��
		}
			
		List<String> list = new ArrayList<>(Arrays.asList(input.split(":"))); // :�� �и���
		List<String> fullIpList = new ArrayList<>(); //������ ���� ������ �ּ� ����Ʈ
		
		for(String str : list) {
			if(str.isEmpty()) continue; //str�� ""�̸� ���� �ּҿ� ����x
			
			while(str.length() <4) { //�տ� 0 �ٿ��� 4�ڸ��� �����
				str = "0" + str;
			}
			
			fullIpList.add(str); //��� Ǭ ���ڿ� �߰�
		}
		
		if(fullIpList.contains("group")) { //��� ������ ����
			int idx = fullIpList.indexOf("group");
			
			fullIpList.remove(idx); //��ü�� ����
			
			while (fullIpList.size() < 8) { //8�ڸ� �ɶ����� ���� 0 ���� �߰�
				fullIpList.add(idx, "0000");
            }
		}
		
		//IP �ּ� ���·� ���
		System.out.println(String.join(":", fullIpList));
	}
}
