package com.novihub.shift.parser;

import com.novihub.logical.tree.LogicalTree;

public interface LogicalParser<T> {

	LogicalTree<T> parse(String expression);
	
}
