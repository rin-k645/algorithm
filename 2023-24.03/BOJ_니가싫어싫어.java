package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_�ϰ��Ⱦ�Ⱦ� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //��� ������

		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int TE = Integer.parseInt(st.nextToken());
			int TX = Integer.parseInt(st.nextToken());
			
			map.put(TE, map.getOrDefault(TE, 0) + 1);
			map.put(TX, map.getOrDefault(TX, 0) - 1);
		}
		
		//�� Ű �������� ����
		List<Integer> keyList = new ArrayList<>(map.keySet());
		keyList.sort((o1, o2) -> o1 - o2);
		
		int sum = 0;
		int max = 0;
		int ans_start = 0, ans_end = 0;
		
		//�� ��ȸ�ϸ� ã��
		boolean opened = false; //�ִ� ������ ���ȴ���
		
		for(int key : keyList) {
			sum += map.get(key); //+1 or -1���� ������Ŵ
			
			if(sum > max) { //�ִ��� ������ ����
				max = sum;
				ans_start = key;
				opened = true;
			} else if(sum < max && opened) { //�ִ� �������� ���� �ٲ�� �����̸�
				ans_end = key;
				opened = false; //���� ����
			}
		}
		
		System.out.println(max);
		System.out.println(ans_start + " " + ans_end);
	}

}