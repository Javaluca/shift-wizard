package com.novihub.shift.predicate;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;

import com.novihub.logical.tree.LogicalNode;
import com.novihub.shift.predicate.DayPredicate;

public class DayPredicateTest {

	@Test
	public void invalidDayOfMonth() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			DayPredicate.dayOfMonth(-1);	
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			DayPredicate.dayOfMonth(32);	
		});
	}
	
	@Test
	public void dayOfMonth() {
		
		final LogicalNode<LocalDate> firstDayOfMonth = DayPredicate.dayOfMonth(1);
		
		assertTrue(firstDayOfMonth.test(LocalDate.of(2021, Month.JULY, 1)));
		assertFalse(firstDayOfMonth.test(LocalDate.of(2021, Month.JULY, 2)));
	}
	
	@Test
	public void evenDay() {
		final LogicalNode<LocalDate> firstDayOfMonth = DayPredicate.evenDay();
		
		assertFalse(firstDayOfMonth.test(LocalDate.of(2021, Month.JULY, 1)));
		assertTrue(firstDayOfMonth.test(LocalDate.of(2021, Month.JULY, 2)));
	}
	
	@Test
	public void oddDay() {
		final LogicalNode<LocalDate> firstDayOfMonth = DayPredicate.oddDay();
		
		assertTrue(firstDayOfMonth.test(LocalDate.of(2021, Month.JULY, 1)));
		assertFalse(firstDayOfMonth.test(LocalDate.of(2021, Month.JULY, 2)));
	}
	
}
