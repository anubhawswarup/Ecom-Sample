package com.ecom.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ecom.model.Order;

@Repository
public class OrderDao {

	@Autowired
	private JdbcTemplate jdbctemplate;

	public String get(int id) {
		return jdbctemplate.queryForObject("select name from sample1 where quantity=?", String.class, id);
	}

	public void addOrder(Order order) {
		// adding order with details using insert query in to the ORDER table
	}
}
