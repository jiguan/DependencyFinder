package com.mangolanguages.assessment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;

import junit.framework.TestCase;

public class DependencyCalculatorTest extends TestCase {
	DependencyCalculator testCase;
	@Before
	public void setUp() {
		testCase = new DependencyCalculator();
	}
	
	
	public void testCalculator1() {
		Map<String, HashSet<String>> map = new HashMap<>();
		map.put("A", new HashSet<String>(Arrays.asList("B","C")));
		map.put("B", new HashSet<String>(Arrays.asList("C","E")));
		map.put("C", new HashSet<String>(Arrays.asList("G")));
		map.put("D", new HashSet<String>(Arrays.asList("A","F")));
		map.put("E", new HashSet<String>(Arrays.asList("F")));
		map.put("F", new HashSet<String>(Arrays.asList("H")));
		testCase.add_direct(map);
		HashSet<String> actual = new HashSet<String>(Arrays.asList(testCase.dependencies_for("A").split(" ")));
		HashSet<String> expected = new HashSet<String>(Arrays.asList("B C E F G H".split(" ")));
		assertTrue(actual.equals(expected));
	}
	
	
	public void testCalculator2() {
		Map<String, HashSet<String>> map = new HashMap<>();
		map.put("A", new HashSet<String>(Arrays.asList("B","C")));
		map.put("B", new HashSet<String>(Arrays.asList("C","E")));
		map.put("C", new HashSet<String>(Arrays.asList("G")));
		map.put("D", new HashSet<String>(Arrays.asList("A","F")));
		map.put("E", new HashSet<String>(Arrays.asList("F")));
		map.put("F", new HashSet<String>(Arrays.asList("H")));
		testCase.add_direct(map);
		HashSet<String> actual = new HashSet<String>(Arrays.asList(testCase.dependencies_for("B").split(" ")));
		HashSet<String> expected = new HashSet<String>(Arrays.asList("C E F G H".split(" ")));
		assertTrue(actual.equals(expected));
	}
	
	public void testCalculator3() {
		Map<String, HashSet<String>> map = new HashMap<>();
		map.put("A", new HashSet<String>(Arrays.asList("B","C")));
		map.put("B", new HashSet<String>(Arrays.asList("C","E")));
		map.put("C", new HashSet<String>(Arrays.asList("G")));
		map.put("D", new HashSet<String>(Arrays.asList("A","F")));
		map.put("E", new HashSet<String>(Arrays.asList("F")));
		map.put("F", new HashSet<String>(Arrays.asList("H")));
		testCase.add_direct(map);
		HashSet<String> actual = new HashSet<String>(Arrays.asList(testCase.dependencies_for("C").split(" ")));
		HashSet<String> expected = new HashSet<String>(Arrays.asList("G".split(" ")));
		assertTrue(actual.equals(expected));
	}
	
	public void testCalculator4() {
		Map<String, HashSet<String>> map = new HashMap<>();
		map.put("A", new HashSet<String>(Arrays.asList("B","C")));
		map.put("B", new HashSet<String>(Arrays.asList("C","E")));
		map.put("C", new HashSet<String>(Arrays.asList("G")));
		map.put("D", new HashSet<String>(Arrays.asList("A","F")));
		map.put("E", new HashSet<String>(Arrays.asList("F")));
		map.put("F", new HashSet<String>(Arrays.asList("H")));
		testCase.add_direct(map);
		HashSet<String> actual = new HashSet<String>(Arrays.asList(testCase.dependencies_for("D").split(" ")));
		HashSet<String> expected = new HashSet<String>(Arrays.asList("A B C E F G H".split(" ")));
		assertTrue(actual.equals(expected));
	}
	public void testCalculator5() {
		Map<String, HashSet<String>> map = new HashMap<>();
		map.put("A", new HashSet<String>(Arrays.asList("B","C")));
		map.put("B", new HashSet<String>(Arrays.asList("C","E")));
		map.put("C", new HashSet<String>(Arrays.asList("G")));
		map.put("D", new HashSet<String>(Arrays.asList("A","F")));
		map.put("E", new HashSet<String>(Arrays.asList("F")));
		map.put("F", new HashSet<String>(Arrays.asList("H")));
		testCase.add_direct(map);
		HashSet<String> actual = new HashSet<String>(Arrays.asList(testCase.dependencies_for("E").split(" ")));
		HashSet<String> expected = new HashSet<String>(Arrays.asList("F H".split(" ")));
		assertTrue(actual.equals(expected));
	}
	
