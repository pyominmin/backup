package com.lec.ex01_class;

public class Human {
	
	// 1. 속성(필드)
	String name;
	int age;
	
	// 2. 생성자
	public Human() {}
	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public Human(int age, String name) {
		this.name = name;
		this.age = age;
	}
	
	// 3. 메서드
	void speak() {
		System.out.println("말을 합니다!");
	}
	
	String getName() {
		return this.name;
	}
}
