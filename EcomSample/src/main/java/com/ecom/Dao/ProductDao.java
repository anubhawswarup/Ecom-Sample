package com.ecom.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
@Repository
public class ProductDao {

	@Autowired 
	private JdbcTemplate jdbctemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public String get(int id) {
		return jdbctemplate.queryForObject("select name from sample1 where quantity=?", String.class,id);
	}
	public void addProduct() {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		// add product to it 
		namedJdbcTemplate.update("",parameters/*insert query);*/);
	
	}
	public void buyProduct(String productName, Double quantity) {
		// 1 get product name and current quantity from the DB
		// if(current quantity is less than what he wants to buy then only give as much left)
		// if(current quantity is == 0) return
		// 2 update query to change quantity
	}
}
