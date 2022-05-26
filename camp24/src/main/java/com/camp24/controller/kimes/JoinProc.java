package com.camp24.controller.kimes;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.camp24.controller.kimes.*;
import com.camp24.dao.kimes.*;
import com.camp24.vo.*;

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
	
public class JoinProc implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", true);
		String view = "/camp24/main.cmp";
		if(req.getSession().getAttribute("SID") != null) {
			return view;
		}
		
		// 파라미터 가져오기
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String mail = req.getParameter("mail");
		String tel = req.getParameter("tel");
		String gen = req.getParameter("gen");
		String sno = req.getParameter("ano");
		int ano = Integer.parseInt(sno);
		
		// VO에 저장
		MemberVO mVO = new MemberVO();		
		mVO.setId(id);
		mVO.setPw(pw);
		mVO.setMname(name);
		mVO.setEmail(mail);
		mVO.setTel(tel);
		mVO.setGen(gen);
		mVO.setAno(ano);
		
		/* System.out.println(mVO); */
		// 데이터베이스 작업
		MemberDao mDao = new MemberDao();
		int cnt = mDao.addMember(mVO);
		// 결과값에 따라 처리
		if(cnt != 1) {
			view = "/camp24/join.cmp";
			/* System.out.println("실패"); */
		} else {
			// 로그인 처리
			req.getSession().setAttribute("SID", id);
			/* System.out.println("성공"); */
		}
		
		return view;
	}

}
