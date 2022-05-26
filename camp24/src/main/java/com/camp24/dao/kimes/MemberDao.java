package com.camp24.dao.kimes;

import java.sql.*;
import java.util.*;

import com.camp24.db.*;
import com.camp24.sql.kimes.*;
import com.camp24.vo.*;

/**
 * 이 클래스는 회원 관련 데이터베이스 작업을 전담해서 처리하는 클래스
 * @author	김은선
 * @since	2022.05.24
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.25	-	클래스제작
 * 									담당자 ] 김은선
 *
 */
	
public class MemberDao {

	private CmpDBCP db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private MemberSQL mSQL;
	
	public MemberDao() {
		db = new CmpDBCP();
		mSQL = new MemberSQL();
	}
	
	// 회원 가입 데이터베이스 작업 전담 처리함수
		public int addMember(MemberVO mVO) {
			// 반환값 변수
			int cnt = 0;
			// 커넥션
			con = db.getCon();
			// 질의명령
			String sql = mSQL.getSQL(mSQL.ADD_MEMBER);
			// 명령전달도구
			pstmt = db.getPSTMT(con, sql);
			try {
				// 질의명령 완성
				pstmt.setString(1, mVO.getId());
				pstmt.setString(2, mVO.getPw());
				pstmt.setString(3, mVO.getMname());
				pstmt.setString(4, mVO.getEmail());
				pstmt.setString(5, mVO.getTel());
				pstmt.setInt(6, mVO.getAno());
				pstmt.setString(7, mVO.getGen());
				
				// 질의명령 보내고 결과 가져오기
				cnt = pstmt.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				db.close(pstmt);
				db.close(con);
			}
			
			// 결과 반환
			return cnt;
		}
		
	// 아바타 리스트 조회 전담 처리함수
	public ArrayList<MemberVO> getAvtList(){
		// 반환값 변수
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		// 커넥션
		con = db.getCon();
		// 질의명령
		String sql = mSQL.getSQL(mSQL.SEL_ALL_AVT);
		// 명령전달도구
		stmt = db.getSTMT(con);
		try {
			// 질의명령 보내고 결과 가져오기
			rs = stmt.executeQuery(sql);
			// 반복해서 결과 꺼내고 VO에 저장
			while(rs.next()) {
				// 반복할 때마다 아바타 한개의 정보를 기억할 VO 생성
				MemberVO mVO = new MemberVO();
				// VO 에 아바타 정보 채우고
				mVO.setAno(rs.getInt("ano"));
				mVO.setSavename(rs.getString("savename"));
				mVO.setGen(rs.getString("gen"));
				
				// 완성된 VO 리스트에 저장
				list.add(mVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		// 결과 반환
		return list;
	}
	
	// 아이디 카운트 조회 전담 처리함수
	public int getIdCount(String id) {
		// 반환값 변수
		int cnt = 0;
		// 커넥션
		con = db.getCon();
		// 질의명령
		String sql = mSQL.getSQL(mSQL.SEL_ID_CNT);
		// 명령전달도구 준비
		pstmt = db.getPSTMT(con, sql);
		try {
			// 질의명령 완성
			pstmt.setString(1, id);
			// 보내고 결과 가져오기
			rs = pstmt.executeQuery();
			// 레코드포인터 한줄 내리고
			rs.next();
			
			// 데이터꺼내서 변수에 저장
			cnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		// 결과 반환
		return cnt;
	}
	
	// 회원정보수정 데이터베이스 작업 전담 처리함수
		public int editMyInfo(int mno, String psql) {
			// 반환값 변수
			int cnt = 0;
			// 커넥션
			con = db.getCon();
			// 질의명령
			String sql = mSQL.getSQL(mSQL.EDIT_MEMBER);
			// 질의명령 수정
			sql = sql.replace("###", psql);
			
			// 명령 전달도구
			pstmt = db.getPSTMT(con, sql);
			try {
				// 질의명령 완성
				pstmt.setInt(1, mno);
				// 질의명령 보내고 결과 가져오기
				cnt = pstmt.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				db.close(pstmt);
				db.close(con);
			}
			
			//결과 반환
			return cnt;
		}
		
		// 아이디로 회원 정보조회 전담 처리함수
		public MemberVO getIdInfo(String id) {
			// 반환값 변수
			MemberVO mVO = new MemberVO();
			// 커넥션
			con = db.getCon();
			// 질의명령
			String sql = mSQL.getSQL(mSQL.SEL_MEMBER_INFO);
			// 명령전달도구
			pstmt = db.getPSTMT(con, sql);
			try {
				// 질의명령 완성
				pstmt.setString(1, id);
				// 질의명령 보내고 결과 가져오기
				rs = pstmt.executeQuery();
				// 꺼내서 VO에 저장
				if(rs.next());
				// VO 세팅
				mVO.setMno(rs.getInt("mno"));
				mVO.setMname(rs.getString("mname"));
				mVO.setId(rs.getString("id"));
				mVO.setEmail(rs.getString("email"));
				mVO.setTel(rs.getString("tel"));
				mVO.setGen(rs.getString("gen"));
				mVO.setAno(rs.getInt("ano"));
				mVO.setSavename(rs.getString("savename"));
				mVO.setJdate(rs.getDate("joindate"));
				mVO.setJtime(rs.getTime("joindate"));
				mVO.setSdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				db.close(rs);
				db.close(pstmt);
				db.close(con);
			}
			
			// 결과 반환
			return mVO;
		}
	
/*							 임시 함수							 */	
	
	// 로그인 데이터베이스작업 전담 처리함수
		public int getLogin(String id, String pw) {
			int cnt = 0;
			// 커넥션
			con = db.getCon();
			// 질의명령
			String sql = mSQL.getSQL(mSQL.SEL_LOGIN_CNT);
			// 명령전달도구
			pstmt = db.getPSTMT(con, sql);
			try {
				// 질의명령 완성
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				// 질의명령 보내고 결과받고
				rs = pstmt.executeQuery();
				// 결과에서 데이터꺼내고
				rs.next();
				cnt = rs.getInt("cnt");
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				db.close(rs);
				db.close(pstmt);
				db.close(con);
			}
			
			// 데이터 내보내고
			return cnt;
		}
	
}
