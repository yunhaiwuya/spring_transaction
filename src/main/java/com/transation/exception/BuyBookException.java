package com.transation.exception;

@SuppressWarnings("serial")
public class BuyBookException extends Exception{

	public BuyBookException(){
		super();
	}
	public BuyBookException(String message){
		super(message);
	}
}
