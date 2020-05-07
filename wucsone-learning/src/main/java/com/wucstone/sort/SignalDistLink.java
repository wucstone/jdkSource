package com.wucstone.sort;

import lombok.Data;

@Data
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

}
