package com.lec.ex01_class;

public class HumanMain {

	public static void main(String[] args) {
		
		// 1. Heap영역에 Human 참조타입의 객체가 생성
		// 2. Stack영역에 man 변수가 저장
		// 3. 대입연산자(=)에의해 Human참조타입객체의 주소가 man변수에 저장;
		Human man1 = new Human();
		Human man2 = new Human();
		Human man3 = new Human();
		System.out.println(man1.toString());  // 객체저장주소가 클래스이름과16진수주소가 리턴
		System.out.println(man1.hashCode());  // 객체저장주소가 10진수로 리턴
		System.out.println(man2.toString() + ", " + man2.hashCode());
		System.out.println(man3.toString() + ", " + man3.hashCode());
		
		System.out.println(man1.name + ", " + man1.age);

		Human adam = new Human("아담", 10000);
		Human eve = new Human("이브", 9000);
		
		System.out.println(adam.name + ", " + adam.age);
		System.out.println(eve.name + ", " + eve.age);
		
		Human hong = new Human(1000, "홍길동");
		System.out.println(hong.name + ", " + hong.age);
		
		man1.speak();
		adam.speak();
		hong.speak();
		
		String manName = man1.getName();
		String adamName = adam.getName();
		String hongName = hong.getName();
		System.out.println(manName);
		System.out.println(adamName);
		System.out.println(hongName);
		
	}

}
