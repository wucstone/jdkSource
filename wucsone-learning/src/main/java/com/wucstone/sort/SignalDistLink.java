package com.wucstone.sort;

public class SignalDistLink {
	
	private  SignalDistLink next;
	private  String name;
	
	public SignalDistLink next(){
		return next;
	}
	
	public boolean hasNext(){
		return next!=null;
	}

	public SignalDistLink() {
		// TODO Auto-generated constructor stub
	}

	public SignalDistLink(SignalDistLink next, String name) {
		super();
		this.next = next;
		this.name = name;
	}
	
	public SignalDistLink(String name) {
		super();
		this.name = name;
	}

	public SignalDistLink getNext() {
		return next;
	}

	public void setNext(SignalDistLink next) {
		this.next = next;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
