import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

public class text20181221 {
	String str = "测试数据";
	String strs = "测试";
	
	public static void main(String[] args) {
		text20181221 text = new text20181221();
		text.arrayList();
		text.linkedList();
		text.hashSet();
		text.linkedHashSet();
		text.treeMap();
		text.linkedHashMap();
		text.hashMap();
	}

	public void arrayList(){
		System.out.println("ArrayList操作：");
		ArrayList<String> arrayList = new ArrayList<>();
		System.out.println("原始状态为：" + arrayList);
		arrayList.add(strs);
		System.out.println("添加后为：" + arrayList );
		arrayList.set(0, str);
		System.out.println("修改后为：" + arrayList);
		System.out.println("查询第一个元素：" + arrayList.get(0));
		arrayList.remove(0);
		System.out.println("删除后为：" + arrayList);
		System.out.println();
	}
	
	public void linkedList(){
		System.out.println("LinkedList操作：");
		LinkedList<String> linkedList = new LinkedList<>();
		System.out.println("原始状态为：" + linkedList);
		linkedList.add(strs);
		System.out.println("添加后为：" + linkedList );
		linkedList.set(0, str);
		System.out.println("修改后为：" + linkedList);
		System.out.println("查询第一个元素：" + linkedList.get(0));
		linkedList.remove(0);
		System.out.println("删除后为：" + linkedList);
		System.out.println();
	}
	
	public void hashSet(){
		System.out.println("HashSet操作：");
		HashSet<String> hashSet = new HashSet<>();
		System.out.println("原始状态为：" + hashSet);
		hashSet.add(strs);
		System.out.println("添加后为：" + hashSet );
		hashSet.remove(strs);
		hashSet.add(str);
		System.out.println("修改后为：" + hashSet);
		for(String n:hashSet){
			if(n.equals(str)){
				System.out.println("查询元素str字符串：" + n);
			}
		}
		hashSet.remove(0);
		System.out.println("删除后为：" + hashSet);
		System.out.println();
	}
	
	public void linkedHashSet(){
		System.out.println("LinkedHashSet操作：");
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
		System.out.println("原始状态为：" + linkedHashSet);
		linkedHashSet.add(strs);
		System.out.println("添加后为：" + linkedHashSet );
		linkedHashSet.remove(strs);
		linkedHashSet.add(str);
		System.out.println("修改后为：" + linkedHashSet);
		for(String n:linkedHashSet){
			if(n.equals(str)){
				System.out.println("查询元素str字符串：" + n);
			}
		}
		linkedHashSet.remove(0);
		System.out.println("删除后为：" + linkedHashSet);
		System.out.println();
	}
	
	public void treeSet(){
		System.out.println("TreeSet操作：");
		TreeSet<String> treeSet = new TreeSet<>();
		System.out.println("原始状态为：" + treeSet);
		treeSet.add(strs);
		System.out.println("添加后为：" + treeSet );
		treeSet.remove(strs);
		treeSet.add(str);
		System.out.println("修改后为：" + treeSet);
		for(String n:treeSet){
			if(n.equals(str)){
				System.out.println("查询元素str字符串：" + n);
			}
		}
		treeSet.remove(0);
		System.out.println("删除后为：" + treeSet);
		System.out.println();
	}
	
	public void treeMap(){
		System.out.println("TreeMap操作：");
		TreeMap<String,Integer> treeMap = new TreeMap<>();
		System.out.println("原始状态为：" + treeMap);
		treeMap.put(strs, 1);
		System.out.println("添加后为：" + treeMap );
		treeMap.remove(strs);
		treeMap.put(str,2);
		System.out.println("修改后为：" + treeMap);
		System.out.println("查询元素str字符串：" + treeMap.get(str));
		treeMap.remove(str);
		System.out.println("删除后为：" + treeMap);
		System.out.println();
	}
	
	public void linkedHashMap(){
		System.out.println("LinkedHashMap操作：");
		LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<>();
		System.out.println("原始状态为：" + linkedHashMap);
		linkedHashMap.put(strs, 1);
		System.out.println("添加后为：" + linkedHashMap );
		linkedHashMap.remove(strs);
		linkedHashMap.put(str,2);
		System.out.println("修改后为：" + linkedHashMap);
		System.out.println("查询元素str字符串：" + linkedHashMap.get(str));
		linkedHashMap.remove(str);
		System.out.println("删除后为：" + linkedHashMap);
		System.out.println();
	}

	public void hashMap(){
		System.out.println("HashMap操作：");
		HashMap<String,Integer> hashMap = new HashMap<>();
		System.out.println("原始状态为：" + hashMap);
		hashMap.put(strs, 1);
		System.out.println("添加后为：" + hashMap);
		hashMap.remove(strs);
		hashMap.put(str,2);
		System.out.println("修改后为：" +hashMap);
		System.out.println("查询元素str字符串：" + hashMap.get(str));
		hashMap.remove(str);
		System.out.println("删除后为：" + hashMap);
		System.out.println();
	}
	
}
