package com.example.DrinkMachine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("DrinkMachine1Dao")
public class DrinkMachine1Dao {

	@Autowired
	JdbcTemplate jdbc;

	public int count() throws DataAccessException {

		// 全件取得してカウント（カラムを一つだけ取得→queryForObject）
		int count = jdbc.queryForObject("SELECT * FROM ITEM", Integer.class);

		return count;
	}

	//@Override
	public void insertOne() throws DataAccessException {

		//１件登録。登録、更新、削除はupdateを使う。第一引数はSQL、第二はPreparedStatement。
		jdbc.update("INSERT INTO ITEM(name, unitPrice, count, IsPr, RecordDate)"
				+ "VALUES('ハチワレ', 600, 20, 1, '2022-10-10 00:00:19')");

		//    			int rowNumber = jdbc.update("INSERT INTO m_user(user_id,"
		//    	                + " password,"
		//    	                + " user_name,"
		//    	                + " birthday,"
		//    	                + " age,"
		//    	                + " marriage,"
		//    	                + " role)"
		//    	                + " VALUES(?, ?, ?, ?, ?, ?, ?)",

		//正常終了なら０を返す。異常は０以外を返す。

	}
}
