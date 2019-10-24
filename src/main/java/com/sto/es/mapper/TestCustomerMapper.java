package com.sto.es.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sto.es.po.TestCustomer;
import com.sto.es.po.TestCustomerExample;

public interface TestCustomerMapper {
    long countByExample(TestCustomerExample example);

    int deleteByExample(TestCustomerExample example);

    int deleteByPrimaryKey(Integer customerId);

    int insert(TestCustomer record);

    int insertSelective(TestCustomer record);

    List<TestCustomer> selectByExample(TestCustomerExample example);

    TestCustomer selectByPrimaryKey(Integer customerId);

    int updateByExampleSelective(@Param("record") TestCustomer record, @Param("example") TestCustomerExample example);

    int updateByExample(@Param("record") TestCustomer record, @Param("example") TestCustomerExample example);

    int updateByPrimaryKeySelective(TestCustomer record);

    int updateByPrimaryKey(TestCustomer record);
}