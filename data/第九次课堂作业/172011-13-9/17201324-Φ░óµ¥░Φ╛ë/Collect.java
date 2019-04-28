package text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Collect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> a=new ArrayList<>();
		a.add("123");
		a.add("456");
		a.add("789");
		System.out.println("arraylist");
		System.out.println(a);
		a.remove(0);
		System.out.println(a);
		a.set(1, "123");//实现更改操作
		System.out.println(a.get(0));
		System.out.println("linkedlist");
		LinkedList<String> l=new LinkedList<>();
		l.add("xie");
		l.add("jie");
		l.add("hui");
		System.out.println(l);
		l.remove(1);
		System.out.println(l);
		l.set(0, "jie");
		System.out.println(l);
		System.out.println(l.get(0));
		Set<String> e=new HashSet<>();
		e.add("nanchang");
		e.add("jiangxi");
		e.add("nanjing");
		e.add("nanchang");
		System.out.println("hashset");
		System.out.println("增");
		System.out.println(e);
		System.out.println("删");
		e.remove("nanchang");
		System.out.println(e);
		System.out.println(e.contains("jiangxi"));
		System.out.println("treeset");
		TreeSet<String> t=new TreeSet<>();
		t.add("yuwen");
		t.add("shuxue");
		t.add("yingyu");
		t.add("wuli");
		System.out.println(t);
		t.remove("yuwen");
		System.out.println(t);
		System.out.println(t.contains("shuxue"));
		System.out.println("hashmap");
		Map<Integer, String> m=new HashMap<>();
		m.put(0, "xingqiyi");
		m.put(1, "xingqier");
		m.put(2, "xingqisan");
		System.out.println(m);
		m.remove(1);
		System.out.println(m);
		System.out.println(m.get(0));
		System.out.println(m.keySet());
		System.out.println("treemap");
		TreeMap<Integer, String> tm=new TreeMap<>();
		tm.put(0, "string1");
		tm.put(1, "string2");
		tm.put(2, "string3");
		System.out.println(tm);
		tm.remove(0);
		System.out.println(tm);
		System.out.println(tm.get(1));

	}

}
