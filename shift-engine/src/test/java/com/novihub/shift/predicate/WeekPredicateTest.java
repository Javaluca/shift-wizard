package com.novihub.shift.predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;

import com.novihub.logical.tree.LogicalNode;
import com.novihub.shift.predicate.WeekPredicate;

public class WeekPredicateTest {

	@Test
	public void invalidDayOfWeek() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			WeekPredicate.dayOfWeek(null);	
		});
		
	}
	
	@Test
	public void isMonday() {
		final LogicalNode<LocalDate> isMonday = WeekPredicate.monday();
		
		assertFalse(isMonday.test(LocalDate.of(2021, Month.JULY, 18)));
		assertTrue(isMonday.test(LocalDate.of(2021, Month.JULY, 19)));
	}
	
	@Test
	public void isMondayFriday() {
		final LogicalNode<LocalDate> isMondayFriday = WeekPredicate.monFri();
		
		assertTrue(isMondayFriday.test(LocalDate.of(2021, Month.JULY, 19)));	// MONDAY
		assertFalse(isMondayFriday.test(LocalDate.of(2021, Month.JULY, 18)));	// SUNDAY
	}
	
	@Test
	public void isSaturdaySunday() {
		final LogicalNode<LocalDate> isSaturdaySunday = WeekPredicate.satSun();
		
		assertFalse(isSaturdaySunday.test(LocalDate.of(2021, Month.JULY, 19)));	// MONDAY
		assertTrue(isSaturdaySunday.test(LocalDate.of(2021, Month.JULY, 18)));	// SUNDAY
	}
}
