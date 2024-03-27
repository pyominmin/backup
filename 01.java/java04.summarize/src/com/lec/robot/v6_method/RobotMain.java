package com.lec.robot.v6_method;

import com.lec.robot.v4_인터페이스.impl.FlyNo;
import com.lec.robot.v4_인터페이스.impl.FlyYes;
import com.lec.robot.v4_인터페이스.impl.MissileNo;
import com.lec.robot.v4_인터페이스.impl.MissileYes;
import com.lec.robot.v4_인터페이스.impl.SwordLaser;
import com.lec.robot.v4_인터페이스.impl.SwordNo;
import com.lec.robot.v4_인터페이스.impl.SwordWood;
import com.lec.robot.v4_인터페이스.impl.울트라짱검;
import com.lec.robot.v4_인터페이스.impl.탄도미사일;
import com.lec.robot.v4_인터페이스.inter.InterFly;
import com.lec.robot.v4_인터페이스.inter.InterMissile;
import com.lec.robot.v4_인터페이스.inter.InterSword;

public class RobotMain {

	public static void main(String[] args) {
		
		System.out.println("=== Robot V6.0 (common method) ===");
		System.out.println();
		
		makeRobot(new CheapRobot("Cheap", 10), new FlyYes(), new MissileYes(), new SwordWood());
		makeRobot(new StandardRobot("Standard", 10), new FlyYes(), new 탄도미사일(), new SwordLaser());
		makeRobot(new SuperRobot("Super", 10), new FlyYes(), new 탄도미사일(), new 울트라짱검());
	}

	private static void makeRobot(Robot robot, InterFly fly, InterMissile missile, 
			InterSword sword) {
		System.out.println(robot.getClass());
		robot.shape();
		robot.actionWalk();
		robot.actionRun();
		robot.setFly(fly);
		robot.actionFly();
		robot.setMissile(missile);
		robot.actionMissile();
		robot.setSword(sword);
		robot.actionSword();
		System.out.println(robot.name + "Robot의 재고수량 = " + robot.qty);
		System.out.println();
	}


}
