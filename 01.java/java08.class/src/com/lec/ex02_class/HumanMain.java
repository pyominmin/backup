package com.lec.ex02_class;

public class HumanMain {

	public static void main(String[] args) {
		
		// 상속
		Human man1 = new Human();
		System.out.println(man1.toString());
		
		String hong = new String("홍길동");
		System.out.println(hong.toString());
		
		Human man2 = new Human("김민재");
		System.out.println(man2.toString());
	
	
	}

}

class Human {
	
	String name = "손흥민";
	
	public Human() {}
	public Human(String xxx) {
		this.name = xxx;
	}
	
	// 메서드오버라이딩
	@Override
	public String toString() {
		return this.name;
	}
}