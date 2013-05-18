package com.xox.test.service.impl;

import com.xox.test.service.TestService;

public class TestServiceImpl implements TestService {

	@Override
	public String getRandom() {
		return String.valueOf(Math.random());
	}

}
