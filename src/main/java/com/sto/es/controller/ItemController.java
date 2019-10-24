package com.sto.es.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sto.es.po.Item;
import com.sto.es.service.ItemRepository;
import com.sto.es.service.ItemService;

@RequestMapping("/item")
@RestController
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("batchInsert")
	public String batchInsert() {
		String result = "success";
		try {
			String[] titles = {"小米9全网通高配版","小天鹅8公斤洗衣机","居然之家舒适沙发",
					"戴尔灵越xps15","小米手机红米note7","联想Think-Pad4257","毛毯","加长版林肯","加大加厚水箱"};
			String[] categorys = {"A类","B类","C类","D类","E类"};
			String[] brands = {"小米有品","小天鹅","戴尔","华为","居然之家"};
			List<Item> list = new ArrayList<>();
			for (int i = 0; i < 10; i++) {
				Item item = new Item();
				item.setTitle(titles[new Random().nextInt(8)]);
				item.setBrand(brands[new Random().nextInt(4)]);
				item.setCategory(categorys[new Random().nextInt(4)]);
				item.setPrice(new BigDecimal(new Random().nextInt(2000)));
				item.setImages(UUID.randomUUID().toString().replaceAll("-", ""));
				list.add(item);
			}
			itemService.insertEsData();
		} catch (Exception e) {
			result = "error";
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/getResultList")
	public List<Item> getResultList(@RequestParam(value="val") String val) {
		return itemService.getResultList(val);
	}
	
	@RequestMapping("/additemindex")
	public String addItemIndex() {
		String result = "添加索引成功!";
		try {
			itemService.addItemIndex();
		} catch (Exception e) {
			result = "添加索引失败";
			e.printStackTrace();
		}
		return result;
	}
}