	public void testCalculator6() {
		Map<String, HashSet<String>> map = new HashMap<>();
		map.put("A", new HashSet<String>(Arrays.asList("B","C")));
		map.put("B", new HashSet<String>(Arrays.asList("C","E")));
		map.put("C", new HashSet<String>(Arrays.asList("G")));
		map.put("D", new HashSet<String>(Arrays.asList("A","F")));
		map.put("E", new HashSet<String>(Arrays.asList("F")));
		map.put("F", new HashSet<String>(Arrays.asList("H")));
		testCase.add_direct(map);
		HashSet<String> actual = new HashSet<String>(Arrays.asList(testCase.dependencies_for("F").split(" ")));
		HashSet<String> expected = new HashSet<String>(Arrays.asList("H".split(" ")));
		assertTrue(actual.equals(expected));
	}
	
	public void testCalculator7() {
		Map<String, HashSet<String>> map = new HashMap<>();
		map.put("A", new HashSet<String>(Arrays.asList("B","C")));
		map.put("B", new HashSet<String>(Arrays.asList("C","E")));
		map.put("C", new HashSet<String>(Arrays.asList("G")));
		map.put("D", new HashSet<String>(Arrays.asList("A","F")));
		map.put("E", new HashSet<String>(Arrays.asList("F")));
		map.put("F", new HashSet<String>(Arrays.asList("H")));
		testCase.add_direct(map);
		String actual = testCase.dependencies_for("G");
		assertTrue(actual==null);
	}
	
	public void testCalculator8() {
		Map<String, HashSet<String>> map = new HashMap<>();
		map.put("A", new HashSet<String>(Arrays.asList("B","C")));
		map.put("B", new HashSet<String>(Arrays.asList("C","E")));
		map.put("C", new HashSet<String>(Arrays.asList("G")));
		map.put("D", new HashSet<String>(Arrays.asList("A","F")));
		map.put("E", new HashSet<String>(Arrays.asList("F")));
		map.put("F", new HashSet<String>(Arrays.asList("H")));
		testCase.add_direct(map);
		String actual = testCase.dependencies_for("H");
		assertTrue(actual==null);
	}
	
	public void testCalculator9() {
		Map<String, HashSet<String>> map = new HashMap<>();
		map.put("A", new HashSet<String>(Arrays.asList("B")));
		map.put("B", new HashSet<String>(Arrays.asList("C")));
		map.put("C", new HashSet<String>(Arrays.asList("A")));
		testCase.add_direct(map);
		HashSet<String> actual = new HashSet<String>(Arrays.asList(testCase.dependencies_for("A").split(" ")));
		HashSet<String> expected = new HashSet<String>(Arrays.asList("B C".split(" ")));
		assertTrue(actual.equals(expected));
	}
	
	public void testCalculator10() {
		Map<String, HashSet<String>> map = new HashMap<>();
		map.put("A", new HashSet<String>(Arrays.asList("B")));
		map.put("B", new HashSet<String>(Arrays.asList("C")));
		map.put("C", new HashSet<String>(Arrays.asList("A")));
		testCase.add_direct(map);
		HashSet<String> actual = new HashSet<String>(Arrays.asList(testCase.dependencies_for("B").split(" ")));
		HashSet<String> expected = new HashSet<String>(Arrays.asList("C A".split(" ")));
		assertTrue(actual.equals(expected));
	}
	public void testCalculator11() {
		Map<String, HashSet<String>> map = new HashMap<>();
		map.put("A", new HashSet<String>(Arrays.asList("B")));
		map.put("B", new HashSet<String>(Arrays.asList("C")));
		map.put("C", new HashSet<String>(Arrays.asList("A")));
		testCase.add_direct(map);
		HashSet<String> actual = new HashSet<String>(Arrays.asList(testCase.dependencies_for("C").split(" ")));
		HashSet<String> expected = new HashSet<String>(Arrays.asList("A B".split(" ")));
		assertTrue(actual.equals(expected));
	}
	public void testCalculator12() {
		Map<String, HashSet<String>> map = new HashMap<>();
		map.put("B", new HashSet<String>(Arrays.asList("A")));
		map.put("C", new HashSet<String>(Arrays.asList("A", "B")));
		map.put("D", new HashSet<String>(Arrays.asList("A", "B", "C")));
		map.put("E", new HashSet<String>(Arrays.asList("A", "B", "C", "D")));
		testCase.add_direct(map);
		HashSet<String> actual = new HashSet<String>(Arrays.asList(testCase.dependencies_for("C").split(" ")));
		HashSet<String> expected = new HashSet<String>(Arrays.asList("A B".split(" ")));
		assertTrue(actual.equals(expected));
	}
	

}
