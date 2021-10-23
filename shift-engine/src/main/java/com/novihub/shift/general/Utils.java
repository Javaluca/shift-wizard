package com.novihub.shift.general;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

public class Utils {

	public static Stream<LocalDate> streamBetweenDates(final LocalDate start, final LocalDate end) {
		if (start == null) {
			throw new IllegalArgumentException("Invalid start date");
		}
		if (end == null) {
			throw new IllegalArgumentException("Invalid end date");
		}
		if (start.isAfter(end)) {
			throw new IllegalArgumentException("Invalid date interval");
		}
		
		long limit = ChronoUnit.DAYS.between(start, end) + 1;
		return Stream.iterate(start, date -> date.plusDays(1)).limit(limit);
	}
}
