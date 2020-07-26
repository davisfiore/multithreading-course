package com.davis.course;

public class MessageBean {
	private String m;

	public synchronized String get() {
		return m;
	}

	public synchronized void set(final String m) {
		this.m = m;
	}
}
