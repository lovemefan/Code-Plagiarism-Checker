import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

public class text20181221 {
	String str = "��������";
	String strs = "����";
	
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
		System.out.println("ArrayList������");
		ArrayList<String> arrayList = new ArrayList<>();
		System.out.println("ԭʼ״̬Ϊ��" + arrayList);
		arrayList.add(strs);
		System.out.println("��Ӻ�Ϊ��" + arrayList );
		arrayList.set(0, str);
		System.out.println("�޸ĺ�Ϊ��" + arrayList);
		System.out.println("��ѯ��һ��Ԫ�أ�" + arrayList.get(0));
		arrayList.remove(0);
		System.out.println("ɾ����Ϊ��" + arrayList);
		System.out.println();
	}
	
	public void linkedList(){
		System.out.println("LinkedList������");
		LinkedList<String> linkedList = new LinkedList<>();
		System.out.println("ԭʼ״̬Ϊ��" + linkedList);
		linkedList.add(strs);
		System.out.println("��Ӻ�Ϊ��" + linkedList );
		linkedList.set(0, str);
		System.out.println("�޸ĺ�Ϊ��" + linkedList);
		System.out.println("��ѯ��һ��Ԫ�أ�" + linkedList.get(0));
		linkedList.remove(0);
		System.out.println("ɾ����Ϊ��" + linkedList);
		System.out.println();
	}
	
	public void hashSet(){
		System.out.println("HashSet������");
		HashSet<String> hashSet = new HashSet<>();
		System.out.println("ԭʼ״̬Ϊ��" + hashSet);
		hashSet.add(strs);
		System.out.println("��Ӻ�Ϊ��" + hashSet );
		hashSet.remove(strs);
		hashSet.add(str);
		System.out.println("�޸ĺ�Ϊ��" + hashSet);
		for(String n:hashSet){
			if(n.equals(str)){
				System.out.println("��ѯԪ��str�ַ�����" + n);
			}
		}
		hashSet.remove(0);
		System.out.println("ɾ����Ϊ��" + hashSet);
		System.out.println();
	}
	
	public void linkedHashSet(){
		System.out.println("LinkedHashSet������");
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
		System.out.println("ԭʼ״̬Ϊ��" + linkedHashSet);
		linkedHashSet.add(strs);
		System.out.println("��Ӻ�Ϊ��" + linkedHashSet );
		linkedHashSet.remove(strs);
		linkedHashSet.add(str);
		System.out.println("�޸ĺ�Ϊ��" + linkedHashSet);
		for(String n:linkedHashSet){
			if(n.equals(str)){
				System.out.println("��ѯԪ��str�ַ�����" + n);
			}
		}
		linkedHashSet.remove(0);
		System.out.println("ɾ����Ϊ��" + linkedHashSet);
		System.out.println();
	}
	
	public void treeSet(){
		System.out.println("TreeSet������");
		TreeSet<String> treeSet = new TreeSet<>();
		System.out.println("ԭʼ״̬Ϊ��" + treeSet);
		treeSet.add(strs);
		System.out.println("��Ӻ�Ϊ��" + treeSet );
		treeSet.remove(strs);
		treeSet.add(str);
		System.out.println("�޸ĺ�Ϊ��" + treeSet);
		for(String n:treeSet){
			if(n.equals(str)){
				System.out.println("��ѯԪ��str�ַ�����" + n);
			}
		}
		treeSet.remove(0);
		System.out.println("ɾ����Ϊ��" + treeSet);
		System.out.println();
	}
	
	public void treeMap(){
		System.out.println("TreeMap������");
		TreeMap<String,Integer> treeMap = new TreeMap<>();
		System.out.println("ԭʼ״̬Ϊ��" + treeMap);
		treeMap.put(strs, 1);
		System.out.println("��Ӻ�Ϊ��" + treeMap );
		treeMap.remove(strs);
		treeMap.put(str,2);
		System.out.println("�޸ĺ�Ϊ��" + treeMap);
		System.out.println("��ѯԪ��str�ַ�����" + treeMap.get(str));
		treeMap.remove(str);
		System.out.println("ɾ����Ϊ��" + treeMap);
		System.out.println();
	}
	
	public void linkedHashMap(){
		System.out.println("LinkedHashMap������");
		LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<>();
		System.out.println("ԭʼ״̬Ϊ��" + linkedHashMap);
		linkedHashMap.put(strs, 1);
		System.out.println("��Ӻ�Ϊ��" + linkedHashMap );
		linkedHashMap.remove(strs);
		linkedHashMap.put(str,2);
		System.out.println("�޸ĺ�Ϊ��" + linkedHashMap);
		System.out.println("��ѯԪ��str�ַ�����" + linkedHashMap.get(str));
		linkedHashMap.remove(str);
		System.out.println("ɾ����Ϊ��" + linkedHashMap);
		System.out.println();
	}

	public void hashMap(){
		System.out.println("HashMap������");
		HashMap<String,Integer> hashMap = new HashMap<>();
		System.out.println("ԭʼ״̬Ϊ��" + hashMap);
		hashMap.put(strs, 1);
		System.out.println("��Ӻ�Ϊ��" + hashMap);
		hashMap.remove(strs);
		hashMap.put(str,2);
		System.out.println("�޸ĺ�Ϊ��" +hashMap);
		System.out.println("��ѯԪ��str�ַ�����" + hashMap.get(str));
		hashMap.remove(str);
		System.out.println("ɾ����Ϊ��" + hashMap);
		System.out.println();
	}
	
}
