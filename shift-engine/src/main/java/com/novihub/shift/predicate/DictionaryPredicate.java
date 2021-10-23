package com.novihub.shift.predicate;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class DictionaryPredicate {
	
	public static Method supplyPredicateFactory(String methodName, List<String> arguments) {
		final Method[] metodi = DayPredicate.class.getDeclaredMethods();
		
		return Arrays.stream(metodi)
			.filter(m -> m.getParameterCount() == arguments.size())
			.findAny()
			.orElseThrow(() -> new RuntimeException("Predicate factory not found"));
	}


}
