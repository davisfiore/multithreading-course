package com.davis.course;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class SafeCalendar {

	private final ThreadLocal<Calendar> calendar = new ThreadLocal<>() {
	
		@Override
		protected Calendar initialValue() {
			return new GregorianCalendar();
		}
	};

	public Calendar getCalendar() {
		return calendar.get();
	}
}
