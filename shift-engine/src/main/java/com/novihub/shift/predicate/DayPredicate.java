package com.novihub.shift.predicate;

import java.time.LocalDate;

import com.novihub.logical.tree.LogicalNode;
import com.novihub.logical.tree.impl.NotNode;

public class DayPredicate {
	
	/**
	 * Giorno del mese
	 * @param day
	 * @return
	 */
	public static LogicalNode<LocalDate> dayOfMonth(int day) {
		if (day < 1) {
			throw new IllegalArgumentException("Invalid day of month " + day);
		}
		if (day > 31) {
			throw new IllegalArgumentException("Invalid day of month " + day);
		}
		
		return date -> {
			return date.getDayOfMonth() == day;
		};
	}
	
	/**
	 * Giorni pari
	 * @return
	 */
	public static LogicalNode<LocalDate> evenDay() {
		return date -> {
			return date.getDayOfMonth() % 2 == 0;
		};
	}
	
	/**
	 * Giorni dispari
	 * @return
	 */
	public static LogicalNode<LocalDate> oddDay() {
		return NotNode.instance(evenDay());
	}
	


}
