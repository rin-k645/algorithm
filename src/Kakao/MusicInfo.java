package Kakao;

public class MusicInfo {

	public static void main(String[] args) {
		String m = "ABC";
		String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};

		String answer = solution(m, musicinfos);
		
		System.out.println(answer);
	}
	
    public static String solution(String m, String[] musicinfos) {
    	String answer = "(None)";
    	int maxLength = Integer.MIN_VALUE;
    	
    	for(int i = 0; i < musicinfos.length; i++) {
    		String[] musicinfo = musicinfos[i].split(",");
    		
    		String start = musicinfo[0];
    		String end = musicinfo[1];
    		String title = musicinfo[2];
    		String melody = musicinfo[3];
    		
    		int length = getLength(start, end); //재생시간
    		
    		m = changeMelody(m);
    		melody = changeMelody(melody);
    		
    		String play = "";
    		if(length <= melody.length()) { //재생 시간이 멜로디보다 작으면
    			play = melody.substring(0, length);
    		} else { //재생 시간이 멜로디보다 크면
    			int q = length / melody.length();
    			int r = length % melody.length();
    			
    			for(int j = 0; j < q; j++) {
    				play += melody;
    			}
    			play += melody.substring(0, r);
    		}
    		
    		if(play.contains(m) && length > maxLength) {
    			answer = title;
    			maxLength = length;
    		}
    		
    	}
        
        return answer;
    }

	public static String changeMelody(String melody) {
		melody = melody.replaceAll("C#", "H");
		melody = melody.replaceAll("D#", "I");
		melody = melody.replaceAll("F#", "J");
		melody = melody.replaceAll("G#", "K");
        melody = melody.replaceAll("A#", "L");
		
		return melody;
	}

	public static int getLength(String start, String end) { //재생시간 구하기
		String[] strStart = start.split(":");
		String[] strEnd = end.split(":");
		
		int intStart = Integer.parseInt(strStart[0]) * 60 + Integer.parseInt(strStart[1]);
		int intEnd = Integer.parseInt(strEnd[0]) * 60 + Integer.parseInt(strEnd[1]);
		
		return intEnd - intStart;
	}
	
}
