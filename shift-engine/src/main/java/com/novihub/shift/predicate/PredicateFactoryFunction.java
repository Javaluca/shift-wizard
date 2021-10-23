package com.novihub.shift.predicate;

import java.time.LocalDate;
import java.util.function.Predicate;

@FunctionalInterface
public interface PredicateFactoryFunction {
	
	Predicate<LocalDate> apply(Object...args);

}
