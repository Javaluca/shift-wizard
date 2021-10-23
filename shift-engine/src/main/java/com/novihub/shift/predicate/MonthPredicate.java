package com.novihub.shift.predicate;

import java.time.LocalDate;
import java.time.Month;

import com.novihub.logical.tree.LogicalNode;
import com.novihub.logical.tree.impl.OrNode;

public class MonthPredicate {

	public static LogicalNode<LocalDate> month(Month month) {
		if (month == null) {
			throw new IllegalArgumentException("Invalid month");
		}
		return date -> {
			return date.getMonth().equals(month);
		};
	}
	
	public static LogicalNode<LocalDate> january() {
		return month(Month.JANUARY);
	}
	
	public static LogicalNode<LocalDate> february() {
		return month(Month.FEBRUARY);
	}
	
	public static LogicalNode<LocalDate> march() {
		return month(Month.MARCH);
	}
	
	public static LogicalNode<LocalDate> april() {
		return month(Month.APRIL);
	}
	
	public static LogicalNode<LocalDate> may() {
		return month(Month.MAY);
	}
	
	public static LogicalNode<LocalDate> june() {
		return month(Month.JUNE);
	}
	
	public static LogicalNode<LocalDate> july() {
		return month(Month.JULY);
	}
	
	public static LogicalNode<LocalDate> august() {
		return month(Month.AUGUST);
	}
	
	public static LogicalNode<LocalDate> september() {
		return month(Month.SEPTEMBER);
	}
	
	public static LogicalNode<LocalDate> october() {
		return month(Month.OCTOBER);
	}
	
	public static LogicalNode<LocalDate> november() {
		return month(Month.NOVEMBER);
	}
	
	public static LogicalNode<LocalDate> december() {
		return month(Month.DECEMBER);
	}
	
	public static LogicalNode<LocalDate> firstTrimester() {
		return OrNode.<LocalDate>instance()
				.add(january())
				.add(february())
				.add(march());
	}
	
	public static LogicalNode<LocalDate> secondTrimester() {
		return OrNode.<LocalDate>instance()
				.add(april())
				.add(may())
				.add(june());
	}
	
	public static LogicalNode<LocalDate> thirdTrimester() {
		return OrNode.<LocalDate>instance()
				.add(july())
				.add(august())
				.add(september());
	}
	
	public static LogicalNode<LocalDate> fourthTrimester() {
		return OrNode.<LocalDate>instance()
				.add(october())
				.add(november())
				.add(december());
	}
	
	public static LogicalNode<LocalDate> firstSemester() {
		return OrNode.<LocalDate>instance()
				.add(firstTrimester())
				.add(secondTrimester());
	}
	
	public static LogicalNode<LocalDate> secondSemester() {
		return OrNode.<LocalDate>instance()
				.add(thirdTrimester())
				.add(fourthTrimester());
	}
	
	/**
	 * First day of month
	 * @return
	 */
	public static LogicalNode<LocalDate> firstDayOfMonth() {
		return date -> {
			return 1 == date.getDayOfMonth();
		};
	}
	
	/**
	 * Last day of month
	 * @return
	 */
	public static LogicalNode<LocalDate> lastDayOfMonth() {
		return date -> {
			return date.lengthOfMonth() == date.getDayOfMonth();
		};
	}
}
