package com.novihub.shift.parser.impl.antlr4.providers;

import java.time.LocalDate;

import org.antlr.v4.runtime.tree.ParseTree;

import com.novihub.logical.tree.LogicalNode;
import com.novihub.logical.tree.impl.AndNode;
import com.novihub.logical.tree.impl.OrNode;
import com.novihub.shift.parser.impl.antlr4.NodeProvider;
import com.novihub.shift.parser.impl.antlr4.SimpleBooleanParser.BinaryContext;

public class BinaryProvider implements NodeProvider {

	@Override
	public boolean isValid(ParseTree t) {
		return t instanceof BinaryContext;
	}

	@Override
	public LogicalNode<LocalDate> transform(ParseTree t) {
		if ("AND".equals(t.getText())) {
			return AndNode.instance();
		} else if ("OR".equals(t.getText())) {
			return OrNode.instance();
		}
		throw new RuntimeException("Invalid binary expression");
	}

}
