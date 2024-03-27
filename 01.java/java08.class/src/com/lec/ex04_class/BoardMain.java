package com.lec.ex04_class;

public class BoardMain {

	public static void main(String[] args) {
		// 싱글톤은 객체를 1개만 생성하도록 하는 기법(디자인패턴)
//		Board board1 = new Board(1, "11111");
//		Board board2 = new Board(2, "22222");
		
		
//		System.out.println(board1.toString());
//		System.out.println(board2.toString());
		
		Board board1 = Board.getInstance();
		Board board2 = Board.getInstance();
		
		System.out.println(board1.toString());
		System.out.println(board2.toString());
		

	}

}

class Board {
	
	// singleton 만드는 방법
	
	int bno;
	String subject;
	
	// 1. 생성자를 private으로 설정해서 외부에서 객체를 생성하지 못하도록 한다.
	private Board(int bno, String subject) {
		this.bno = bno;
		this.subject = subject;
	}
	
	// 2. 자신의 참조타입인 인스턴스를 생성한다.(공통사용가능하도록 static으로 선언)
	private static Board board = new Board(0, "");
	
	// 3.getter를 만들어서 외부에서 접근할수 있도록 한다.
	public static Board getInstance() { 
		return board;
	}
	
}