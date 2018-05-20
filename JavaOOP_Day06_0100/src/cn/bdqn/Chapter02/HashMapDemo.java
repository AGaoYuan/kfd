package cn.bdqn.Chapter02;

import java.util.*;
import java.util.Map.Entry;


public class HashMapDemo {

	public static void main(String[] args) {
		Map<String,String> list = new HashMap<String,String>();
		list.put("CN", "中华人民共和国");
		list.put("PU", "俄罗斯联邦");
		list.put("FR", "法兰西共和国");
		list.put("US", "美利坚合众国");
		//list.put(null, "abc");
		//list.put("bcd", null);
		
		/*System.out.println(list.size());
		for (String item : list.keySet()) {
			System.out.print(item);
			System.out.print("===");
			String str = list.get(item);
			System.out.println(str);
		}*/
		
		Collection<String> values = list.values();
		for (String item : values) {
			System.out.println(item+"+++++");
		}
		
		Set<Entry<String, String>> entrySet = list.entrySet();
		for (Entry<String, String> item : entrySet) {
			System.out.println(item.getKey()+"---"+item.getValue());
		}
		Iterator<String> iterator = list.keySet().iterator();
		while(iterator.hasNext()){
			String next = iterator.next();
			System.out.println(next+"++++++++++"+list.get(next));
		}
		
		Iterator<String> iterator2 = list.values().iterator();
		while(iterator2.hasNext()){
			String next2 = iterator2.next();
			System.out.println(next2);
		}
		System.out.println("----------------");
		
		Iterator<Entry<String, String>> iterator3 = list.entrySet().iterator();
		while(iterator3.hasNext()){
			Entry<String, String> next3 = iterator3.next();
			System.out.println(next3.getKey()+next3.getValue());
		}
		
		
		
		/*String coun = (String) list.get("US");
		System.out.println(coun);
		
		System.out.println("Map接口中有多少组数据："+list.size());
		
		boolean bo = list.containsKey("FR");
		System.out.println(bo);
		
		boolean bool = list.containsValue("美利坚合众国");
		System.out.println(bool);
		
		list.remove("US");
		System.out.println(list.size());
		
		System.out.println(list.keySet());
		System.out.println(list.values());
		
		System.out.println(list);
		
		for (Object obj : list.keySet()) {
			String keyz = (String) obj;
			System.out.println(keyz);
		}*/
		
		
		
		
	}

}
