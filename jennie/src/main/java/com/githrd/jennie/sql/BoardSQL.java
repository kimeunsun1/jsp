package com.githrd.jennie.sql;

public class BoardSQL {
	public final int SEL_BOARD_LIST			=	1001;
	public final int SEL_TOTAL_COUNT		=	1002;

	public final int INSERT_BOARD			=	3001;
	public final int INSERT_FILEINFO		=	4001;

	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case INSERT_BOARD:
			buff.append("INSERT INTO ");
			buff.append("	board(bno, bmno, tile, body ");
			buff.append("VALUES( " );
			buff.append("	(SELECT(MAX(bno) + 1, 100001) FROM board), ");
			buff.append("	(SELECT mno FROM member WHERE id = ? ");
			buff.append("	?, ? ");
			buff.append(") ");
			break;
		case INSERT_FILEINFO:
			buff.append("INSERT INTO ");
			buff.append("	fileinfo(fno, fbno, oriname, savename, dir, len) ");
			buff.append("VALUES( " );
			buff.append("	(SELECT(NVL(fno) + 1, 10000001) FROM fileinfo), ");
			buff.append("	(SELECT MAX(bno) FROM board WHERE bmno = (SELECT mno FROM member WHERE id = ? )), ");
			buff.append("	?, ?, ?, ? ");
			buff.append(") ");
			break;
		case SEL_TOTAL_COUNT:
			buff.append("SELECT ");
			buff.append("	COUNT(*) cnt ");
			buff.append("FROM " );
			buff.append("	board ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			break;
		case SEL_BOARD_LIST:
			buff.append("INSERT INTO ");
			buff.append("	board(bno, bmno, tile, body ");
			buff.append("VALUES( " );
			buff.append("	(SELECT(MAX(bno) + 1, 100001) FROM board), ");
			buff.append("	(SELECT mno FROM member WHERE id = ? ");
			buff.append("	?, ? ");
			buff.append(") ");
			break;
		}
		return buff.toString();
	}
}