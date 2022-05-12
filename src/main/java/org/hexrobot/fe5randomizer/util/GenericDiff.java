package org.hexrobot.fe5randomizer.util;

public class GenericDiff<K> {
	private K key;
	private int value;
	
	public GenericDiff(K key, int value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}