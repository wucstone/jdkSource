package com.wucstone.jdk;

import java.text.Collator;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;



public interface LambdaTest {
	
	
	public static void main(String[] args) {


		List<String> list =Arrays.asList("a,b,c","a,c,b","s","d","f","g","h","j","k","l");
		
//		Collections.sort(list, new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return Collator.getInstance().compare(o1, o2);
//			}
//		});
//		System.out.println("_"+list);
//		Collections.sort(list, (String o1,String o2) -> {
//			return Collator.getInstance().compare(o1, o2);
//		});
//		System.out.println("_"+list);
//		Collections.sort(list,(String o1,String o2) -> Collator.getInstance().compare(o1, o2));
//		System.out.println("_"+list);
//		Collections.sort(list,( o1, o2) -> Collator.getInstance().compare(o1, o2));
//		System.out.println("_"+list);
//		
//		
//		
//		Predicate<String> p =""::equals;
//		
//		
//		System.out.println(p.test(""));
//		
//		System.out.println((p.or("a"::equals)).test("s"));
//		
//		list=list.stream().distinct().collect(Collectors.toList());
//		System.out.println(list);
//		
//		
//		list.stream().filter(node -> Collator.getInstance().compare(node, "f")>0).forEach(System.out::print);
//		
//		"abcdef".chars().skip(1).forEach(i ->{System.out.print((char)i);});
//		System.out.println("\n---------------------\n");
//		"abcdef".chars().filter(i -> (i+"").chars().allMatch(m ->m==97)).forEach(a ->{System.out.println((char)a);});;
		
		
//		list.stream().filter(a -> a.equals("a")).forEach(System.out::println);
		
//		list.stream().map(a -> a.split(",").length).forEach(System.out::println);
//		BinaryOperator<T>
//		Optional<T>
		
//		new Predicate(x -> x.equals("") ).test("1");

		Predicate test = x -> x.equals("");
		System.out.println(test.test("a"));
		
		BinaryOperator b = (Object x, Object y) -> Collator.getInstance().compare(x,y);
		
		System.out.println(b.apply("a", "b").toString());
		int count = 0;
		list.stream().map(a -> {
			HashMap<String,Integer> hash =new HashMap<String,Integer>();
			return Arrays.asList(a.split(",")).stream().map(x ->{
				HashMap<String,Integer> hashMap =new HashMap<String,Integer>();
				hashMap.put(x, 1);
				return hashMap;
			}).collect(Collectors.toList());
		}).forEach(System.out::println);
		
		Arrays.asList("a,b,c".split(",")).stream().map(y ->{
			HashMap<String,Integer> hashMap =new HashMap<String,Integer>();
			hashMap.put(y, 1);
			return hashMap;
		}).forEach(x -> System.out.println(x.getClass()));
		
		
		
		
	}
	
	

}
