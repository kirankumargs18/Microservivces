package com.globallogic.controller;

import java.util.UUID;

public class TestMain {

	public static void main(String[] args) {
		
	 String name=UUID.randomUUID().toString().replace("-", "");
	 
	 System.out.println(name);

	}

}
