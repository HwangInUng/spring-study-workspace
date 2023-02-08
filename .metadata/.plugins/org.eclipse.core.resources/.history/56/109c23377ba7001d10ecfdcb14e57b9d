package com.mvc.model;

//해당 클래스는 웹 또는 독립실행형 모두 사용 가능한 공통로직
//재사용성을 위해 기존 jsp에서 해당 코드를 분리
public class BloodAdvisor {

	// 분석결과를 반환하는 메서드
	public String getAdvice(String blood) {
		String value = null;
		switch (blood) {
		case "A":
			value = "꼼꼼";
			break;
		case "B":
			value = "자기 주관이 뚜렷";
			break;
		case "O":
			value = "활발";
			break;
		case "AB":
			value = "선택지를 많이둠";
			break;
		}
		return value;
	}
}
