package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controller.MemberController;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
private MemberController memberControler;
	@Test
	void contextLoads() {
		memberControler.getMember();
	}

}
