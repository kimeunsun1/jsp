package com.camp24.sql.kimes;

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
	
public class MemberSQL {
	public final int ADD_MEMBER 		= 1001;
	public final int SEL_ID_CNT 		= 1002;	
	public final int SEL_ALL_AVT 		= 1003;
	
	public final int EDIT_MEMBER 		= 2001;
	
	public final int SEL_LOGIN_CNT 		= 9001;
	public final int SEL_MEMBER_INFO 	= 9002;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case ADD_MEMBER:
			buff.append("INSERT INTO ");
			buff.append("	member(mno, id, pw, mname, email, tel, avt, gen) ");
			buff.append("VALUES( ");
			buff.append("	(SELECT NVL(MAX(mno) + 1, 1001) FROM member), ");
			buff.append("	?, ?, ?, ?, ?, ?, ? ");
			buff.append(")");
			break;
		
		case SEL_ID_CNT:
			buff.append("SELECT ");
			buff.append("	COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	id = ? ");
			break;

		case SEL_ALL_AVT:
			buff.append("SELECT ");
			buff.append("	ano, savename, gen ");
			buff.append("FROM ");
			buff.append("	avatar ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			buff.append("	AND gen != 'N' ");
			break;
		
		case EDIT_MEMBER:
			buff.append("UPDATE ");
			buff.append("	member ");
			buff.append("SET ");
			buff.append("	### ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			buff.append("	AND mno = ? ");
			break;

			
		case SEL_LOGIN_CNT:
			buff.append("SELECT ");
			buff.append("	COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			buff.append("	AND id = ? ");
			buff.append("	AND pw = ? ");
			break;
		
		case SEL_MEMBER_INFO:
			buff.append("SELECT ");
			buff.append("	mno, mname, id, email, tel, m.gen, joindate, ano, savename ");
			buff.append("FROM ");
			buff.append("	member m, avatar ");
			buff.append("WHERE ");
			buff.append("	m.isshow = 'Y' ");
			buff.append("	AND avt = ano ");
			buff.append("	AND id = ? ");
			break;
		}
		return buff.toString();
	}
}