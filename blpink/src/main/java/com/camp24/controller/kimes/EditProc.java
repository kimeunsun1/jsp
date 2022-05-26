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
 * 				2022.05.26	-	클래스제작
 * 									담당자 ] 김은선
 *
 */
	
public class EditProc implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", true);
		String view = "/camp24/ex/myInfo.cmp";
		
		// 로그인 체크
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			return "/camp24/ex/login.cmp";
		}
		
		// 파라미터 가져오기
		String smno = req.getParameter("mno");
		int mno = Integer.parseInt(smno);
		String name = req.getParameter("name");
		String pw = req.getParameter("pw");
		String mail = req.getParameter("mail");
		String tel = req.getParameter("tel");
		String sno = req.getParameter("ano");
		
		StringBuffer buff = new StringBuffer();
		
		if(name != null) {
			buff.append(" , mname = '" + name + "' ");
		}		
		if(pw != null) {
			buff.append(" , pw = '" + pw + "' ");
		}		
		if(mail != null) {
			buff.append(" , email = '" + mail + "' ");
		}		
		if(tel != null) {
			buff.append(" , tel = '" + tel + "' ");
		}	
		if(sno != null) {
			buff.append(" , avt = " + sno + " ");
		}		
		String psql  = buff.toString().substring(3);
		
		// 데이터베이스 작업
		MemberDao mDao = new MemberDao();
		int cnt = mDao.editMyInfo(mno, psql);
		// 결과에 따라 처리
		if(cnt != 1) {
			// 실패한 경우
			view = "/camp24/editInfo.cmp";
		}
		// 결과 반환
		return view;
	}

}
