package com.wucstone.openJDK;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


/**
 *VM Args: -Xms20m -Xmx20 -XX:+HeapDumpOnOutOfMemoryError
 * @author wuc
 *
 */
public class OOMTest {

	
	
	@Test
	public void testOutOfMemory(){
		
		List<OOMTest> list=new ArrayList<OOMTest>();
		
		while(true){
			list.add(new OOMTest());
		}
	}
	
	@Test
	public void testIntern(){
		
		
		String str1=new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern()==str1);
		System.out.println(str1.intern());
		
		String str2=new StringBuilder("java").append("web").toString();
		System.out.println(str2.intern()==str2);
		System.out.println(str2.intern());
	}
	
	
	
}
