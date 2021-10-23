package com.novihub.logical.tree.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class OrNodeTest {

	@Test
	public void invalidOrNodeNoChildren() {
		final OrNode<Object> orNode = OrNode.instance();
		
		// NO CHILDREN
		assertThrows(IllegalArgumentException.class, () -> {
			orNode.test(null);
		});
	}
	
	@Test
	public void invalidAndNodeSingleChildren() {
		final OrNode<Object> orNode = OrNode.instance()
				.add(p -> true);
		
		assertThrows(IllegalArgumentException.class, () -> {
			orNode.test(null);
		});
	}
	
	@Test
	public void validAndNodePositive() {
		final OrNode<Object> orNode = OrNode.instance()
				.add(p -> true)
				.add(p -> true);
		
		assertTrue(orNode.test(null));
	}
	
	@Test
	public void validAndNodeNegative() {
		final OrNode<Object> orNode = OrNode.instance()
				.add(p -> false)
				.add(p -> false);
		
		assertFalse(orNode.test(null));
	}
	
}
