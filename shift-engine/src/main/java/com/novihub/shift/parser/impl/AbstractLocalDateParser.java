package com.novihub.shift.parser.impl;

import java.time.LocalDate;

import com.novihub.logical.tree.LogicalTree;
import com.novihub.shift.parser.LogicalParser;

public abstract class AbstractLocalDateParser implements LogicalParser<LocalDate> {

	@Override
	abstract public LogicalTree<LocalDate> parse(String expression);
	
}
