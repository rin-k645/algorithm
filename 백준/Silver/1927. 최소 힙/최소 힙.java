import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			String[] x = br.readLine().split(" ");
			
			if(Integer.parseInt(x[0]) == 0) {
				if(priorityQueue.isEmpty())
					bw.write(0 + "\n");
				else {
					int result = priorityQueue.poll();
					bw.write(result + "\n");
				}
			}
			else
				priorityQueue.add(Integer.parseInt(x[0]));
		}
		bw.flush();
		bw.close();
	}

}
