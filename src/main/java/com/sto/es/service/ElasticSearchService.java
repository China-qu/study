package com.sto.es.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sto.es.po.Item;
/**
 * es业务处理
 * @describe 
 * @author zhouqu
 * @date 2019年4月9日
 */
@Service
public class ElasticSearchService {

	@Autowired
	private ItemRepository itemRepository;
	
	public void addEsData(Iterable<Item> iterable) {
		itemRepository.saveAll(iterable);
	}
	
	public void deleteEsData(Integer id) {
		itemRepository.deleteById(id);
	}
	
	public void updateEsData(Integer id) {
		Optional<Item> findById = itemRepository.findById(id);
		Item item = findById.get();
		item.setBrand("娃哈哈");
		itemRepository.save(item);
	}
	
	public String queryEsData() {
		Iterable<Item> all = itemRepository.findAll();
		return all.toString();
	}
}
