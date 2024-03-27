package com.lec.robot.v8_final;

import com.lec.robot.v4_인터페이스.impl.FlyYes;
import com.lec.robot.v4_인터페이스.impl.MissileYes;
import com.lec.robot.v4_인터페이스.impl.SwordLaser;
import com.lec.robot.v4_인터페이스.impl.울트라짱검;
import com.lec.robot.v4_인터페이스.impl.탄도미사일;
import com.lec.robot.v7_생성자.CheapRobot;
import com.lec.robot.v7_생성자.Robot;
import com.lec.robot.v7_생성자.StandardRobot;
import com.lec.robot.v7_생성자.SuperRobot;

public class RobotMain {

	public static void main(String[] args) {
		
		System.out.println("=== Robot V8.0 (Final) ===");
		System.out.println();	
		
		Robot robot = null;
		
		robot = new CheapRobot("Cheap", 10, new FlyYes(), new MissileYes(), new SwordLaser());
		robot.productRobot();
		
		robot = new StandardRobot("Standard", 10, new FlyYes(), new 탄도미사일(), new 울트라짱검());
		robot.productRobot();

		robot = new SuperRobot("Super", 10, new FlyYes(), new 탄도미사일(), new 울트라짱검());
		robot.productRobot();	
	
		
		// 실습
		// 1. V4.0 setter 없애는 로직
		// 2. V8.0 method 다형성 (productRobot(InterFly, InterMissile, InterSword)
		
	}

}
