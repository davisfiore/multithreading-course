package com.davis.course;

public class MessageBean {
	private String m;

	public synchronized String get() {
		return m;
	}

	public synchronized void set(String m) {
		this.m = m;
	}
}
