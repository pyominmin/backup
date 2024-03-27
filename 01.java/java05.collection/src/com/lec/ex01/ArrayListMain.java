package com.lec.ex01;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMain {

	public static void main(String[] args) {
		
		// 1. Non-Generic
		List list1 = new ArrayList();
		list1.add("문자열");
		list1.add(new String("문자열"));
		list1.add(100);
		list1.add(new User());
		list1.add(new Member());
		
		String str1 = (String) list1.get(0);
		String str2 = (String) list1.get(1);
		int age = (int) list1.get(2);
		User user = (User) list1.get(3);
		Member member = (Member) list1.get(4);
		
		// 2. Genric
		List<String> list2 = new ArrayList();
		list2.add("문자열");
		list2.add("손흥민");
		
		String str3 = list2.get(0);
		String str4 = list2.get(1);

	}

}

class User { 
	String name;
	int age;
}

class Member {
	int id;
	String name;
}