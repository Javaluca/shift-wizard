package com.novihub.shift.parser.impl.antlr4.providers;

import java.time.LocalDate;

import org.antlr.v4.runtime.tree.ParseTree;

import com.novihub.logical.tree.LogicalNode;
import com.novihub.logical.tree.impl.NotNode;
import com.novihub.shift.parser.impl.antlr4.NodeManager;
import com.novihub.shift.parser.impl.antlr4.NodeProvider;
import com.novihub.shift.parser.impl.antlr4.SimpleBooleanParser.NotExpressionContext;

public class NotProvider implements NodeProvider {
	
	private final NodeManager manager;
	
	public NotProvider(final NodeManager manager) {
		this.manager = manager;
	}

	@Override
	public boolean isValid(ParseTree t) {
		return t instanceof NotExpressionContext;
	}

	@Override
	public LogicalNode<LocalDate> transform(ParseTree t) {
		final LogicalNode<LocalDate> ret = this.manager.transform(t.getChild(1));
		
		return NotNode.instance(ret);
	}

}
