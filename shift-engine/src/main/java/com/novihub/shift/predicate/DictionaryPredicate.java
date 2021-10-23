package com.novihub.shift.predicate;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DictionaryPredicate {
	
	static Method[] methods;
	
	static {
		
		Collection<Method> collection = new ArrayList<Method>();
		collection.addAll(Arrays.asList(DayPredicate.class.getDeclaredMethods()));
		collection.addAll(Arrays.asList(WeekPredicate.class.getDeclaredMethods()));
		collection.addAll(Arrays.asList(MonthPredicate.class.getDeclaredMethods()));

		methods = collection.toArray(new Method[] {});
	}
	
	public static Method supplyPredicateFactory(String methodName, List<String> arguments) {
		return Arrays.stream(methods)
			.filter(m -> m.getName().equals(methodName))
			.filter(m -> m.getParameterCount() == arguments.size())
			.findAny()
			.orElseThrow(() -> new RuntimeException("Predicate factory not found"));
	}


}
