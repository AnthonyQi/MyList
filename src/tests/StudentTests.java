package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import systemImp.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
public class StudentTests {
	
	//Testing MyStack Class
	@Test
	public void testingMyStack01() {
		try {
			MyStack ms = new MyStack(null);
		} catch(Exception e) {
			String ans = "Element type cannot be null.";
			assertEquals(ans, e.getMessage());
		}
	}
	
	@Test
	public void testingMyStack02() {
		MyStack ms = new MyStack(Person.class);
		assertEquals(Person.class, ms.elementType());
	}
	
	@Test
	public void testingPush() {
		MyStack ms = new MyStack(Person.class);
		Object o = new Object();
		try {
			ms.push(o);
		} catch(Exception e) {
			String ans = "Element type does not match stack element type.";
			assertEquals(ans, e.getMessage());
		}
	}
	
	@Test
	public void testingPop01() {
		MyStack ms = new MyStack(Integer.class);
		try {
			ms.pop();
		} catch(Exception e) {
			String ans = "Stack is empty. Cannot pop.";
			assertEquals(ans, e.getMessage());
		}
	}
	
	@Test
	public void testingPop2() {
		MyStack ms = new MyStack(Integer.class);
		ms.push(1);
		ms.push(2);
		int result = (int)ms.pop();
		int ans = 2;
		assertEquals(ans, result);
	}
	
	@Test
	public void testingPeek01() {
		MyStack ms = new MyStack(Integer.class);
		try {
			ms.peek();
		} catch(Exception e) {
			String ans = "Stack is empty. Cannot peek.";
			assertEquals(ans, e.getMessage());
		}
	}
	
	@Test
	public void testingPeek02() {
		MyStack ms = new MyStack(Integer.class);
		int rand = ((int)Math.random()*5) + 1;
		ms.push(rand);
		ms.push(rand);
		ms.push(rand);
		ms.push(5);
		int ans = 5;
		int result = (int)ms.peek();
		assertEquals(ans, result);
	}
	
	@Test
	public void testingIsEmpty() {
		//Testing empty
		MyStack ms = new MyStack(Integer.class);
		boolean result1 = ms.isEmpty();
		assertTrue(result1);
		//Testing with one item
		ms.push(5);
		boolean result2 = ms.isEmpty();
		assertFalse(result2);
	}
	
	@Test
	public void testingSizeMS() {
		//Testing with empty
		MyStack ms = new MyStack(Integer.class);
		int size = ms.size();
		assertEquals(size, 0);
		//Testing with 4 elements pushed
		ms.push(1);
		ms.push(2);
		ms.push(3);
		ms.push(4);
		int size2 = ms.size();
		assertEquals(4, size2);
	}
	
	@Test
	public void testingClearMS() {
		MyStack ms = new MyStack(Integer.class);
		//Testing not complete array
		ms.push(1);
		ms.push(1);
		ms.push(1);
		ms.push(1);
		int size = ms.size();
		assertEquals(size, 4);
		ms.clear();
		int size2 = ms.size();
		assertEquals(0, size2);
	}
	
	@Test
	public void testingElementType() {
		MyStack ms1 = new MyStack(Integer.class);
		assertEquals(Integer.class, ms1.elementType());
		MyStack ms2 = new MyStack(String.class);
		assertEquals(String.class, ms2.elementType());
	}
	
	@Test
	public void testingToStringMS() {
		//Testing to see if it prints the correct array
		MyStack ms = new MyStack(Integer.class);
		ms.push(1);
		ms.push(1);
		ms.push(1);
		ms.push(1);
		ms.push(1);
		String result = ms.toString();
		String ans = "Stack: [1, 1, 1, 1, 1]";
		assertEquals(ans, result);	
	}
	
	//Testing MyArrayList Class
	@Test
	public void testingMyArrayList01() {
		try {
			MyArrayList mal = new MyArrayList(null);
		} catch(Exception e) {
			String ans = "Element type cannot be null.";
			assertEquals(ans, e.getMessage());
		}
	}
	
	@Test
	public void testingMyArrayList02() {
		MyArrayList mal = new MyArrayList(String.class);
		assertEquals(String.class, mal.elementType);
	}
	
	@Test
	public void testingAddAndGet() {
		MyArrayList mal = new MyArrayList(Integer.class);
		//Testing add not null but not same instance
		try {
			mal.add("String");
		} catch(Exception e) {
			String ans = "Invalid element type.";
			assertEquals(ans, e.getMessage());
		}
		//Testing add and get
		mal.add(1);
		mal.add(2);
		int ans = 2;
		assertEquals((int)mal.get(1), ans);
		//maximizing out the array
		for(int i = (int)mal.get(1) + 1; i <= 12; i++) {
			mal.add(i);
		}
		//since it's integer class, it can contain null elements
		//shouldn't return anything due to it being out of the size
		//System.out.print(mal.printFullArray());
		try {
			mal.get(15);
		} catch(Exception e) {
			assertEquals("Index out of bounds.", e.getMessage());
		}
		assertEquals(mal.size(), 12);
	}
	
