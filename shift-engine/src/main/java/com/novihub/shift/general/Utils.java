package com.novihub.shift.general;

import java.lang.reflect.Parameter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.stream.Stream;

import javax.management.RuntimeErrorException;

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
	
	public static Object convertString(Parameter parameter, String value) {
		if (String.class.equals(parameter.getType())) {
			return value;
		}
		if (Integer.class.equals(parameter.getType()) || int.class.equals(parameter.getType())) {
			return Integer.valueOf(value);
		}
		if (parameter.getType().isEnum()) {
			
			return Arrays.stream(parameter.getType().getEnumConstants())
				.filter(e -> e.toString().equals(value))
				.findFirst().orElse(null);
		}
		return null;
	}
	
}
