package com.camp24.controller.kimes;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.camp24.controller.kimes.*;
import com.camp24.dao.kimes.*;

/**
 * 이 클래스는 회원 관련 데이터베이스 작업을 전담해서 처리하는 클래스
 * @author	김은선
 * @since	2022.05.24
 * @version	v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.24	-	클래스제작
 * 									담당자 ] 김은선
 *
 */
	
public class IdCheck implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", null);
		StringBuffer buff = new StringBuffer();
		
		// 할일
		// 파라미터 가져오기
		String id = req.getParameter("id");
		// 데이터베이스에 요청
		MemberDao mDao = new MemberDao();
		// 결과 받기
		int cnt = mDao.getIdCount(id);
		
		// 결과에 따라 처리
		buff.append("{");
		buff.append("\"result\" : \"");
		
		if(cnt == 0) {
			// 사용가능한 아이디인 경우
			buff.append("OK");
		} else {
			// 사용불가능한 아이디인 경우
			buff.append("NO");			
		}
		buff.append("\"");
		buff.append("}");
		
		// 결과 반환		
		return buff.toString();
	}

}
