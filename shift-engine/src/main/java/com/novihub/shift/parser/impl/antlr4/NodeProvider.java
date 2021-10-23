package com.novihub.shift.parser.impl.antlr4;

import java.time.LocalDate;

import org.antlr.v4.runtime.tree.ParseTree;

import com.novihub.logical.tree.LogicalNode;

public interface NodeProvider {
	
	boolean isValid(final ParseTree t);
	
	LogicalNode<LocalDate> transform(final ParseTree t);

}
