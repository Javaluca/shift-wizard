package com.novihub.shift.parser.impl;

import java.time.LocalDate;
import java.util.StringTokenizer;

import com.novihub.logical.tree.LogicalTree;
import com.novihub.shift.parser.LogicalParser;

public class LocalDateParser implements LogicalParser<LocalDate> {

	@Override
	public LogicalTree<LocalDate> parse(String expression) {
		final StringTokenizer st = new StringTokenizer(expression);
		
		while (st.hasMoreTokens()) {
	         System.out.println(st.nextToken());
	     }
		
		return null;
	}

}
