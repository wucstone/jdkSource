package com.wucstone.jdk;

import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;


public interface LambdaTest {
	
	
	public static void main(String[] args) {


		List<String> list =Arrays.asList("a","a","s","d","f","g","h","j","k","l");
		
//		Collections.sort(list, new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return Collator.getInstance().compare(o1, o2);
//			}
//		});
		
//		Collections.sort(list, (String o1,String o2) -> {
//			return Collator.getInstance().compare(o1, o2);
//		});
		
//		Collections.sort(list,(String o1,String o2) -> Collator.getInstance().compare(o1, o2));
		
//		Collections.sort(list,( o1, o2) -> Collator.getInstance().compare(o1, o2));
//		System.out.println(list);
		
		
		
//		Predicate<String> p =""::equals;
//		
//		
//		System.out.println(p.test(""));
//		
//		System.out.println((p.or("a"::equals)).test("s"));
		
		System.out.println(list);
		
//		list.stream().distinct();
		
		
		
		
		
		
		
		
	}
	
	

}
