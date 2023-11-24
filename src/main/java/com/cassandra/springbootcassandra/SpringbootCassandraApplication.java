package com.cassandra.springbootcassandra;

import com.cassandra.springbootcassandra.controller.ProductController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootCassandraApplication {
	private static final Logger log = LoggerFactory.getLogger(SpringbootCassandraApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCassandraApplication.class, args);
	}

}
