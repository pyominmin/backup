package com.lec.robot.v7_생성자;

import com.lec.robot.v4_인터페이스.impl.FlyYes;
import com.lec.robot.v4_인터페이스.impl.MissileYes;
import com.lec.robot.v4_인터페이스.impl.SwordLaser;
import com.lec.robot.v4_인터페이스.impl.울트라짱검;
import com.lec.robot.v4_인터페이스.impl.탄도미사일;

public class RobotMain {

	public static void main(String[] args) {
		
		System.out.println("=== Robot V7.0 (다형성) ===");
		System.out.println();	
		
		Robot robot = null;
		
		robot = new CheapRobot("Cheap", 10, new FlyYes(), new MissileYes(), new SwordLaser());
		robot.productRobot();
		
		robot = new StandardRobot("Standard", 10, new FlyYes(), new 탄도미사일(), new 울트라짱검());
		robot.productRobot();

		robot = new SuperRobot("Super", 10, new FlyYes(), new 탄도미사일(), new 울트라짱검());
		robot.productRobot();
		
	}

}
