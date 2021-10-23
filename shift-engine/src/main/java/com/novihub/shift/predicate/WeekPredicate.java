package com.novihub.shift.predicate;

import java.time.DayOfWeek;
import java.time.LocalDate;

import com.novihub.logical.tree.LogicalNode;

public class WeekPredicate {

	public static LogicalNode<LocalDate> dayOfWeek(DayOfWeek dayOfWeek) {
		if (dayOfWeek == null) {
			throw new IllegalArgumentException("Invalid day of week");
		}
		
		return date -> {
			return date.getDayOfWeek().equals(dayOfWeek);
		};
	}
	
	public static LogicalNode<LocalDate> monday() {
		return dayOfWeek(DayOfWeek.MONDAY);
	}
	
	public static LogicalNode<LocalDate> tuesday() {
		return dayOfWeek(DayOfWeek.TUESDAY);
	}
	
	public static LogicalNode<LocalDate> thursday() {
		return dayOfWeek(DayOfWeek.THURSDAY);
	}
	
	public static LogicalNode<LocalDate> wednesday() {
		return dayOfWeek(DayOfWeek.WEDNESDAY);
	}
	
	public static LogicalNode<LocalDate> friday() {
		return dayOfWeek(DayOfWeek.FRIDAY);
	}
	
	public static LogicalNode<LocalDate> saturday() {
		return dayOfWeek(DayOfWeek.SATURDAY);
	}
	
	public static LogicalNode<LocalDate> sunday() {
		return dayOfWeek(DayOfWeek.SUNDAY);
	}
	
	public static LogicalNode<LocalDate> monFri() {
		return date -> {
			return date.getDayOfWeek().getValue() <= DayOfWeek.FRIDAY.getValue();
		};
	}
	
	public static LogicalNode<LocalDate> satSun() {
		return date -> {
			return date.getDayOfWeek().getValue() > DayOfWeek.FRIDAY.getValue();
		};
	}
}
