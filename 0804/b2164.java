import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		while(queue.size() > 1) {
			queue.poll(); //1. 버리기
			queue.add(queue.poll()); //2.버리고 아래로 옮기기
		}
		
		System.out.println(queue.peek());

	}

}

