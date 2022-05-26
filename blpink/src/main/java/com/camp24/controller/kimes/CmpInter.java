package com.camp24.controller.kimes;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public interface CmpInter {
	String exec(HttpServletRequest req, HttpServletResponse resp) 
									throws ServletException, IOException;
}
