package com.sto.es.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sto.es.po.TestCustomer;
import com.sto.es.service.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl customerService;
	
	@RequestMapping("/insert")
	public void insert() {
		TestCustomer customer = new TestCustomer();
		customer.setCustomerCode("STO-001");
		customer.setCustomerName("申通国际");
		customer.setCustomerCompany("STO");
		customer.setStatus(1);
		customer.setAddress("广东省深圳市宝安区XXX大道XXX号");
		customer.setCreateUser("admin");
		customer.setCreateDate(new Date());
		customerService.insert(customer);
	}

}
