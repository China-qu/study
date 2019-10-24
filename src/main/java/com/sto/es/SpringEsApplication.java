package com.sto.es;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sto.es.mapper")
public class SpringEsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEsApplication.class, args);
		System.out.println("========项目加载完毕!!!");
	}

}
