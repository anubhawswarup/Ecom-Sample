package com.ecom.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class AccountDao {

	@Autowired 
	private JdbcTemplate jdbctemplate;
	public String get(int id) {
		return jdbctemplate.queryForObject("select name from sample1 where quantity=?", String.class,id);
	}
	public void addAccount() {
		//add account and user details along with it;
		
	}
}
