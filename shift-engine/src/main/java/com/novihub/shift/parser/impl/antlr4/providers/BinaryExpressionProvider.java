package com.novihub.shift.parser.impl.antlr4.providers;

import java.time.LocalDate;

import org.antlr.v4.runtime.tree.ParseTree;

import com.novihub.logical.tree.LogicalNode;
import com.novihub.logical.tree.impl.MultiNode;
import com.novihub.shift.parser.impl.antlr4.NodeManager;
import com.novihub.shift.parser.impl.antlr4.NodeProvider;
import com.novihub.shift.parser.impl.antlr4.SimpleBooleanParser.BinaryExpressionContext;

public class BinaryExpressionProvider implements NodeProvider {
	
	private final NodeManager manager;
	
	public BinaryExpressionProvider(NodeManager manager) {
		this.manager = manager;
	}

	@Override
	public boolean isValid(ParseTree t) {
		return t instanceof BinaryExpressionContext;
	}

	@Override
	public LogicalNode<LocalDate> transform(ParseTree t) {
		if (t.getChildCount() != 3) {
			throw new RuntimeException("Bynary expression with invalid number of child");
		}
		
		final MultiNode<LocalDate> ret = (MultiNode<LocalDate>) this.manager.transform(t.getChild(1));
		ret.add(this.manager.transform(t.getChild(0)))
			.add(this.manager.transform(t.getChild(2)));
		return ret;
	}

}
