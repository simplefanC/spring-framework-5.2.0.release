package com.simplefanc.demo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("singleton")
public class GirlFriend {
	@Autowired
	private BoyFriend boyFriend;

//	public GirlFriend(BoyFriend boyFriend) {
//		this.boyFriend = boyFriend;
//	}
}
