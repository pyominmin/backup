package com.lec.robot.v2_상속;

public class Robot {

	public String name;
	public int qty;
	
	public Robot(String name, int qty) {
		this.name = name;
		this.qty = qty;
	}
	
	public void shape() { System.out.println(this.name + "Robot입니다! 팔, 다리, 머리, 몸통이 있습니다!");}
	public void actionWalk() { System.out.println("걸을 수가 있습니다!");}
	public void actionRun() { System.out.println("달릴 수가 있습니다!");}
	
}
