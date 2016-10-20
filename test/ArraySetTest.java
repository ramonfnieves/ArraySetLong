import static org.junit.Assert.*;

import org.junit.Test;

public class ArraySetTest {

	ElementType [] a = 

		{
				new LongElementType(1),
				new LongElementType(2),
				new LongElementType(3),
				new LongElementType(4),
				new LongElementType(5)
		};
	
	ArraySet s = new ArraySet(a, 5);
	
	ElementType [] b = 

		{
				new LongElementType(6),
				new LongElementType(7),
				new LongElementType(8),
				new LongElementType(9),
				new LongElementType(10)
		};
	
	ArraySet s2 = new ArraySet(b, 5);

	ArraySet emptySet = new ArraySet(10);

	@Test
	public void testBasic1() {
		ArraySet s = new ArraySet(10);
		assertNotNull("ArraySet(10): Null object reference returned",s);
		assertTrue("ArraySet(10): Non-empty set returned", s.isEmpty());
	}

	@Test
	public void testBasic2() {
		assertNotNull("ArraySet(a,5): Null object reference returned",s);
		assertFalse("ArraySet(a,5): Non-empty set returned", s.isEmpty());
		assertEquals("ArraySet(a,5): Non-empty set returned",s.cardinality(),5);
	}

	@Test
	public void testMaxMin() {
		assertEquals("max(): Wrong max returned", s.max(), new LongElementType(5));
		assertEquals("min(): Wrong min returned", s.min(), new LongElementType(1));
	}

	@Test
	public void testSum() {
		assertEquals("sum(): Wrong sum returned", s.sum(), 15);
	}

	@Test
	public void testProduct() {
		assertEquals("product(): Wrong product returned", s.product(), 120);
	}

	@Test
	public void testisMember() {
		assertTrue("isMember(): Did not find set member", s.isMember(new LongElementType(5)));
		assertFalse("isMember(): Found non-existent member", s.isMember(new LongElementType(6)));
		assertFalse("isMember(): Number found in empty set", emptySet.isMember(new LongElementType(6)));
	}

	@Test
	public void testaddMember() {
		s.addMember(new LongElementType(6));
		assertTrue("isMember():Did not find added set member", s.isMember(new LongElementType(6)));
	}

	@Test
	public void testdeleteMember() {
		s.deleteMember(new LongElementType(5));
		assertFalse("deleteMember(): Found deleted element", s.isMember(new LongElementType(5)));
	}

	@Test
	public void testUnion(){
		ArraySet result = s.union(s2);
		assertEquals("testUnion: Wrong cardinality", result.cardinality(), 10);
		ArraySet result2 = s.union(s);
		assertEquals("testUnion: Wrong cardinality", result2.cardinality(), 5);
		ArraySet result3 = emptySet.union(emptySet);
		assertEquals("testUnion: Wrong cardinality", result3.cardinality(), 0);
	}

	@Test
	public void testIntersection(){
		ArraySet result = s.union(s2);
		assertEquals("testUnion: Wrong cardinality", result.cardinality(), 10);
		ArraySet result2 = s.union(s);
		assertEquals("testUnion: Wrong cardinality", result2.cardinality(), 5);
		ArraySet result3 = emptySet.union(emptySet);
		assertEquals("testUnion: Wrong cardinality", result3.cardinality(), 0);
	}
}
