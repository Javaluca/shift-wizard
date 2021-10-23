package com.novihub.logical.tree.impl;

import com.novihub.logical.tree.LogicalNode;

public class NotNode<T> implements LogicalNode<T> {
	
	private final LogicalNode<T> node;
	
	private NotNode(LogicalNode<T> node) {
		if (node == null) {
			throw new IllegalArgumentException("Invalid logical node for NotNode");
		}
		this.node = node;
	}
	
	public static <T> NotNode<T> instance(LogicalNode<T> node) {
		return new NotNode<T>(node);
	}

	public boolean test(T t) {
		return this.node.negate().test(t);
	}

}
