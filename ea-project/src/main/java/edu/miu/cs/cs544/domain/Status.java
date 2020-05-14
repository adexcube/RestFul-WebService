package edu.miu.cs.cs544.domain;

public enum Status {
	PENDING(0),
	ACCEPTED(1),
	DECLINED(2);
	
	private int numVal;

	Status(int numVal) {
		this.numVal = numVal;
	}

	public int getNumVal() {
		return numVal;
	}
}
