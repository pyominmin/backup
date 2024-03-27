package com.lec.ex03_class;

public class HumanMain {

	public static void main(String[] args) {
		
		System.out.println(Korean.NATION);
		Korean kor = new Korean("홍길동");
		System.out.println(kor.name);
		
		Korean amc = new Korean("스티브");
		// amc.NATION = "미국";
		System.out.println(amc.NATION);
		
		System.out.println(kor.NATION);
		
	}

}

class Korean {
	
	static final String NATION = "대한민국"; // 클래스멤버
	String name;                             // 객체멤버 
	
	public Korean(String name) {
		this.name = name;
	}
}