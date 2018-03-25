package it.lorciv.lexi.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RectTest {

	private Rect r;

	@Before
	public void setUp() {
		r = new Rect(new Point(0, 0), new Point(8, 10));
	}

	@Test
	public void testEquals() {
		Assert.assertEquals(r, new Rect(new Point(0, 0), new Point(8, 10)));
	}

	@Test
	public void testGetters() {
		Assert.assertEquals(new Point(0, 0), r.getOrigin());
		Assert.assertEquals(new Point(8, 10), r.getExtent());
		Assert.assertEquals(8, r.getWidth());
		Assert.assertEquals(10, r.getHeight());
	}

	@Test
	public void testMoveBy() {
		r = r.moveBy(new Point(1, 2));
		Assert.assertEquals(r, new Rect(new Point(1, 2), new Point(9, 12)));
	}

	@Test
	public void testMoveTo() {
		r = r.moveTo(new Point(5, 5));
		Assert.assertEquals(r, new Rect(new Point(5, 5), new Point(13, 15)));
	}

	@Test
	public void testIsEmpty() {
		Rect emptyRect = new Rect(new Point(6, 3), new Point(6, 3));
		Assert.assertTrue(emptyRect.isEmpty());
	}

	@Test
	public void testContains() {
		Assert.assertTrue(r.contains(new Point(3, 4)));
		Assert.assertFalse(r.contains(new Point(13, 14)));
	}

	@Test
	public void test() {
		Rect r = new Rect(new Point(0, 0), new Point(10, 10));
		System.out.println(r);
		System.out.println(r.isEmpty());
		System.out.println(r.getWidth());
		r.moveBy(new Point(3, 3));
		System.out.println(r);
		r.moveTo(new Point(5, 5));
		System.out.println(r);
		r.moveTo(new Point(1, 4));
		System.out.println(r);
		System.out.println(r.contains(new Point(3, 12)));
		System.out.println(r.contains(new Point(3, 16)));
	}

}
