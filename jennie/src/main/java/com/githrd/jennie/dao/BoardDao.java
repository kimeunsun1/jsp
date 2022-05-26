package com.githrd.jennie.dao;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.githrd.jennie.db.*;
import com.githrd.jennie.sql.*;
import com.githrd.jennie.vo.*;

public class BoardDao {
	private BlpDBCP db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private BoardSQL bSQL;
	// 단일 파일 정보 데이터베이스 입력 전담 처리함수
	public int addFileInfo(FileVO fVO) {
		int cnt = 0;
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.INSERT_FILEINFO);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, fVO.getId());
			pstmt.setString(2, fVO.getOriname());
			pstmt.setString(3, fVO.getSavename());
			pstmt.setString(4, fVO.getDir());
			pstmt.setLong(5, fVO.getLen());
			
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 다중파일 데이터베이스 입력 전담 처리 함수
	public int addfileList(ArrayList<FileVO> list) {
		int cnt = 0;
		for(FileVO fVO : list) {
			cnt += addFileInfo(fVO);
		}
		return cnt;
	}
	// 게시글 정보입력 데이터베이스 작업 전담 처리함수
	public int addBoard(BoardVO bVO) {
		int cnt = 0;
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.INSERT_BOARD);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1,  bVO.getId());
			pstmt.setString(2,  bVO.getTitle());
			pstmt.setString(3,  bVO.getBody());
			
			cnt = pstmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 게시판 데이터베이스 등록 전담 처리함수
	public int insertBoardDate(BoardVO bVO) {
		int cnt = 0;
		cnt = addBoard(bVO);
		if(cnt != 1) {
			return cnt;
		}
		cnt = addfileList(bVO.getList());
		if(cnt != bVO.getList().size()){
			return -1;
		}
		return cnt;
	}
}
