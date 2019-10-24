package com.sto.es.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sto.es.mapper.ItemDao;
import com.sto.es.po.Item;

@Service
@Transactional(rollbackFor=Exception.class)
public class ItemService {
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	@Autowired
	private ItemRepository itemRepository;
	
	public void batchInsert(List<Item> list) {
		itemDao.batchInsert(list);
	}
	
	public void insertEsData() {
		List<Item> list = itemDao.findAll();
		for (Item item : list) {
			itemRepository.save(item);
		}
	}

	public void addItemIndex() {
		elasticsearchTemplate.createIndex(Item.class);
	}
	
	public List<Item> getResultList(String queryVal) {
		//创建查询条件
		BoolQueryBuilder query = QueryBuilders.boolQuery();
		QueryBuilder matchQuery = QueryBuilders.matchQuery("title", queryVal);
		query.must(matchQuery);
		Iterable<Item> result = itemRepository.search(query);
		Iterator<Item> iterator = result.iterator();
		List<Item> list = new ArrayList<>();
		while (iterator.hasNext()) {
			list.add(iterator.next());
		}
		return list;
	}
}
