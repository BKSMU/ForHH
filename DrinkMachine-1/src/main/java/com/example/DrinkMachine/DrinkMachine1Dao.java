package com.example.DrinkMachine;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
	public void insertOne(Bean bean) throws DataAccessException {

		//１件登録。登録、更新、削除はupdateを使う。第一引数はSQL、第二はPreparedStatement。
		String sql = "INSERT INTO ITEM(name, unitPrice, count, IsPr, RecordDate)"
				+ "VALUES(?, ?, ?, ?, ?)";
		jdbc.update(sql,
				bean.getName(),
				bean.getUnitPrice(),
				bean.getCount(),
				bean.getIsPr(),
				bean.getRecordDate());

	}

	public List<Bean> search() {
		String sql = "SELECT * FROM ITEM";
		List<Map<String, Object>> searcheALL = jdbc.queryForList(sql);

		List<Bean> serchList = new ArrayList<>();
		for (Map<String, Object> search : searcheALL) {
			Bean bean = new Bean();
			bean.setCode((int) search.get("CODE"));
			bean.setName((String) search.get("NAME"));
			bean.setUnitPrice((int) search.get("UNITPRICE"));
			bean.setCount((int) search.get("COUNT"));
			bean.setIsPr((int) search.get("ISPR"));
			bean.setRecordDate((Date) search.get("RECORDDATE"));

			serchList.add(bean);

		}

		return serchList;

	}

	public Bean searchOne(int code) throws DataAccessException {

		String sql = "SELECT code, name, unitPrice, count, IsPr, RecordDate " + "FROM ITEM " + "WHERE code = " + code;

		//		queryForMap 結果マップのクエリを実行
		Map<String, Object> searcheOne = jdbc.queryForMap(sql);
		Bean bean = new Bean();
		bean.setCode((int) searcheOne.get("CODE"));
		bean.setName((String) searcheOne.get("NAME"));
		bean.setUnitPrice((int) searcheOne.get("UNITPRICE"));
		bean.setCount((int) searcheOne.get("COUNT"));
		bean.setIsPr((int) searcheOne.get("ISPR"));
		bean.setRecordDate((Date) searcheOne.get("RECORDDATE"));

		return bean;
	}

	public int delete(int code) throws DataAccessException {

		String sql = "DELETE FROM ITEM WHERE code = ?";
		//１件削除
		int rowNumber = jdbc.update(sql, code);

		return rowNumber;
	}

	public int update(Bean bean) throws DataAccessException {

		String sql = "UPDATE ITEM SET name = ?, unitPrice = ?, count = ?, isPr = ?, recordDate = ? WHERE code = " + bean.getCode();
		//１件更新
		int rowNumber = jdbc.update(sql,
				bean.getName(),
				bean.getUnitPrice(),
				bean.getCount(),
				bean.getIsPr(),
				bean.getRecordDate());

		return rowNumber;
	}

}
