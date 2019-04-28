import java.util.*;
public class Nine {
	public static void main(String[] args){
		ArrayList <String> mybooks = new ArrayList<>();
		mybooks.add("xiyouji");
		mybooks.add("hongloumeng");
		mybooks.add("shuihuzhuan");
		mybooks.set(2, "sanguoyanyi");
		mybooks.remove("hongloumeng");
		for(int i=0;i<mybooks.size();i++)
		System.out.println(mybooks.get(i));
		
		List<String>list = new  LinkedList<>();
		list.add("wuwei");
		list.add("fankai");
		list.add("llhou");
		list.remove(0);
		list.set(1, "xyx");
		System.out.println(list.get(1));
		
		Set<String>set = new HashSet<>();
		set.add("1");
		set.add("2");
		set.add("3");
		set.remove("2");
		for(String s: set)
			System.out.println(s);
		
		Set<String>set1 = new TreeSet<>();
		set1.add("adidas");
		set1.add("nike");
		set1.add("lining");
		set1.removeAll(set1);
		set1.add("anta");
		System.out.println(set1);
		
		HashMap<String,Double>map = new HashMap<>();
		map.put("ÓïÎÄ", 120.5);
		map.put("ÊıÑ§", 123.5);
		map.put("Ó¢Óï", 136.0);
		Iterator it = map.keySet().iterator();
		while(it.hasNext()){
			Object key = it.next();
			System.out.println(map.get(key));
		}
		
		TreeMap<Long,String>treeMap = new TreeMap<>();
		treeMap.put((long)2, "2");
		treeMap.put((long)3, "3");
		treeMap.put((long)4, "4");
		System.out.println(treeMap);
		
		
	}

}
