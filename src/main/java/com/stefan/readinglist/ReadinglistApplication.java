package com.stefan.readinglist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReadinglistApplication {

	private static Logger logger= LoggerFactory.getLogger(ReadinglistApplication.class);	//如果使用this， 会遇到无法从静态上下文中引用非静态

	public static void main(String[] args) {
		logger.info("The {} has started.","Reading List");
		SpringApplication.run(ReadinglistApplication.class, args);
	}

}
