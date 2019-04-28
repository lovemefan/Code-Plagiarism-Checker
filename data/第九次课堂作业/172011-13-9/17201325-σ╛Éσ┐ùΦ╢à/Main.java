import java.util.*;

public class Main {
	public static void main(String[] args) {
		// Map
		HashMap<String,Integer> hashMap = new HashMap<>();
		
		hashMap.put("zzhui",18);
		hashMap.put("jbhui",19);
		hashMap.put("zzkang",20);
		hashMap.remove("jbhui");
		System.out.println(hashMap.get("zzhui"));
		hashMap.put("zzkang",100);// 覆盖即修改
		System.out.println(hashMap);
		System.out.println(hashMap.containsKey("zzhui"));
		
		TreeMap<String,Integer> treeMap = new TreeMap<>(hashMap);
		treeMap.put("zzkang",20);
		treeMap.remove("zzkang");
		System.out.println(treeMap.containsKey("zzhui"));
		
		LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<>(treeMap);
		linkedHashMap.put("jb",20);
		linkedHashMap.remove("jb");
		System.out.println(treeMap.containsKey("zzhui"));
		
		// Set
		HashSet<Integer> hashSet = new HashSet<>();
		
		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(3);
		hashSet.remove(2);
		System.out.println(hashSet.contains(2));
		System.out.println(hashSet);
		TreeSet<Integer> treeSet = new TreeSet<>(hashSet);
		treeSet.add(5);
		treeSet.add(8);
		treeSet.remove(8);
		System.out.println(treeSet.contains(2));
		System.out.println(treeSet);
		
		//list
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(0, 10);
		arrayList.add(3, 30);
		arrayList.remove(2);// 根据下标来删除
		System.out.println(arrayList.get(2));// 根据集合中元素下标位置来获取
		System.out.println(arrayList);
		
		LinkedList<Integer> linkedList = new LinkedList<>(arrayList);
		linkedList.add(1,20);
	    linkedList.remove(1);
	    linkedList.addFirst(100);
	    System.out.println(linkedList.get(2));// 根据集合中元素下标位置来获取

	}
}
