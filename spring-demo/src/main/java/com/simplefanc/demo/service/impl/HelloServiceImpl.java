package com.simplefanc.demo.service.impl;

import com.simplefanc.demo.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
	@Override
	public void sayHello() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("hello everybody");
	}

	@Override
	public void justWantToThrowException() {
		throw new RuntimeException("hello exception");
	}
}
