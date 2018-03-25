package it.lorciv.lexi.util;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

	private Point p1 = new Point(3, 4);
	private Point p2 = new Point(5, 6);
	
	@Test
	public void testEquals() {
		Assert.assertEquals(p1, new Point(3, 4));
		Assert.assertEquals(p2, new Point(5, 6));
	}
	
	@Test
	public void testGetters() {
		Assert.assertEquals(3, p1.getX());
		Assert.assertEquals(5, p2.getX());
		Assert.assertEquals(4, p1.getY());
		Assert.assertEquals(6, p2.getY());
	}
	
	@Test
	public void testSum() {
		Point result = new Point(8, 10);
		Assert.assertEquals(result, p1.sum(p2));
		Assert.assertEquals(result, p2.sum(p1));
	}
	
	@Test
	public void testSubtract() {
		Point result = new Point(-2, -2);
		Assert.assertEquals(result, p1.subtract(p2));
		result = new Point(2, 2);
		Assert.assertEquals(result, p2.subtract(p1));
	}
	
	@Test
	public void testMultiply() {
		Point result = new Point(15, 24);
		Assert.assertEquals(result, p1.multiply(p2));
		Assert.assertEquals(result, p2.multiply(p1));
	}
	
	@Test
	public void testDivide() {
		Point p1 = new Point(15, 33);
		Point p2 = new Point(5, 3);
		Assert.assertEquals(new Point(3, 11), p1.divide(p2));
	}
	
	@Test
	public void testOpposite() {
		Assert.assertEquals(new Point(-3, -4), p1.opposite());
		Assert.assertEquals(new Point(-5, -6), p2.opposite());
	}
	
}
