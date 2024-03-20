package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_����Ѵܾ�2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		List<String> list = new ArrayList<>(); //�ε��� �´� �ܾ� ����
		HashMap<String, Integer> map = new HashMap<>(); //���ܾ�, �ε���
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			map.put(str, i);
			list.add(str);
		}
		
		//�� ����(key)
		List<String> keyList = new ArrayList<>(map.keySet());
		keyList.sort((s1, s2) -> s1.compareTo(s2));
		
		//�տ������� �ܾ� 2���� ��
		int maxM = 0;
		int sIdx = N;
		int tIdx = N;
		
		for(int i = 0; i < N - 1; i++) {
			String str1 = keyList.get(i);
			String str2 = keyList.get(i + 1);
			
//			System.out.println(str1 + " " + str2);
			
			int m = getM(str1, str2);
//			System.out.println(m);
			
			int idx1 = map.get(str1);
			int idx2 = map.get(str2);
			
			if(m > maxM) { //M�� �ִ�
				maxM = m;
				sIdx = Math.min(idx1, idx2);
				tIdx = Math.max(idx1, idx2);
			} else if(m == maxM) { //���� ��, �ݷ� ����
				HashSet<Integer> set = new HashSet<>();
				set.add(sIdx);
				set.add(tIdx);
				set.add(idx1);
				set.add(idx2);
				
				List<Integer> tmp = new ArrayList<>(set);
				Collections.sort(tmp);
				
				sIdx = tmp.get(0);
				tIdx = tmp.get(1);
			}
		}
		
//		System.out.println(maxM + " " + sIdx + " " + tIdx);
		
		//���
		System.out.println(list.get(sIdx));
		System.out.println(list.get(tIdx));
	}
	
	public static int getM(String str1, String str2) {
		int minLen = Math.min(str1.length(), str2.length());
		
		int count = 0;
		for(int i = 0; i < minLen; i++) {
			if(str1.charAt(i) != str2.charAt(i)) break;
			
			count++;
		}
				
		return count;
	}

}
