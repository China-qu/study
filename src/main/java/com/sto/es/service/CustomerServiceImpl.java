package com.sto.es.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sto.es.mapper.TestCustomerMapper;
import com.sto.es.po.TestCustomer;

@Service
public class CustomerServiceImpl {
	@Autowired
	private TestCustomerMapper customerMapper;
	
	public void insert(TestCustomer record) {
		customerMapper.insert(record);
	}
}
