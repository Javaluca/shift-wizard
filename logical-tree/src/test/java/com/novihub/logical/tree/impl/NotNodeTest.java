package com.novihub.logical.tree.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NotNodeTest {

	@Test
	public void invalidNotNode() {
		assertThrows(IllegalArgumentException.class, () -> {
			NotNode.instance(null);	
		});
	}
	
	@Test
	public void validNotNode() {
		final NotNode<Object> notNode = NotNode.instance(p -> true);
		assertFalse(notNode.test(null));
		
		final NotNode<Object> doubleNotNode = NotNode.instance(notNode);
		assertTrue(doubleNotNode.test(null));
	}
}
