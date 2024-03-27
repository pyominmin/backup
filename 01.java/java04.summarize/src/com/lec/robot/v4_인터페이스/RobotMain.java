package com.lec.robot.v4_인터페이스;

import com.lec.robot.v4_인터페이스.impl.*;

public class RobotMain {

	public static void main(String[] args) {

		System.out.println("=== Robot V4.0 (인터페이스) ===");
		System.out.println();		

		CheapRobot cheapRobot = new CheapRobot("Cheap", 10);
		cheapRobot.actionWalk();
		cheapRobot.actionRun();
		cheapRobot.setFly(new FlyNo());
		cheapRobot.actionFly();		
		cheapRobot.setMissile(new MissileNo());
		cheapRobot.actionMissile();
		cheapRobot.setSword(new SwordNo());
		cheapRobot.actionSword();
		System.out.println(cheapRobot.name + "Robot의 재고수량 = " + cheapRobot.qty);
		System.out.println();
		
		StandardRobot standardRobot = new StandardRobot("Cheap", 10);
		standardRobot.actionWalk();
		standardRobot.actionRun();
		standardRobot.setFly(new FlyYes());
		standardRobot.actionFly();		
		standardRobot.setMissile(new 탄도미사일());
		standardRobot.actionMissile();
		standardRobot.setSword(new SwordLaser());
		standardRobot.actionSword();
		System.out.println(standardRobot.name + "Robot의 재고수량 = " + standardRobot.qty);
		System.out.println();		
		
		SuperRobot superRobot = new SuperRobot("Cheap", 10);
		superRobot.actionWalk();
		superRobot.actionRun();
		superRobot.setFly(new FlyYes());
		superRobot.actionFly();		
		superRobot.setMissile(new MissileYes());
		superRobot.actionMissile();
		superRobot.setSword(new 울트라짱검());
		superRobot.actionSword();
		System.out.println(superRobot.name + "Robot의 재고수량 = " + superRobot.qty);
		System.out.println();		
	}

}
