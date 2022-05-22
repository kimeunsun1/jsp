package com.githrd.test;

import java.sql.*;
import java.util.*;

import com.githrd.test.db.*;
import com.githrd.test.sql.*;
import com.githrd.test.vo.*;

public class MyInfoDao {

	private JenyJDBC db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private MyInfoSQL mSQL;
	
	public MyInfoDao() {
		db = new JenyJDBC();
		mSQL = new MyInfoSQL();
	}
	
	// 데이터베이스작업 전담 처리함수
	public int getLogin(String id) {
		int cnt = 0;
		// 커넥션
		con = db.getCon();
		// 질의명령
		String sql = mSQL.getSQL(mSQL.SEL_MY_INFO);
		// 명령전달도구
		pstmt = db.getPstmt(con, sql);
		try {
			// 질의명령 완성
			pstmt.setString(1, id);
			// 질의명령 보내고 결과받고
			rs = pstmt.executeQuery(sql);
			//결과에서 데이터 꺼내고
			rs.next();
			cnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
				
		// 데이터 반환
		return cnt;
	}	
}
