package BruteForce;

public class SelfNumber {

	public static void main(String[] args) {
		boolean[] isSelfNum = new boolean[10001];
		
		for(int i = 0; i < 10001; i++) {
			int n = d(i);
			
			if(n < 10001) {
				isSelfNum[n] = true;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i < 10001; i++) {
			if(!isSelfNum[i]) {
				sb.append(i).append('\n');
			}
		}
		System.out.println(sb);
	}

	public static int d(int n) {
		int sum = n;
		
		while(n != 0){
			sum = sum + (n % 10); //1�� �ڸ���, 10�� �ڸ���, 100�� �ڸ���...
			n = n / 10;
		}
    
		return sum;
	}

}
