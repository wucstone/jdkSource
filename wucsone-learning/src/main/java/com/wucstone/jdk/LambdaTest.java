package com.wucstone.jdk;

import java.util.Arrays;
import java.util.List;
import java.util.PrimitiveIterator.OfInt;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


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
		
		
		List<String> strs=Arrays.asList("1","2","3","4","5","6");
		strs.stream().filter(str -> !str.equals("1")).forEach(y ->System.out.print(y));
		System.out.println(strs.stream().filter(str -> !str.equals("1")).collect(Collectors.toList()));

		String ss="arbrcrdrerfr";
		OfInt ofint = ss.chars().iterator();
		boolean flag=true;
		String sss="";
		while(ofint.hasNext()){
			if(flag){
				sss+=(char) ofint.next().intValue();
			}else{
				ofint.next();
			}
			flag=flag ? false:true;
		}
		System.out.println(sss);
		ss.chars().filter(i ->(char)i!='r').forEach(i ->{System.out.print((char)i);});
//		"abc".chars().filter(i -> true).iterator() collect(supplier, accumulator, combiner).forEach(System.out::println);
		
		
		
		
//		list.stream().filter(str ->{
//			for (int i = 0;i<str.length(); i++) {
//				if(i%2==0){
//					str.s
//				}
//			}
//		});
		
		
		
		System.out.println(list);
		
//		list.stream().distinct();
		
		
		
		
		
		
		
		
	}
	
	

}
