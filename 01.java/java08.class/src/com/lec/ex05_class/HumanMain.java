package com.lec.ex05_class;

public class HumanMain {

	public static void main(String[] args) {

		Human human = new Human();
		human.speak();
		human.eat();
		human.move();
		
		Adam adam = new Adam();
		adam.speak();
		adam.eat();
		adam.move();
		System.out.println();
		
		Eve eve = new Eve();
		eve.speak();
		eve.eat();
		eve.move();
	}

}

class Human {
	String name;
	String gender;
	int age;
	
	void speak() { System.out.println("말을 한다!!");}
	void eat() { System.out.println("음식을 먹는다!!");}
	void move() { System.out.println("움직인다.");}
	
	@Override
	public String toString() {
		return "Human [name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}
}
class Adam extends Human {
	@Override
	void speak() { System.out.println("천국말을 한다."); }
	
	@Override
	void eat() { System.out.println("음식을 먹는다!!"); }
	
	@Override
	void move() { System.out.println("사냥을 한다!!");}
}

class Eve extends Adam {
	@Override
	void move() { System.out.println("음식을 만든다!!");}
}
class Korean extends Adam {
	@Override
	void speak() { System.out.println("한국말을 한다."); }	
	
	@Override
	void move() { System.out.println("프로그램을 개발한다!!");}	
}
class American extends Adam {
	@Override
	void speak() { System.out.println("영어로 말을 한다."); }	
	
	@Override
	void move() { System.out.println("피자를 만든다!!");}		
}