	@Test
	public void testingRemoveIndex() {
		MyArrayList mal = new MyArrayList(Integer.class);
		Integer one = 1;
		Integer two = 2;
		try {
			mal.remove(-1);
		} catch(Exception e) {
			assertEquals("Index out of bounds.", e.getMessage());
		}
		try {
			mal.remove(11);
		} catch(Exception e) {
			assertEquals("Index out of bounds.", e.getMessage());
		}
		try {
			mal.remove(0);
		} catch(Exception e) {
			assertEquals("Index out of bounds.", e.getMessage());
		}
		mal.add(one);
		try {
			mal.remove(1);
		} catch(Exception e) {
			assertEquals("Index out of bounds.", e.getMessage());
		}
		
		mal.add(two);
		assertEquals("[1, 2]", mal.toString());
		mal.remove(0);
		assertEquals("[2]", mal.toString());
	}
	
	@Test
	public void testingRemoveObject() {
		MyArrayList mal = new MyArrayList(Integer.class);
		Integer one = 1;
		Integer two = 2;
		Integer three = 3;
		mal.add(one);
		mal.add(two);
		//testing removing a non-existent object
		try {
			mal.remove(three);
		} catch(Exception e) {
			assertEquals("Element not found.", e.getMessage());
		}
		//testing null object
		try {
			mal.remove(null);
		} catch(Exception e) {
			assertEquals("Element not found.", e.getMessage());
		}
		//testing an integer not in the array
		try {
			mal.remove((Integer)5);
		} catch(Exception e) {
			assertEquals("Element not found.", e.getMessage());
		}
		//complete list
		mal.add(three);
		assertEquals("[1, 2, 3]", mal.toString());
		//does it remove and move?
		mal.remove(two);
		assertEquals("[1, 3]", mal.toString());
	}
	
	@Test
	public void testingSizeMAL() {
		MyArrayList mal = new MyArrayList(Integer.class);
		Integer one = 1;
		Integer two = 2;
		Integer three = 3;
		mal.add(one);
		mal.add(two);
		//testing if it correct returns the right size
		assertEquals(2, mal.size());
		for(int i = 0; i < 10; i++) {
			mal.add(three);
		}
		assertEquals(12, mal.size());
	}
	
	@Test
	public void testingTrimToSize() {
		MyArrayList mal = new MyArrayList(Integer.class);
		Integer one = 1;
		Integer two = 2;
		Integer three = 3;
		mal.add(one);
		mal.add(two);
		//creating a big list of 12 elements
		for(int i = 0; i < 10; i++) {
			mal.add(three);
		}
		//printing full array works
		assertEquals("[1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,"
				+ " null, null, null, null, "
				+ "null, null, null, null]", 
				mal.printFullArray());
		mal.trimToSize();
		//after trimToSize method
		assertEquals("[1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3]"
				, mal.printFullArray());
	}
	
	@Test
	public void testingSubList() {
		MyArrayList mal = new MyArrayList(Integer.class);
		Integer one = 1;
		for(int i = 0; i < 5; i++) {
			mal.add(one);
		}
		try {
			mal.sublist(0, 0);
		} catch(Exception e) {
			assertEquals("Invalid index range.", e.getMessage());
		}
		try {
			mal.sublist(-1, 3);
		} catch(Exception e) {
			assertEquals("Invalid index range.", e.getMessage());
		}
		try {
			mal.sublist(1, 6);
		} catch(Exception e) {
			assertEquals("Invalid index range.", e.getMessage());
		}
		try {
			mal.sublist(6, 9);
		} catch(Exception e) {
			assertEquals("Invalid index range.", e.getMessage());
		}
		try {
			mal.sublist(4, 3);
		} catch(Exception e) {
			assertEquals("Invalid index range.", e.getMessage());
		}
		try {
			mal.sublist(0, 9);
		} catch(Exception e) {
			assertEquals("Invalid index range.", e.getMessage());
		}
		String sub = mal.sublist(0, 2).toString();
		assertEquals(sub, "[1, 1]");
	}
	
	@Test
	public void testingAddAll() {
		Integer[] i = {1, 2, 3, 4, 5};
		MyArrayList mal = new MyArrayList(Integer.class);
		mal.addAll(i);
		//testing add all
		assertEquals("[1, 2, 3, 4, 5]", mal.toString());
	}
	
	@Test
	public void testingClearMAL() {
		Integer[] i = {1, 2, 3, 4, 5};
		MyArrayList mal = new MyArrayList(Integer.class);
		mal.addAll(i);
		mal.clear();
		//testing basic empty array
		assertEquals("[]", mal.toString());
		//testing to see if full array is correct
		assertEquals("[null, null, null, null, "
				+ "null, null, null, null, null, null]",
				mal.printFullArray());
	}
	
	@Test
	public void testingContains() {
		Integer[] i = {1, 2, 3, 4, 5};
		MyArrayList mal = new MyArrayList(Integer.class);
		mal.addAll(i);
		Integer six = 6;
		mal.add(six);
		//testing if it finds a specific object
		assertTrue(mal.contains(six));
		//testing to see if it finds something equal to an element
		assertTrue(mal.contains((Integer)1));
	}
	
	@Test
	public void testingToStringMAL() {
		Integer[] i = {1, 2, 3, 4, 5};
		MyArrayList mal = new MyArrayList(Integer.class);
		mal.addAll(i);
		//essentially the same as the add all method, it should work
		assertEquals("[1, 2, 3, 4, 5]", mal.toString());
		mal.clear();
		Integer one = 1;
		//with one object
		mal.add(one);
		assertEquals("[1]", mal.toString());
	}
	
	@Test
	public void testingPrintFullArray() {
		MyArrayList mal = new MyArrayList(Integer.class);
		Integer one = 1;
		mal.add(one);
		assertEquals("[1, null, null, null, null,"
				+ " null, null, null, null, null]"
				, mal.printFullArray());
	}
}