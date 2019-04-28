package wanghao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import wanghao.Test.Student;


public class Test {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("unchecked")
		Collection<String> list = new ArrayList();
		list.add("zhangsan");
		list.add("lisi");
		list.add("wangwu");
		list.add("1");
		System.out.println(list);
		list.remove("1");
		System.out.println(list);
		boolean empty = list.isEmpty();
		System.out.println(empty);
		int size = list.size();
		System.out.println(size);
		System.out.println(list.contains("wuli"));
		Set<String> set = new HashSet<String>();
		set.add("wuli");
		set.add("huaxue");
		set.add("yingyu");
		set.add("2");
		System.out.println(set);
		set.remove("2");
		System.out.println(set);
		boolean empty1 = set.isEmpty();
		System.out.println(empty1);
		int size1 = set.size();
		System.out.println(size1);
		System.out.println(set.contains("wuli"));
		Map<String,Student> student;
		
		
	}
}
class Student {
    	public String id;
    	public String name;
   
    	public Student(String id,String name){
    		this.id = id;
    		this.name = name;
    }
}