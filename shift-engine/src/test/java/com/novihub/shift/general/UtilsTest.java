package com.novihub.shift.general;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.Month;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class UtilsTest {

	@Test
	public void daysBetweenDatesTest() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			Utils.streamBetweenDates(null, null);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			Utils.streamBetweenDates(LocalDate.of(2021, Month.JANUARY, 1), null);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			Utils.streamBetweenDates(null, LocalDate.of(2021, Month.DECEMBER, 31));
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			Utils.streamBetweenDates(LocalDate.of(2021, Month.DECEMBER, 31), LocalDate.of(2021, Month.JANUARY, 1));
		});
		
		Stream<LocalDate> dates = Utils.streamBetweenDates(LocalDate.of(2021, Month.JANUARY, 1), LocalDate.of(2021, Month.DECEMBER, 31));
		assertEquals(365, dates.count());
		
		dates = Utils.streamBetweenDates(LocalDate.of(2021, Month.JANUARY, 1), LocalDate.of(2021, Month.JANUARY, 31));
		assertEquals(31, dates.count());
	}
	
	public void fakeMethod(String str, Integer num, Month month) {
		
	}
	
	@Test
	public void convertString() throws NoSuchMethodException, SecurityException {
		Method method = UtilsTest.class.getMethod("fakeMethod", String.class, Integer.class, Month.class);
		assertEquals("ciao", Utils.convertString(method.getParameters()[0], "ciao"));
		assertEquals(10, Utils.convertString(method.getParameters()[1], "10"));
		assertEquals(Month.JANUARY, Utils.convertString(method.getParameters()[2], "JANUARY"));
	}
}
