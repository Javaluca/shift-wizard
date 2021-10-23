package com.novihub.logical.tree.impl;

import com.novihub.logical.tree.LogicalNode;

public class OrNode<T> extends MultiNode<T> {
	
	private OrNode() {
		super();
	}
	
	public static <T> OrNode<T> instance() {
		return new OrNode<T>();
	}
	
	public boolean test(T t) {
		super.test(t);
		
		for (LogicalNode<T> logicalNode : super.getChildren()) {
			if (logicalNode.test(t)) {
				return true;
			}
		}
		return false;
	}
	
}
