package com.wucstone.sort;

import org.junit.Test;

public class ReserveLinkedList {
	
	
	@Test
	public void testReserveLinkedList(){
		SignalDistLink a1 = new SignalDistLink("a");
		SignalDistLink a2 = new SignalDistLink("b");
		SignalDistLink a3 = new SignalDistLink("c");
		SignalDistLink a4 = new SignalDistLink("d");
		SignalDistLink a5 = new SignalDistLink("e");
		SignalDistLink a6 = new SignalDistLink("f");
		SignalDistLink a7 = new SignalDistLink("g");

		a1.setNext(a2);
		a2.setNext(a3);
		a3.setNext(a4);
		a4.setNext(a5);
		a5.setNext(a6);
		a6.setNext(a7);



		SignalDistLink current = a1;
		while(current.hasNext()){
			System.out.print(current.getName()+"-");
			current = current.getNext();
		}
		System.out.println(current.getName());
		
		
		
		SignalDistLink list = reserveLinkList(a1,a2,a1);
		
		
		SignalDistLink current_ = list;
		while(current_.hasNext()){
			System.out.print(current_.getName()+"-");
			current_ = current_.getNext();
		}
		System.out.println(current_.getName());
	}

	/**
	 * 
	 * @param first 当前的head节点 待互换位置的连标的头
	 * @param current 交换节点     待互换位置的连标的尾
	 * @param first_ 原head节点
	 * @return
	 */
	public SignalDistLink reserveLinkList(SignalDistLink first,SignalDistLink current,SignalDistLink first_){
		
		while(current.hasNext()){
			SignalDistLink next = current.next();
			
			first_.setNext(next);
			
			current.setNext(first);
			
			first=current;
			current=next;
		}
		current.setNext(first);
		first_.setNext(null);
		return current;
	}
}
