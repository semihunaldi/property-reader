package com.semihunaldi.processing.propertyreader;

/**
 * Created by semihunaldi on 9.04.2019
 */
public class Property {

	private Object value;

	public Property() {
	}

	public Property(Object value) {
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getString() {
		return (String) value;
	}

	public boolean getBool() {
		return Boolean.valueOf(getString());
	}

	public int getInt() {
		return Integer.valueOf(getString());
	}

	public Long getLong() {
		return Long.valueOf(getString());
	}

	public Double getDouble() {
		return Double.valueOf(getString());
	}

	@Override
	public String toString() {
		return getString();
	}
}
