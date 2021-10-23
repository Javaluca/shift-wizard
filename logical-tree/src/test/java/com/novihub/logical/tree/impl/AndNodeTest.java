package com.novihub.logical.tree.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AndNodeTest {

	@Test
	public void invalidAndNodeNoChildren() {
		final AndNode<Object> andNode = AndNode.instance();
		
		assertThrows(IllegalArgumentException.class, () -> {
			andNode.test(null);
		});
	}
	
	@Test
	public void invalidAndNodeSingleChildren() {
		final AndNode<Object> andNode = AndNode.instance()
				.add(p -> true);
		
		assertThrows(IllegalArgumentException.class, () -> {
			andNode.test(null);
		});
	}
	
	@Test
	public void validAndNodePositive() {
		final AndNode<Object> andNode = AndNode.instance()
				.add(p -> true)
				.add(p -> true);
		
		assertTrue(andNode.test(null));
	}
	
	@Test
	public void validAndNodeNegative() {
		final AndNode<Object> andNode = AndNode.instance()
				.add(p -> true)
				.add(p -> false);
		
		assertFalse(andNode.test(null));
	}
}
