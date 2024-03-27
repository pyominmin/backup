package com.lec.robot.v5_extends;

import com.lec.robot.v4_인터페이스.impl.FlyNo;
import com.lec.robot.v4_인터페이스.impl.MissileNo;
import com.lec.robot.v4_인터페이스.impl.SwordNo;

public class RobotMain {

	public static void main(String[] args) {

		System.out.println("=== Robot V5.0 (promotion) ===");
		System.out.println();	
		
		Robot robot = null;
		
		robot = new CheapRobot("Cheap", 10);
		System.out.println(robot.getClass());
		robot.actionWalk();
		robot.actionRun();
		robot.setFly(new FlyNo());
		robot.actionFly();		
		robot.setMissile(new MissileNo());
		robot.actionMissile();
		robot.setSword(new SwordNo());
		robot.actionSword();
		System.out.println(robot.name + "Robot의 재고수량 = " + robot.qty);
		System.out.println();
		
		robot = new StandardRobot("Standard", 5);
		System.out.println(robot.getClass());
		robot.actionWalk();
		robot.actionRun();
		robot.setFly(new FlyNo());
		robot.actionFly();		
		robot.setMissile(new MissileNo());
		robot.actionMissile();
		robot.setSword(new SwordNo());
		robot.actionSword();
		System.out.println(robot.name + "Robot의 재고수량 = " + robot.qty);
		System.out.println();
		
		robot = new SuperRobot("Super", 15);
		System.out.println(robot.getClass());
		robot.actionWalk();
		robot.actionRun();
		robot.setFly(new FlyNo());
		robot.actionFly();		
		robot.setMissile(new MissileNo());
		robot.actionMissile();
		robot.setSword(new SwordNo());
		robot.actionSword();
		System.out.println(robot.name + "Robot의 재고수량 = " + robot.qty);
		System.out.println();		
	}

}
