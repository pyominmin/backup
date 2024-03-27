package com.lec.board;

/*
	게시판 Application
	
	1. Board database 생성(MySQL)
	 
	   1) create databse board;
	   2) board 테이블생성   
			CREATE TABLE BOARD (
			  bno  int NOT NULL AUTO_INCREMENT COMMENT '글번호',
			  subject varchar(100) NOT NULL COMMENT '글제목',
			  writer  varchar(50) NOT NULL COMMENT '작성자',
			  content varchar(255) DEFAULT NULL COMMENT '본문글',
			  crtdate date DEFAULT (now()) COMMENT '작성일',
			  readcnt int DEFAULT NULL COMMENT '조회수',
			  PRIMARY KEY (bno)
			);
		
	2. db접속정보
	  
	   JDBCConnector.properties
	   
	3. board application
	
	   1) BoardMain         : 게시판 메인 클래스
	   2) BoardVO           : 게시판 Model 클래스(DTO)
	   3) ConnectionFactory : DB접속정보를 공통으로 사용하기 위한 클래스(Factory Pattern)
	   4) BoardDAOService   : 게시판 Interface 클래스(DAO - Interface)
	   5) BoardDAOImpl      : 게시판 구현 클래스(DAO)
	   
	   6) BoardFactory      : 게시판 생성 클래스(Singleton Pattern)
	   7) BaoradMenu        : 게시판 메인메뉴 클래스   
	   
	실습
	
	1. create databse users
	2. create table user(id, name, tel, ssn)
	3. user application
	   UserMain, UserVO, ConnectionFactory, UserDAOService, UserDAOImpl, UserFactory, UserMen

	
*/
public class BoardMain {

	public static void main(String[] args) {
		BoardMenu menu = new BoardMenu(1.0);
		menu.mainBoardMenu();	
	}

}
