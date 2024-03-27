package com.lec.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.PreparableStatement;

public class BoardDAOImpl implements BoardDAOService {

	private BoardVO inputBoard() {
		
		BoardVO board = new BoardVO();
		
		String subjet = JOptionPane.showInputDialog("글제목을 입력하세요!");
		String writer = JOptionPane.showInputDialog("작성자를 입력하세요!");
		String content = JOptionPane.showInputDialog("글내용을 입력하세요!");

		board.setSubject(subjet);
		board.setWriter(writer);
		board.setContent(content);
		
		return board;
	}
	
	@Override
	public void createBoard() {
		// 글제목, 작성자, 글내용
		BoardVO board = inputBoard();
		
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.getConnetion();
		PreparedStatement pstmt = null;
		String sql = cf.getInsert();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getSubject());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			int row = pstmt.executeUpdate();
			System.out.println(row + "건이 성공적으로 등록되었습니다!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				// dummy
			}
		}
	}

	@Override
	public ArrayList<BoardVO> listBoard() {
		ArrayList<BoardVO> boards = new ArrayList<>();
		
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.getConnetion();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = cf.getSelect()
				+ " order by bno desc limit ?, ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 0);
			pstmt.setInt(2, 10);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setBno(rs.getInt(1));
				board.setSubject(rs.getString("subject"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setReadcnt(rs.getInt("readcnt"));
				board.setCrtdate(rs.getString("crtdate"));
				boards.add(board);	
			}		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// dummpy
			}
		}	
		return boards;
	}

	@Override
	public BoardVO viewBoard(int bno) {
		BoardVO board = new BoardVO();
		
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.getConnetion();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = cf.getSelect() + " where bno = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board.setBno(bno);
				board.setSubject(rs.getString("subject"));
				board.setWriter(rs.getString("subject"));
				board.setContent(rs.getString("content"));
			} else {
				System.out.println("글번호(" + bno + ") 게시글을 찾지 못했습니다!");
			}
		} catch (Exception e) {
			System.out.println("게시글 조회 실패!!!");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// dummy
			}
		}
		return board;
	}

	@Override
	public void updateBoard(int bno) {
		
		BoardVO board = viewBoard(bno);
		String subject = JOptionPane.showInputDialog("수정할 글제목을 입력하세요", board.getSubject());
		String content = JOptionPane.showInputDialog("수정할 글내용을 입력하세요", board.getContent());
		
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.getConnetion();
		PreparedStatement pstmt = null;
		String sql = cf.getUpdate();
		// update board set subject=?, content=? where bno = ?
		
		try {			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setInt(3, bno);
			
			int row = pstmt.executeUpdate();
			System.out.println("글번호(" + bno + ") 게시글이 성공적으로 수정되었습니다!");			
		} catch (Exception e) {
			System.out.println("게시글 수정 실패!!!");
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				// dummy
			}
		}
	}

	@Override
	public void deleteBoard(int bno) {
		
		BoardVO board = viewBoard(bno);
		
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.getConnetion();
		PreparedStatement pstmt = null;
		String sql = cf.getDelete();
		// delete from board where bno = ?
		
		try {			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			int row = pstmt.executeUpdate();
			System.out.println("글번호(" + bno + ") 게시글이 성공적으로 삭제되었습니다!");			
		} catch (Exception e) {
			System.out.println("게시글 삭제 실패!!!");
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				// dummy
			}
		}	
	}

	@Override
	public ArrayList<BoardVO> findBySubjectBoard(String subject) {
		ArrayList<BoardVO> boards = new ArrayList<>();
		
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.getConnetion();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = cf.getSelect() 
				+ " where subject like '%" + subject + "%'"
				+ " order by bno desc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setBno(rs.getInt(1));
				board.setSubject(rs.getString("subject"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setReadcnt(rs.getInt("readcnt"));
				board.setCrtdate(rs.getString("crtdate"));
				boards.add(board);	
			}		
		} catch (Exception e) {
			System.out.println("게시글 목록 조회 실패 by 글제목!!!");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// dummy
			}
		}		
		return boards;
	}

	@Override
	public ArrayList<BoardVO> findByWriterBoard(String writer) {
		
		ArrayList<BoardVO> boards = new ArrayList<>();
		
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.getConnetion();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = cf.getSelect() 
				+ " where writer like '%" + writer + "%'"
				+ " order by bno desc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setBno(rs.getInt(1));
				board.setSubject(rs.getString("subject"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setReadcnt(rs.getInt("readcnt"));
				board.setCrtdate(rs.getString("crtdate"));
				boards.add(board);
			}
		} catch (Exception e) {
			System.out.println("게시글 목록 조회 실패 by 작성자!!!");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// dummy
			}
		}
		return boards;
	}

}
