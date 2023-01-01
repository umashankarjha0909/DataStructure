package com.test.practice;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SortHashMap {

	public static void main(String[] args) {
		/*
		 * HashMap<String, Integer> hm = new HashMap<String, Integer>();
		 * 
		 * // enter data into hashmap hm.put("Math", 98); hm.put("Data Structure", 85);
		 * hm.put("Database", 91); hm.put("Java", 95); hm.put("Operating System", 79);
		 * hm.put("Networking", 80); Map<String, Integer> hm1 = sortByValue(hm);
		 * 
		 * // print the sorted hashmap for (Map.Entry<String, Integer> en :
		 * hm1.entrySet()) { System.out.println("Key = " + en.getKey() + ", Value = " +
		 * en.getValue()); }
		 */
	}

	public static HashMap<Character, Integer> sortByKey(Map<Character, Integer> hm) {
		List<Map.Entry<Character, Integer>> list = new LinkedList<Map.Entry<Character, Integer>>(hm.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {

			@Override
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				return (o1.getKey()).compareTo(o2.getKey());
			}
		});

		HashMap<Character, Integer> temp = new LinkedHashMap<Character, Integer>();
		for (Map.Entry<Character, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}
	
	public static HashMap<Character, Integer> sortByValue(Map<Character, Integer> hm) {
		List<Map.Entry<Character, Integer>> list = new LinkedList<Map.Entry<Character, Integer>>(hm.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {

			@Override
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		HashMap<Character, Integer> temp = new LinkedHashMap<Character, Integer>();
		for (Map.Entry<Character, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}
}
