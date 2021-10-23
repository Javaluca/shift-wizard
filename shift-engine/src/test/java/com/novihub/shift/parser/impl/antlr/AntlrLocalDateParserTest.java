package com.novihub.shift.parser.impl.antlr;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.novihub.logical.tree.LogicalTree;
import com.novihub.shift.parser.impl.antlr4.AntlrLocalDateParser;
import com.novihub.shift.parser.impl.antlr4.NodeManager;
import com.novihub.shift.parser.impl.antlr4.providers.BinaryExpressionProvider;
import com.novihub.shift.parser.impl.antlr4.providers.BinaryProvider;
import com.novihub.shift.parser.impl.antlr4.providers.NotProvider;
import com.novihub.shift.parser.impl.antlr4.providers.PredicateExpressionProvider;
import com.novihub.shift.parser.impl.antlr4.providers.PredicateProvider;

public class AntlrLocalDateParserTest {
	
	private AntlrLocalDateParser parser;
	
	@BeforeEach
	public void init() {
		final NodeManager nm = new NodeManager();
		
		nm.addProvider(new PredicateExpressionProvider(nm))
			.addProvider(new PredicateProvider(nm))
			.addProvider(new NotProvider(nm))
			.addProvider(new BinaryExpressionProvider(nm))
			.addProvider(new BinaryProvider());
		
		this.parser = new AntlrLocalDateParser(nm);
	}
	

	@Test
	public void simpleJanuary() {
		String expression = "january";
		
		final LogicalTree<LocalDate> tree = this.parser.parse(expression);
		
		assertNotNull(tree);
		
		assertTrue(tree.test(LocalDate.of(2021, Month.JANUARY, 1)));
		assertFalse(tree.test(LocalDate.of(2021, Month.FEBRUARY, 1)));
	}
	
	@Test
	public void simpleAlternativeJanuary() {
		String expression = "january()";
		
		final LogicalTree<LocalDate> tree = this.parser.parse(expression);
		
		assertNotNull(tree);
		
		assertTrue(tree.test(LocalDate.of(2021, Month.JANUARY, 1)));
		assertFalse(tree.test(LocalDate.of(2021, Month.FEBRUARY, 1)));
	}
	
	@Test
	public void simpleNotJanuary() {
		String expression = "!january";
		
		final LogicalTree<LocalDate> tree = this.parser.parse(expression);
		
		assertNotNull(tree);
		
		assertFalse(tree.test(LocalDate.of(2021, Month.JANUARY, 1)));
		assertTrue(tree.test(LocalDate.of(2021, Month.FEBRUARY, 1)));
	}
	
	@Test
	public void simpleAlternativeNotJanuary() {
		String expression = "NOT january";
		
		final LogicalTree<LocalDate> tree = this.parser.parse(expression);
		
		assertNotNull(tree);
		
		assertFalse(tree.test(LocalDate.of(2021, Month.JANUARY, 1)));
		assertTrue(tree.test(LocalDate.of(2021, Month.FEBRUARY, 1)));
	}
	
	@Test
	public void simpleOrJanuaryOrFebruary() {
		String expression = "january OR february()";
		
		final LogicalTree<LocalDate> tree = this.parser.parse(expression);
		
		assertNotNull(tree);
		
		assertTrue(tree.test(LocalDate.of(2021, Month.JANUARY, 1)));
		assertTrue(tree.test(LocalDate.of(2021, Month.FEBRUARY, 1)));
	}
	
	@Test
	public void simpleAndJanuaryAndMonday() {
		String expression = "january AND monday()";
		
		final LogicalTree<LocalDate> tree = this.parser.parse(expression);
		
		assertNotNull(tree);
		
		assertTrue(tree.test(LocalDate.of(2021, Month.JANUARY, 4)));
		assertFalse(tree.test(LocalDate.of(2021, Month.FEBRUARY, 5)));
	}
	
	@Test
	public void simpleAndJanuaryAndNotMonday() {
		String expression = "january AND !monday()";
		
		final LogicalTree<LocalDate> tree = this.parser.parse(expression);
		
		assertNotNull(tree);
		
		assertFalse(tree.test(LocalDate.of(2021, Month.JANUARY, 4)));
		assertTrue(tree.test(LocalDate.of(2021, Month.JANUARY, 5)));
	}
	
	@Test
	public void simple_10_20_30_OfMonth() {
		String expression = "dayOfMonth(10) OR dayOfMonth(20) OR dayOfMonth(30)";
		
		final LogicalTree<LocalDate> tree = this.parser.parse(expression);
		
		assertNotNull(tree);
		
		assertFalse(tree.test(LocalDate.of(2021, Month.JANUARY, 1)));
		assertTrue(tree.test(LocalDate.of(2021, Month.JANUARY, 10)));
		assertFalse(tree.test(LocalDate.of(2021, Month.JANUARY, 15)));
		assertTrue(tree.test(LocalDate.of(2021, Month.JANUARY, 20)));
		assertFalse(tree.test(LocalDate.of(2021, Month.JANUARY, 25)));
		assertTrue(tree.test(LocalDate.of(2021, Month.JANUARY, 30)));
		assertFalse(tree.test(LocalDate.of(2021, Month.JANUARY, 31)));
	}
}
