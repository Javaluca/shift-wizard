package com.novihub.shift.parser.impl.antlr4.providers;

import java.time.LocalDate;

import org.antlr.v4.runtime.tree.ParseTree;

import com.novihub.logical.tree.LogicalNode;
import com.novihub.shift.parser.impl.antlr4.NodeManager;
import com.novihub.shift.parser.impl.antlr4.NodeProvider;
import com.novihub.shift.parser.impl.antlr4.SimpleBooleanParser.PredicateExpressionContext;

public class PredicateExpressionProvider implements NodeProvider {
	
	private final NodeManager manager;
	
	public PredicateExpressionProvider(final NodeManager manager) {
		this.manager = manager;
	}

	@Override
	public boolean isValid(ParseTree t) {
		return t instanceof PredicateExpressionContext;
	}

	@Override
	public LogicalNode<LocalDate> transform(ParseTree t) {
		if (t.getChildCount() == 1) {
			return this.manager.transform(t.getChild(0));
		}
		throw new RuntimeException("Invalid predicate expression");
	}

}
