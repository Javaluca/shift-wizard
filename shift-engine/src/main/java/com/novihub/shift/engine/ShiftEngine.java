package com.novihub.shift.engine;

import java.time.LocalDate;
import java.util.List;

public interface ShiftEngine {
	
	List<LocalDate> evaluate();

}
