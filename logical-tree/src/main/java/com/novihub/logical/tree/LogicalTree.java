package com.novihub.logical.tree;

import java.util.function.Predicate;

public class LogicalTree<T> implements Predicate<T> {
	
	private final LogicalNode<T> root;
	
	private LogicalTree(LogicalNode<T> root) {
		if (root == null) {
			throw new IllegalArgumentException("Invalid tree root node");
		}
		this.root = root;
	}
	
	public static <T> LogicalTree<T> createTree(LogicalNode<T> root) {
		return new LogicalTree<T>(root);
	}

	public boolean test(T t) {
		return root.test(t);
	}

}
