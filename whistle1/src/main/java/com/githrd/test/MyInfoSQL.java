package com.githrd.test;

public class MyInfoSQL {
	public final int SEL_MY_INFO 	= 9999;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_MY_INFO:
			buff.append("SELECT ");
			buff.append("	mno, name, id, mail, tel, joinadate, gen, avt");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			buff.append("	AND id = ? ");
			break;
		}
		return buff.toString();
	}
}