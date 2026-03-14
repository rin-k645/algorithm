import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] arr = new long[N + 1];
		long sum = 0;
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			sum += arr[i];
		}
		
		// 구현
		if(sum == 0){
            System.out.println((N + 1) / 2);
            return;
        }
		
		long answer = sum;
        List<Integer> list = new ArrayList<>();

        int i = 0;
        while(i < N) {
            if(arr[i] != 0) {
                i++;
                continue;
            }

            int len = 0;
            while(i < N && arr[i] == 0) {
                len++;
                i++;
            }
            list.add(len);
        }

        // 원형 처리
        if(arr[0] == 0 && arr[N - 1] == 0 && list.size() > 1) {
            int first = list.get(0);
            int last = list.get(list.size() - 1);
            list.set(0, first + last);
            list.remove(list.size() - 1);
        }

        for(int len : list) {
            answer += (len + 1) / 2;
        }

        System.out.println(answer);
	}

}
