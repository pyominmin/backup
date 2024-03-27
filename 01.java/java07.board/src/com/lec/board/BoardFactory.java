package com.lec.board;

public class BoardFactory {
	
	// 1. 외부에서 생성자를 접근하지 못하도록 private으로 접근제하
	private BoardFactory() {}
	
	// 2. DAO를 1개만 생성하도록 정적메서드로 정의
	private static BoardDAOImpl bddao = null;
	
	// 3. getter로 접근
	public static BoardDAOImpl getInstance() {
		if(bddao == null) bddao = new BoardDAOImpl();
		return bddao;
	}
}
