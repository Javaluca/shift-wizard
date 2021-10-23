package com.novihub.logical.tree.impl;

import com.novihub.logical.tree.LogicalNode;

public class AndNode<T> extends MultiNode<T> {
	
	private AndNode() {
		super();
	}
	
	public static <T> AndNode<T> instance() {
		return new AndNode<T>();
	}
	
	public boolean test(T t) {
		super.test(t);
		
		for (LogicalNode<T> logicalNode : super.getChildren()) {
			if (!logicalNode.test(t)) {
				return false;
			}
		}
		return true;
	}
	
}
