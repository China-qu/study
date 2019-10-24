package com.sto.es.mapper;

import java.util.List;

import com.sto.es.po.Item;

public interface ItemDao {

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
    
    void batchInsert(List<Item> list);
    
    List<Item> findAll();
}