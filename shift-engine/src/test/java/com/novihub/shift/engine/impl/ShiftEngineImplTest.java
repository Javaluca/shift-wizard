package com.novihub.shift.engine.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.novihub.logical.tree.LogicalNode;
import com.novihub.logical.tree.LogicalTree;
import com.novihub.logical.tree.impl.AndNode;
import com.novihub.logical.tree.impl.OrNode;
import com.novihub.shift.engine.ShiftEngine;
import com.novihub.shift.predicate.MonthPredicate;
import com.novihub.shift.predicate.WeekPredicate;

public class ShiftEngineImplTest {
	
	/**
	 * Tutti i lunedì di gennaio 2021
	 */
	@Test
	public void sampleMondayOfJanuary() {
		final LogicalNode<LocalDate> root = AndNode.<LocalDate>instance()
				.add(WeekPredicate.monday())
				.add(MonthPredicate.january());
		
		final LogicalTree<LocalDate> tree = LogicalTree.createTree(root);
		
		final ShiftEngine engine = new ShiftEngineImpl(tree)
			.start(LocalDate.of(2021, Month.JANUARY, 1))
			.end(LocalDate.of(2021, Month.DECEMBER, 31));
		
		final List<LocalDate> dates = engine.evaluate();
		
		assertEquals(4, dates.size());
		assertEquals(4, dates.get(0).getDayOfMonth());	// 04/01/2021
		assertEquals(11, dates.get(1).getDayOfMonth());	// 11/01/2021
		assertEquals(18, dates.get(2).getDayOfMonth());	// 18/01/2021
		assertEquals(25, dates.get(3).getDayOfMonth()); // 25/01/2021
	}
	
	/**
	 * Tutti i primi e gli ultimi giorni del mese nel 2021
	 */
	@Test
	public void sampleFirstLastDayOfMonth() {
		final LogicalNode<LocalDate> root = OrNode.<LocalDate>instance()
				.add(MonthPredicate.firstDayOfMonth())
				.add(MonthPredicate.lastDayOfMonth());
		
		final LogicalTree<LocalDate> tree = LogicalTree.createTree(root);
		
		final ShiftEngine engine = new ShiftEngineImpl(tree)
			.start(LocalDate.of(2021, Month.JANUARY, 1))
			.end(LocalDate.of(2021, Month.DECEMBER, 31));
		
		final List<LocalDate> dates = engine.evaluate();
		
		assertEquals(24, dates.size());
	}

}
