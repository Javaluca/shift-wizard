package com.novihub.logical.tree;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LogicalTreeTest {

	@Test
	public void invalidLogicalTreeCreation() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			LogicalTree.createTree(null);
		});
	}
	
	@Test
	public void simpleLogicalTreeCreation() {
		LogicalNode<Object> root = (Object p) -> {
			return true;	
		};
		
		final LogicalTree<Object> tree = LogicalTree.createTree(root);
		
		assertTrue(tree.test(null));
	}
}
