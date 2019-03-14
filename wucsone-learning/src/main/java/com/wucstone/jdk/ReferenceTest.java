package com.wucstone.jdk;

import java.util.ArrayList;

public class ReferenceTest {
	public static class Student{
		private ReferenceTest.Clas clas;
		
		public Student(ReferenceTest.Clas clas) {
			this.clas = clas;
		}
		
	}
	public static class Clas{
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}
	public static void main(String[] args) {
//引用传递  值传递		
//		ReferenceTest.Clas c = new Clas();
//		c.setName("a");
//		ReferenceTest.Student s=new Student(c);
//		System.out.println(s.clas.getName());
//		change(s);
//		System.out.println(s.clas.getName());
		
	
//		堆溢出
//		ArrayList list =new ArrayList();
//		while(true){
//			list.add(new Clas());
//		}
		

		//栈溢出
//		test();
		
	}
	public static void test(){
		test();
	}
	
	public static void change(ReferenceTest.Student s) {
		ReferenceTest.Clas c = new Clas();
		c.setName("b");
		s=new Student(c);
	}
	

}
