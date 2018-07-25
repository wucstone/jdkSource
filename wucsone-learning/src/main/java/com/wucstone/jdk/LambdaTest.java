package com.wucstone.jdk;

import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.CompareGenerator;


public interface LambdaTest {
	
	
	public static void main(String[] args) {


		List<String> list =Arrays.asList("a","a","s","d","f","g","h","j","k","l");
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Collator.getInstance().compare(o1, o2);
			}
		});
		System.out.println("_"+list);
		Collections.sort(list, (String o1,String o2) -> {
			return Collator.getInstance().compare(o1, o2);
		});
		System.out.println("_"+list);
		Collections.sort(list,(String o1,String o2) -> Collator.getInstance().compare(o1, o2));
		System.out.println("_"+list);
		Collections.sort(list,( o1, o2) -> Collator.getInstance().compare(o1, o2));
		System.out.println("_"+list);
		
		
		
		Predicate<String> p =""::equals;
		
		
		System.out.println(p.test(""));
		
		System.out.println((p.or("a"::equals)).test("s"));
		
		list=list.stream().distinct().collect(Collectors.toList());
		System.out.println(list);
		
		
		list.stream().filter(node -> Collator.getInstance().compare(node, "f")>0).forEach(System.out::print);
		
		"abcdef".chars().skip(1).forEach(i ->{System.out.print((char)i);});
		System.out.println("\n---------------------\n");
		"abcdef".chars().filter(i -> (i+"").chars().allMatch(m ->m==97)).forEach(a ->{System.out.println((char)a);});;
		
		
		
		
		

		
	}
	
	

}
