package Kakao;

public class StringCompression {

	public static void main(String[] args) {
		String str = "ababcdcdababcdcd";
		
		int answer = solution(str);
		
		System.out.println(answer);
	}
	
	public static int solution(String s) {
		int min = s.length();
		
		for(int i = 1; i <= s.length() / 2; i++) { //1개, 2개, 3개.. 단위로 압축
			String unit1 = s.substring(0, i);
			int count = 1;
			StringBuilder result = new StringBuilder();
			
			for(int j = i; j <= s.length(); j += i) {
				String unit2 = "";
				
				if(j + i <= s.length()) {
					unit2 = s.substring(j, j + i);
				} else {
					unit2 = s.substring(j, s.length());
				}
				
				if(unit1.equals(unit2)) {
					count++;
				}else {
					if(count == 1) {
						result.append(unit1);
					}else {
						result.append(count).append(unit1);
					}
					
					count = 1;
					unit1 = unit2;
				}
			}
			result.append(unit1);
			
			min = Math.min(min, result.length());
		}
		
        return min;
    }

}
