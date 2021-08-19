package com.simplefanc.demo.service.impl;

import com.simplefanc.demo.service.HiService;
import org.springframework.stereotype.Service;

@Service
public class HiServiceImpl implements HiService {
	@Override
	public void sayHi() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("hi everyone");
	}

	@Override
	public String justWantToSayHi() {
		return "just want to say hi";
	}
}
