package com.novihub.shift.parser;

import org.junit.jupiter.api.Test;

import com.novihub.shift.parser.impl.LocalDateParser;

public class LocalDateParserTest {

	
	@Test
	public void simpleParser() {
		
		String expression = "(january() AND (monday() OR dayOfWeek(SUNDAY))";
		
		new LocalDateParser().parse(expression);
	}
}
