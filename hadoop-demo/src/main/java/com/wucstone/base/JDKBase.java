package com.wucstone.base;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JDKBase {
	
	public static void main(String[] args) {
		
		
		Map map=new HashMap();
		map.put("name", "wuchuang");
		Set set=map.entrySet();
		Iterator i=set.iterator();
		while (i.hasNext()) {
			Entry<Object, Object> e= (Entry<Object, Object>) i.next();
			System.out.println(e.getKey()+"--"+e.getValue());
		}
	}

}
