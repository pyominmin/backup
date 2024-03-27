package com.lec.ex01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class HashSetMain {

	public static void main(String[] args) {
		
		Set<String> set1 = new HashSet<>();
		set1.add("Java");
		set1.add("DataBase");
		set1.add("Java");
		
		Iterator<String> data = set1.iterator();
		while(data.hasNext()) {
			String element = data.next();
			System.out.println(element);
		}
		System.out.println();
		
		Set<Users> users = new HashSet<>();
		users.add(new Users("손흥민", 32));
		users.add(new Users("손흥민", 10));
		users.add(new Users("손흥민", 32));

		Iterator<Users> data1 = users.iterator();
		while(data1.hasNext()) {
			Users user = data1.next();
			System.out.println(user.toString() + ", " + user.hashCode());
		}
	}

}

class Users {
	String name;
	int age;
	
	public Users(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Users [name=" + name + ", age=" + age + "]";
	}
	

}


















