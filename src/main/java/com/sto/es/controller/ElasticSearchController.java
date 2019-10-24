package com.sto.es.controller;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.ArrayIterator;
import com.sto.es.po.Item;
import com.sto.es.service.ElasticSearchService;

@RequestMapping("/es")
@RestController
public class ElasticSearchController {
	@Autowired
	private ElasticSearchService elasticSearchService;

	@RequestMapping("/add")
	public String addEsData() {
		String[] titles = {"小米9全网通高配版","小天鹅8公斤洗衣机","居然之家舒适沙发",
				"戴尔灵越xps15","小米手机红米note7","联想Think-Pad4257","毛毯","加长版林肯","加大加厚水箱"};
		String[] categorys = {"A类","B类","C类","D类","E类"};
		String[] brands = {"小米有品","小天鹅","戴尔","华为","居然之家"};
		Item[] items = new Item[10];
		for (int i = 0; i < 10; i++) {
			Item item = new Item();
			item.setTitle(titles[new Random().nextInt(8)]);
			item.setBrand(brands[new Random().nextInt(4)]);
			item.setCategory(categorys[new Random().nextInt(4)]);
			item.setPrice(new BigDecimal(new Random().nextInt(2000)));
			item.setImages(UUID.randomUUID().toString().replaceAll("-", ""));
			items[i] = item;
		}
		Iterable<Item> iterable  = new ArrayIterator<>(items);
		elasticSearchService.addEsData(iterable);
		return "添加成功";
	}
	
	@RequestMapping("/delete")
	public String deleteEsData(@RequestParam(value="id") Integer id) {
		elasticSearchService.deleteEsData(id);
		return "删除成功";
	}
	
	@RequestMapping("/update")
	public String updateEsData(@RequestParam(value="id") Integer id) {
		elasticSearchService.updateEsData(id);
		return "更新成功";
	}
	
	@RequestMapping("query")
	public String queryEsData() {
		return elasticSearchService.queryEsData();
	}
}
