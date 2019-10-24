package com.sto.es.po;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Data;
/**
 * @describe 产品
 * @author zhouqu
 * @date 2019年4月8日
 */
@Data
@Document(indexName = "item", type = "goods", shards = 1, replicas = 0)
public class Item implements Serializable {
	/**
	 * 主键id
	 */
	@Id
	private Integer id;

	/**
	 * 标题
	 */
	@Field(type = FieldType.Text, analyzer = "ik_max_word")
	private String title;

	/**
	 * 类别
	 */
	@Field(type = FieldType.Keyword)
	private String category;

	/**
	 * 品牌
	 */
	@Field(type = FieldType.Keyword)
	private String brand;

	/**
	 * 价格
	 */
	@Field(type = FieldType.Double)
	private BigDecimal price;

	/**
	 * 图片地址
	 */
	@Field(index = false, type = FieldType.Keyword)
	private String images;

	private static final long serialVersionUID = 1L;

}