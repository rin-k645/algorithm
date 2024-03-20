package algorithm;

public class PRG_연속된부분수열의합 {

	public static void main(String[] args) {
		int[] seq1 = {1, 2, 3, 4, 5};
		solution(seq1, 7);
	}
	
	public static int[] solution(int[] sequence, int k) {
        int start = 0, end = 0;
        int sum = sequence[0];
        int ans_start = 1000000, ans_end = 2000000;
        
        while(end < sequence.length) {
            if(sum >= k){
                if(sum == k && end - start < ans_end - ans_start) {
                    ans_start = start;
                    ans_end = end;
                }
                
                System.out.println(start + " " + end + " " + sum +" 크다");
                start++;
                sum -= sequence[start - 1];
            } else {
                System.out.println(start + " " + end + " " + sum +" 작다");
                end++;
                sum += sequence[end];
            }
        }
        
        System.out.println(ans_start + " " + ans_end);
        
        return new int[] {ans_start, ans_end};
    }

}
