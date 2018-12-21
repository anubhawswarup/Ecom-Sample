package com.ecom.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.Dao.AccountDao;
import com.ecom.Dao.OrderDao;
import com.ecom.Dao.ProductDao;
import com.ecom.model.Account;
import com.ecom.model.Order;
import com.ecom.model.OrderedProduct;
import com.ecom.model.Product;

@Service
public class EcomService {

	@Autowired
	private AccountDao accountDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ProductDao productDao;

	public String get(int id) {
		return accountDao.get(id);
	}

	public Integer addOrder(Order order) {
		synchronized (this) {
			boolean validOrder = validate(order);
			if (validOrder) {
				try {
					processOrder(order.getOrderedProducts());
					orderDao.addOrder(order);
					return 1;
				} catch (Exception e) {
					// log the error
					return 0;
				}
			} else
				return 0;
		}
	}

	private void processOrder(List<OrderedProduct> orderedProducts) {
		orderedProducts.stream().forEach(prod->{
			productDao.buyProduct(prod.getProductName(),prod.getQuantity());
		});
	}

	private boolean validate(Order order) {
		return !(order.getAmount()==0);
	}

	@Transactional
	public void addAccount(Account account) {
		accountDao.addAccount();

	}

	@Transactional
	public void addProduct(Product product) {
		productDao.addProduct();
	}

}
