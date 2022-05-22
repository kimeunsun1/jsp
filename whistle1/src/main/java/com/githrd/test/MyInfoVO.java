package com.githrd.test;

import java.text.*;
import java.util.Date;

public class MyInfoVO {
	private int mno;
	private String name, id, mail, tel, gen, avt;
	private Date joinadate;
	
	
	public int getMno() {
		return mno;
	}


	public void setMno(int mno) {
		this.mno = mno;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getGen() {
		return gen;
	}


	public void setGen(String gen) {
		this.gen = gen;
	}


	public String getAvt() {
		return avt;
	}


	public void setAvt(String avt) {
		this.avt = avt;
	}


	public Date getJoinadate() {
		return joinadate;
	}


	public void setJoinadate(Date joinadate) {
		this.joinadate = joinadate;
	}

	@Override
	public String toString() {
		return "MemberVO [mno=" + mno + ", name=" + name + ", id=" + id + ", mail=" + mail + ", tel=" + tel + ", gen="
				+ gen + ", avt=" + avt + ", joinadate=" + joinadate + "]";
	}


	public String getJson() {
		StringBuffer buff = new StringBuffer();
		buff.append("{\r\n");
		buff.append("\"mno\": \"" + mno + "\",\r\n");
		buff.append("\"name\": \"" + name + "\",\r\n");
		buff.append("\"id\": \"" + id + "\",\r\n");
		buff.append("\"mail\": \"" + mail + "\",\r\n");
		buff.append("\"tel\": \"" + tel + "\",\r\n");
		buff.append("\"savename\": \"" + joinadate + "\",\r\n");
		buff.append("\"gen\": \"" + (gen.equals("M")?"남자":"여자") + "\",\r\n");
		buff.append("\"sdate\": \"" + avt + "\"\r\n");
		buff.append("}");
		return buff.toString();
	}
}
