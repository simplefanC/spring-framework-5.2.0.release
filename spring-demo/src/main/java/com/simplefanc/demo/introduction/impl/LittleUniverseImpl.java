package com.simplefanc.demo.introduction.impl;

import com.simplefanc.demo.introduction.LittleUniverse;
import org.springframework.stereotype.Service;

@Service
public class LittleUniverseImpl implements LittleUniverse {
	@Override
	public void burningUp() {
		System.out.println("燃烧吧我的小宇宙");
	}
}
