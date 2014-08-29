package com.mangolanguages.assessment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

/*
 * Author: Ricky G.
 * Date: Aug.27
 * Email: jiguan@indiana.edu
 * Time complexity: O(n^2)
 */

public class DependencyCalculator {
	Map<String, HashSet<String>> dep_plus = new HashMap<>();
	
	public void add_direct(Map<String, HashSet<String>> dep) {
		for (Entry<String, HashSet<String>> entry : dep.entrySet()) {
		    String key = entry.getKey();
		    HashSet<String> infer_set = new HashSet<String>(entry.getValue());
		    Queue<String> queue = new LinkedList<>();
		    for(String infer_key : new HashSet<String>(infer_set)) { //add new values into infer_set, we need another copy
		    	if(dep_plus.containsKey(infer_key)) {
		    		infer_set.addAll(dep_plus.get(infer_key)); //use previous mapping result to save time
		    	} else {
		    		queue.add(infer_key); //dep_plus has no such a key means we need to go back to the original dep map to find out.
		    	}
		    }
		    HashSet<String> visited_node = new HashSet<>();
		    while(!queue.isEmpty()) { //hot spot, in worst case, it will go over every node
		    	String infer_key = queue.poll();
		    	visited_node.add(infer_key);
		    	HashSet<String> plus_set = new HashSet<String>();
		    	if(dep.containsKey(infer_key)) {
		    		plus_set = dep.get(infer_key);
		    	}
		    	infer_set.addAll(plus_set);
		    	for(String new_infer_key : plus_set) { //this loop doesn't take much time, its complexity equals queue.addall();
		    		if(!visited_node.contains(new_infer_key)) {
		    			queue.add(new_infer_key);
		    		}
		    	}
		    }
		    if(infer_set.contains(key)) infer_set.remove(key);
		    dep_plus.put(key, infer_set);
		}		
	}
	
	
	public String dependencies_for(String key) {
		if(!dep_plus.containsKey(key)) return null;
		StringBuffer buf = new StringBuffer();
		for(String infer_key : dep_plus.get(key)) {
			buf.append(infer_key+" ");
		}
		return buf.deleteCharAt(buf.length()-1).toString();
	}
	
//	private void prettyPrint(Map<String, HashSet<String>> dep_plus) {
//		for(Entry<String, HashSet<String>> entry : dep_plus.entrySet()) {
//			  String key = entry.getKey();
//			  HashSet<String> value = entry.getValue();
//			  System.out.print(key+" -> ");
//			  for(String key_plus : value) {
//				  System.out.print(key_plus + " ");
//			  }
//			  System.out.println();
//		}
//	}

}
