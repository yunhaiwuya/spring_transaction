package com.transation.model;

public class HelloWorld {

	private String message;

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void printHello(){
		System.out.println("hello,world. "+message);
	}
}
