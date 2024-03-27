package com.lec.ex01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class HashMapMain {

	public static void main(String[] args) {
		
		// 1. Map객체생성
		Map<String, Integer> map = new HashMap<>();
		map.put("홍길동", 100);
		map.put("홍길동", 90);
		System.out.println(map.size());
		System.out.println(map.get("홍길동"));
		
		Map<Student, Integer> students = new HashMap<>();
		students.put(new Student(1, "소향"), 100);
		students.put(new Student(1, "소향"), 99);
		students.put(new Student(2, "소향"), 98);
		System.out.println(students.size());
		
		Set<Student> keySet = students.keySet();
		Iterator<Student> xxx = keySet.iterator();
		while(xxx.hasNext()) {
			Student student = xxx.next();
			Integer  score = students.get(student);
			System.out.println(student + "의 점수 = " + score);
		}
		
		
	}

}

class Student {
	
	private int sno;
	private String name;
	
	public Student(int sno, String name) {
		super();
		this.sno = sno;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, sno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(name, other.name) && sno == other.sno;
	}
	
	
	
}
