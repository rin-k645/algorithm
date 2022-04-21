package Kakao;

import java.util.LinkedList;

public class Cache {
	static final int HIT = 1;
	static final int MISS = 5;

	public static void main(String[] args) {
		int cacheSize = 0;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

		int answer = solution(cacheSize, cities);
		
		System.out.println(answer);
	}
	
    public static int solution(int cacheSize, String[] cities) {
    	LinkedList<String> list = new LinkedList<>();
    	int time = 0;
    	
    	if(cacheSize == 0) {
    		return MISS * cities.length;
    	}
    	
    	for(int i = 0; i < cities.length; i++) {
    		String city = cities[i].toLowerCase();
    		
    		if(list.contains(city)) { //캐시에 있으면
				list.remove(city);
				list.addFirst(city);
				time += HIT;
			} else { //캐시에 없으면
				if(list.size() == cacheSize) {
					list.removeLast();
				}
				list.addFirst(city);
				time += MISS;
			}
    	}
    	
        return time;
    }

}
