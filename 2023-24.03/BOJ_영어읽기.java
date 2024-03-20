package algorithm;

import java.util.*;
import java.io.*;

public class BOJ_�����б� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String, Integer> map = new HashMap<>(); //���ĵ� �ܾ�, ����
		
		//�ܾ�
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String voca = br.readLine();
			String sortedVoca = transformVoca(voca); //���� �����ϱ�
			map.put(sortedVoca, map.getOrDefault(sortedVoca, 0) + 1); //�ش� ���� ������ �Բ� map�� ����
		}
		
		//����
		int M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			int answer = 1; //����: ����� ��
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			while(st.hasMoreTokens()) {
				String voca = st.nextToken();
				String sortedVoca = transformVoca(voca); //���� �����ϱ�
				answer *= map.getOrDefault(sortedVoca, 0); //����� ���� ���ϱ�
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static String transformVoca(String voca) { //���ڸ� ù���ڿ� ������ ���ڸ� ���� ����
		char[] chs = voca.toCharArray();
		
		if(chs.length > 1) {
			Arrays.sort(chs, 1, chs.length - 1);
		}
		
		String sortedVoca = String.valueOf(chs);
		
		return sortedVoca;
	}

}
