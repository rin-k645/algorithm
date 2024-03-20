package algorithm;

import java.io.*;
import java.util.*;

public class BOJ_니가싫어싫어 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //모기 마릿수

		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int TE = Integer.parseInt(st.nextToken());
			int TX = Integer.parseInt(st.nextToken());
			
			map.put(TE, map.getOrDefault(TE, 0) + 1);
			map.put(TX, map.getOrDefault(TX, 0) - 1);
		}
		
		//맵 키 오름차순 정렬
		List<Integer> keyList = new ArrayList<>(map.keySet());
		keyList.sort((o1, o2) -> o1 - o2);
		
		int sum = 0;
		int max = 0;
		int ans_start = 0, ans_end = 0;
		
		//맵 순회하며 찾기
		boolean opened = false; //최대 구간이 열렸는지
		
		for(int key : keyList) {
			sum += map.get(key); //+1 or -1값을 누적시킴
			
			if(sum > max) { //최댓값이 나오면 갱신
				max = sum;
				ans_start = key;
				opened = true;
			} else if(sum < max && opened) { //최대 구간에서 값이 바뀌는 지점이면
				ans_end = key;
				opened = false; //구간 닫음
			}
		}
		
		System.out.println(max);
		System.out.println(ans_start + " " + ans_end);
	}

}