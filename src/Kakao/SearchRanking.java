package Kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SearchRanking {
	
	static class Applicant {
		String language;
		String job;
		String career;
		String soulFood;
		int score;
		
		public Applicant(String language, String job, String career, String soulFood, int score) {
			this.language = language;
			this.job = job;
			this.career = career;
			this.soulFood = soulFood;
			this.score = score;
		}
	}

	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
	
		int[] answer = solution(info, query);
		
		for(int i : answer) {
			System.out.println(i);
		}
	}
	
	public static int[] solution(String[] info, String[] query) {
		ArrayList<Applicant> list = new ArrayList<>();
		
		for(String str : info) { //info 파싱해서 정보 저장
			String[] row = str.split(" ");
			
			String language = row[0];
			String job = row[1];
			String career = row[2];
			String food = row[3];
			int score = Integer.parseInt(row[4]);
			
			Applicant applicant = new Applicant(language, job, career, food, score);
			list.add(applicant);
		}
		
		Collections.sort(list, new Comparator<Applicant>() { //효율성 통과를 위한 점수 기준 내림차순 정렬
			@Override
			public int compare(Applicant a1, Applicant a2) {
				if(a1.score < a2.score) {
					return 1;
				} else if(a1.score > a2.score) {
					return -1;
				}
				return 0;
			}
		});
		
		int[] answer = new int[query.length];
		
		for(int i = 0; i < query.length; i++) {
			String[] row = query[i].split(" ");
			
			String language = row[0];
			String job = row[2];
			String career = row[4];
			String food = row[6];
			int score = Integer.parseInt(row[7]);
			
			answer[i] = search(list, language, job, career, food, score);
		}
		
        return answer;
    }

	public static int search(ArrayList<Applicant> list, String language, String job, String career, String food, int score) {
		language = language.equals("-") ? "" : language;
		job = job.equals("-") ? "" : job;
		career = career.equals("-") ? "" : career;
		food = food.equals("-") ? "" : food;
		
		int count = 0;
		for(Applicant applicant : list) {
			if(applicant.language.contains(language) && applicant.job.contains(job) && applicant.career.contains(career) && applicant.soulFood.contains(food) && applicant.score >= score) {
				count++;
			}
		}
		
		return count;
	}

}
