package com.sto.es.service;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import com.sto.es.po.Item;
@Component
public interface ItemRepository extends ElasticsearchRepository<Item, Integer> {
	
}
