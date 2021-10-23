package com.novihub.shift.predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;

import com.novihub.logical.tree.LogicalNode;
import com.novihub.shift.predicate.MonthPredicate;

public class MonthPredicateTest {
	
	@Test
	public void invalidMonth() {
		assertThrows(IllegalArgumentException.class, () -> {
			MonthPredicate.month(null);	
		});
	}
	
	@Test
	public void isJanuary() {
		final LogicalNode<LocalDate> isJanuary = MonthPredicate.january();
		assertTrue(isJanuary.test(LocalDate.of(2021, Month.JANUARY, 1)));
		assertFalse(isJanuary.test(LocalDate.of(2021, Month.FEBRUARY, 1)));
	}
	
	@Test
	public void isFirstDayOfMonth() {
		final LogicalNode<LocalDate> isFirstDayOfMonth = MonthPredicate.firstDayOfMonth();
		assertTrue(isFirstDayOfMonth.test(LocalDate.of(2021, Month.JANUARY, 1)));
		assertFalse(isFirstDayOfMonth.test(LocalDate.of(2021, Month.FEBRUARY, 2)));
	}
	
	@Test
	public void isLastDayOfMonth() {
		final LogicalNode<LocalDate> isLastDayOfMonth = MonthPredicate.lastDayOfMonth();
		assertTrue(isLastDayOfMonth.test(LocalDate.of(2021, Month.JANUARY, 31)));
		assertFalse(isLastDayOfMonth.test(LocalDate.of(2021, Month.FEBRUARY, 2)));
	}
}
