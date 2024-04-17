package com.example.sopt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestSoptApplication {

	public static void main(String[] args) {
		SpringApplication.from(SoptApplication::main).with(TestSoptApplication.class).run(args);
	}

}
