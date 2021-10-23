package com.novihub.logical.tree.impl;

import java.util.ArrayList;
import java.util.List;

import com.novihub.logical.tree.LogicalNode;

public class MultiNode<T> implements LogicalNode<T> {
	
	private final List<LogicalNode<T>> children;
	
	protected MultiNode() {
		this.children = new ArrayList<LogicalNode<T>>();
	}
	
	public <X extends MultiNode<T>> X add(LogicalNode<T> node) {
		this.children.add(node);
		return (X) this;
	}

	public boolean test(T t) {
		if (this.children == null || this.children.size() == 0) {
			throw new IllegalArgumentException("And node without children");
		}
		if (this.children.size() == 1) {
			throw new IllegalArgumentException("And node with single children");
		}
		return true;
	}

	public List<LogicalNode<T>> getChildren() {
		return this.children;
	}
	
}
